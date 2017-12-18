package com.nganle.dto;

import java.util.ArrayList;
import java.util.List;

import com.nganle.entity.RecipeCategory;

public class RecipeCateSearchDTO {
	private int id;
	private String title;
	private String checked;

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

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}
	
	
	public static List<RecipeCateSearchDTO> toListDTO(List<RecipeCategory> cates ){
		List<RecipeCateSearchDTO> result = new ArrayList<RecipeCateSearchDTO>();
		for (RecipeCategory cate : cates) {
			RecipeCateSearchDTO dto = new RecipeCateSearchDTO();
			dto.setId(cate.getId());
			dto.setTitle(cate.getCateTitle());
			result.add(dto);
		}
		return result;
	}
}
