package com.nganle.dto;

import java.util.ArrayList;
import java.util.List;

import com.nganle.entity.KindOfCate;
import com.nganle.support.constant.Constant;
import com.nganle.support.util.DateFormator;

public class KindOfCateDTO {
	private int id;
	private String title;
	private String createTime;
	private String status;

	public KindOfCateDTO() {

	}

	public KindOfCateDTO(int id, String title) {
		super();
		this.id = id;
		this.title = title;
	}

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static List<KindOfCateDTO> toListDTO(List<KindOfCate> kinds) {
		List<KindOfCateDTO> result = new ArrayList<KindOfCateDTO>();
		for (KindOfCate kind : kinds) {
			KindOfCateDTO dto = new KindOfCateDTO();
			dto.setId(kind.getId());
			dto.setTitle(kind.getKindTitle());
			dto.setCreateTime(DateFormator.format_yyyy_MM_dd_hh_mm(kind.getCreateTime()));
			dto.setStatus(kind.getStatus() == 1 ? Constant.STATUS.ACTIVE : Constant.STATUS.DEACTIVE);
			result.add(dto);
		}
		return result;
	}

	public static List<List<KindOfCateDTO>> toPageList(List<KindOfCateDTO> list) {
		List<List<KindOfCateDTO>> result = new ArrayList<List<KindOfCateDTO>>();
		List<KindOfCateDTO> element = new ArrayList<KindOfCateDTO>();
		for (int i = 0; i < list.size(); i++) {
			element.add(list.get(i));
			if ((i + 1) % Constant.NUMBER_PERPAGE == 0) {
				result.add(element);
				element = new ArrayList<KindOfCateDTO>();
			}
		}

		if (element.size() != 0) {
			result.add(element);
		}
		return result;
	}

}
