package com.nganle.dto;

import java.util.ArrayList;
import java.util.List;

import com.nganle.entity.TipCategory;
import com.nganle.support.constant.Constant;
import com.nganle.support.util.DateFormator;

public class TipCateDTO {
	private int id;
	private String title;
	private String createTime;
	private int numberOfTips;
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

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public int getNumberOfTips() {
		return numberOfTips;
	}

	public void setNumberOfTips(int numberOfTips) {
		this.numberOfTips = numberOfTips;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static List<TipCateDTO> toListDTO(List<TipCategory> cates) {
		List<TipCateDTO> result = new ArrayList<TipCateDTO>();
		for (TipCategory cate : cates) {
			TipCateDTO dto = new TipCateDTO();
			dto.setId(cate.getId());
			dto.setTitle(cate.getCateName());
			dto.setNumberOfTips(cate.getNumberOfTips());
			String createTime = DateFormator.format_yyyy_MM_dd_hh_mm(cate.getCreateTime());
			dto.setCreateTime(createTime);
			String status = cate.getStatus() == 1 ? Constant.STATUS.ACTIVE : Constant.STATUS.DEACTIVE;
			dto.setStatus(status);
			result.add(dto);
		}
		return result;
	}

	public static List<List<TipCateDTO>> toPageList(List<TipCateDTO> list) {
		List<List<TipCateDTO>> result = new ArrayList<List<TipCateDTO>>();
		List<TipCateDTO> element = new ArrayList<TipCateDTO>();
		for (int i = 0; i < list.size(); i++) {
			element.add(list.get(i));
			if ((i + 1) % Constant.NUMBER_PERPAGE == 0) {
				result.add(element);
				element = new ArrayList<TipCateDTO>();
			}
		}
		if (element.size() != 0) {
			result.add(element);
		}
		return result;
	}

}
