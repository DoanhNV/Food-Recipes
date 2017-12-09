package com.nganle.dto;

import java.util.ArrayList;
import java.util.List;

import com.nganle.dao.KindOfCateDAO;
import com.nganle.dao.impl.KindOfCateDAOImpl;
import com.nganle.entity.KindOfCate;
import com.nganle.entity.RecipeCategory;
import com.nganle.support.constant.Constant;
import com.nganle.support.util.DateFormator;

public class RecipeCateDTO {
	private int id;
	private String title;
	private int kindId;
	private String kindTitle;
	private String createTime;
	private String status;

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

	public int getKindId() {
		return kindId;
	}

	public void setKindId(int kindId) {
		this.kindId = kindId;
	}

	public String getKindTitle() {
		return kindTitle;
	}

	public void setKindTitle(String kindTitle) {
		this.kindTitle = kindTitle;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static List<RecipeCateDTO> toListDTO(List<RecipeCategory> cates) {
		KindOfCateDAO kindDAO = new KindOfCateDAOImpl();
		List<KindOfCate> kinds = kindDAO.listAll();
		List<RecipeCateDTO> result = new ArrayList<RecipeCateDTO>();
		for (RecipeCategory cate : cates) {
			RecipeCateDTO dto = new RecipeCateDTO();
			dto.setId(cate.getId());
			dto.setTitle(cate.getCateTitle());
			for (KindOfCate kind : kinds) {
				if (kind.getId() == cate.getKindId()) {
					dto.setKindId(kind.getId());
					dto.setKindTitle(kind.getKindTitle());
					break;
				}
			}
			dto.setCreateTime(DateFormator.format_yyyy_MM_dd_hh_mm(cate.getCreateTime()));
			String status = cate.getStatus() == 1 ? Constant.STATUS.ACTIVE : Constant.STATUS.DEACTIVE;
			dto.setStatus(status);
			result.add(dto);
		}
		return result;
	}
	
	public static List<List<RecipeCateDTO>> toPageList(List<RecipeCateDTO> list){
		List<List<RecipeCateDTO>> result = new ArrayList<List<RecipeCateDTO>>();
		List<RecipeCateDTO> element = new ArrayList<RecipeCateDTO>();
		for (int i = 0; i < list.size(); i++) {
			element.add(list.get(i));
			if((i+1) % Constant.NUMBER_PERPAGE == 0) {
				result.add(element);
				element = new ArrayList<RecipeCateDTO>();
			}
		}
		
		if(element.size() != 0 ) {
			result.add(element);
		}
		return result;
	}
}
