package com.nganle.dto;

import java.util.ArrayList;
import java.util.List;

import com.nganle.dao.TipCateDAO;
import com.nganle.dao.impl.TipCateDAOImpl;
import com.nganle.entity.Tip;
import com.nganle.entity.TipCategory;
import com.nganle.support.constant.Constant;
import com.nganle.support.util.Utils;

public class TipForHomeDTO {

	private int id;
	private String title;
	private String featureImage;
	private int views;
	private String author;
	private int cateId;
	private String cateName;
	private String content;

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

	public String getFeatureImage() {
		return featureImage;
	}

	public void setFeatureImage(String featureImage) {
		this.featureImage = featureImage;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getCateId() {
		return cateId;
	}

	public void setCateId(int cateId) {
		this.cateId = cateId;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public static List<TipForHomeDTO> toListDTO(List<Tip> tips) {
		List<TipForHomeDTO> result = new ArrayList<TipForHomeDTO>();
		if (tips == null) {
			return result;
		}
		TipCateDAO cateDAO = new TipCateDAOImpl();
		for (Tip tip : tips) {
			TipForHomeDTO dto = new TipForHomeDTO();
			dto.setId(tip.getId());
			dto.setTitle(tip.getTitle());
			dto.setViews(tip.getView());
			dto.setFeatureImage(Utils.convertToFileByte(tip.getFeatureImage()));
			List<Integer> tipCateIds = tip.getTipCateIds();
			dto.setCateId(tipCateIds.get(0));
			TipCategory cate = cateDAO.getById(tipCateIds.get(0));
			dto.setCateName(cate.getCateName());
			result.add(dto);
		}
		return result;
	}
	
	public static TipForHomeDTO toListDTODetail(Tip tip) {
		TipForHomeDTO dto = new TipForHomeDTO();
		if (tip == null) {
			return dto;
		}
		TipCateDAO cateDAO = new TipCateDAOImpl();
		dto.setId(tip.getId());
		dto.setTitle(tip.getTitle());
		dto.setViews(tip.getView());
		dto.setFeatureImage(Utils.convertToFileByte(tip.getFeatureImage()));
		List<Integer> tipCateIds = tip.getTipCateIds();
		dto.setCateId(tipCateIds.get(0));
		TipCategory cate = cateDAO.getById(tipCateIds.get(0));
		dto.setCateName(cate.getCateName());
		dto.setContent(tip.getContent());
		return dto;
	}

	public static List<List<TipForHomeDTO>> toPageList(List<TipForHomeDTO> list) {
		List<List<TipForHomeDTO>> result = new ArrayList<List<TipForHomeDTO>>();
		if (list == null) {
			return result;
		}
		List<TipForHomeDTO> element = new ArrayList<TipForHomeDTO>();
		for (int i = 0; i < list.size(); i++) {
			element.add(list.get(i));
			if ((i + 1) % Constant.NUMBER_PER_PAGE_TIP_SEARCH == 0) {
				result.add(element);
				element = new ArrayList<TipForHomeDTO>();
			}
		}

		if (element.size() != 0) {
			result.add(element);
		}
		return result;
	}
}
