package com.nganle.dto;

import java.util.ArrayList;
import java.util.List;

import com.nganle.entity.Recipe;
import com.nganle.support.constant.Constant;
import com.nganle.support.util.DateFormator;
import com.nganle.support.util.Utils;

public class TopNewRecipeDTO {
	private int id;
	private String title;
	private String createTime;
	private String featureImage;
	private String time;
	private String cost;
	private int views;

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

	public String getFeatureImage() {
		return featureImage;
	}

	public void setFeatureImage(String featureImage) {
		this.featureImage = featureImage;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public static List<TopNewRecipeDTO> toListDTO(List<Recipe> recipes) {
		List<TopNewRecipeDTO> result = new ArrayList<TopNewRecipeDTO>();
		for (Recipe recipe : recipes) {
			TopNewRecipeDTO dto = new TopNewRecipeDTO();
			dto.setId(recipe.getId());
			String title = recipe.getTitle().length() >= 38 ? recipe.getTitle().substring(0,35) +"..." : recipe.getTitle();
			dto.setTitle(title);
			dto.setCost(Utils.formatMoney(recipe.getCost()));
			dto.setCreateTime(DateFormator.format_yyyy_MM_dd(recipe.getCreateTime()));
			dto.setFeatureImage(Utils.convertToFileByte(recipe.getFeatureImage()));
			dto.setViews(recipe.getViews());
			String estimateTime = recipe.getEstimateTime();
			String time = estimateTime.replace(Constant.ESTIMATE_TIME_SEPARATOR, Constant.HOUR_SUFFIX)
						+ Constant.MINUTE_SUFFIX;
			dto.setTime(time);
			result.add(dto);
		}
		return result;
	}
	
	public static List<List<TopNewRecipeDTO>> toPageList(List<TopNewRecipeDTO> list){
		List<List<TopNewRecipeDTO>> result = new ArrayList<List<TopNewRecipeDTO>>();
		List<TopNewRecipeDTO> element = new ArrayList<TopNewRecipeDTO>();
		for (int i = 0; i < list.size(); i++) {
			element.add(list.get(i));
			if( (i + 1) % Constant.NUMBER_PER_PAGE_SEARCH == 0) {
				result.add(element);
				element = new ArrayList<TopNewRecipeDTO>();
			}
		}
		if(element.size() != 0) {
			result.add(element);
		}
		return result;
	}
	
}
