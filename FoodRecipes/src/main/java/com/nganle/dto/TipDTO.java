package com.nganle.dto;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.Base64Utils;

import com.nganle.dao.TipCateDAO;
import com.nganle.dao.impl.TipCateDAOImpl;
import com.nganle.entity.Tip;
import com.nganle.entity.TipCategory;
import com.nganle.support.constant.Constant;
import com.nganle.support.util.DateFormator;

public class TipDTO {
	private int id;
	private String title;
	private String cates;
	private String image;
	private String status;
	private String createTime;
	private int view;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCates() {
		return cates;
	}

	public void setCates(String cates) {
		this.cates = cates;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public static List<TipDTO> toListDTO(List<Tip> tips) {
		List<TipDTO> result = new ArrayList<TipDTO>();
		TipCateDAO cateDAO = new TipCateDAOImpl();
		List<TipCategory> cates = cateDAO.listAll();

		for (Tip tip : tips) {
			TipDTO dto = new TipDTO();
			dto.setId(tip.getId());
			dto.setTitle(tip.getTitle());
			List<Integer> list = tip.getTipCateIds();
			String cateData = "";
			for (TipCategory cate : cates) {
				if (list.contains(cate.getId())) {
					cateData += cate.getCateName() + "<br/>";
				}
			}
			if(cateData.length() > 0) {
				cateData = cateData.substring(0, cateData.length() - 5);
			}
			dto.setCates(cateData);

			String fileByte = "data:image/png;base64,";
			try {
				byte[] fileBytes = Files.readAllBytes(new File(tip.getFeatureImage()).toPath());
				byte[] code = Base64Utils.encode(fileBytes);
				fileByte += new String(code, "UTF-8");
			} catch (IOException e) {
				e.printStackTrace();
			}
			dto.setImage(fileByte);

			String status = tip.getStatus() == 1 ? Constant.STATUS.ACTIVE : Constant.STATUS.DEACTIVE;
			dto.setStatus(status);
			dto.setCreateTime(DateFormator.format_yyyy_MM_dd_hh_mm(tip.getCreateTime()));
			dto.setView(tip.getView());
			result.add(dto);
		}
		return result;
	}

	public static List<List<TipDTO>> toPageList(List<TipDTO> list) {
		List<List<TipDTO>> result = new ArrayList<List<TipDTO>>();
		List<TipDTO> element = new ArrayList<TipDTO>();
		int size = list.size();
		for (int i = 0; i < size; i++) {
			element.add(list.get(i));
			if ((i + 1) % Constant.NUMBER_PERPAGE == 0) {
				result.add(element);
				element = new ArrayList<TipDTO>();
			}
		}

		if (element.size() != 0) {
			result.add(element);
		}
		return result;
	}

}
