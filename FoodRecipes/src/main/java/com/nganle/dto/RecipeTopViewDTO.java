package com.nganle.dto;

import java.util.ArrayList;
import java.util.List;

import com.nganle.entity.Recipe;
import com.nganle.support.constant.Constant;
import com.nganle.support.util.DateFormator;
import com.nganle.support.util.Utils;

public class RecipeTopViewDTO {
	private int id;
	private String title;
	private String featureImage;
	private int views;
	private String createTime;

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

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public static List<RecipeTopViewDTO> toListDTO(List<Recipe> recipes) {
		List<RecipeTopViewDTO> result = new ArrayList<RecipeTopViewDTO>();
		if(recipes == null) {
			return result;
		}
		for (Recipe recipe : recipes) {
			RecipeTopViewDTO dto = new RecipeTopViewDTO();
			dto.setId(recipe.getId());
			String title = recipe.getTitle().length() >= 21 ? recipe.getTitle().subSequence(0, 20) + "..." : recipe.getTitle();
			dto.setTitle(title);
			dto.setCreateTime(DateFormator.format_yyyy_MM_dd(recipe.getCreateTime()));
			dto.setFeatureImage(Utils.convertToFileByte(recipe.getFeatureImage()));
			dto.setViews(recipe.getViews());
			result.add(dto);
		}
		return result;
	}

	public static List<RecipeTopViewDTO> toListDTOForDetail(List<Recipe> recipes){
		List<RecipeTopViewDTO> result = new ArrayList<RecipeTopViewDTO>();
		if(recipes == null) {
			return result;
		}
		for (Recipe recipe : recipes) {
			RecipeTopViewDTO dto = new RecipeTopViewDTO();
			dto.setId(recipe.getId());
			String title = recipe.getTitle().length() <= Constant.MAX_SUGGEST_TITLE_LENGTH ? recipe.getTitle() : recipe.getTitle().substring(0,25) + "...";
			dto.setTitle(title);
			dto.setCreateTime(DateFormator.format_yyyy_MM_dd(recipe.getCreateTime()));
			dto.setFeatureImage(Utils.convertToFileByte(recipe.getFeatureImage()));
			dto.setViews(recipe.getViews());
			result.add(dto);
		}
		return result;
	}
	

}
