package com.nganle.dto;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.Base64Utils;

import com.nganle.entity.Recipe;
import com.nganle.support.constant.Constant;
import com.nganle.support.util.DateFormator;

public class RecipeDTO {
	private int id;
	private String title;
	private String featureImage;
	private String createTime;
	private String status;
	private int views;
	private int likeNumber;
	private int saveNumber;
	private int commentNumber;
	private int isSlide;

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

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public int getLikeNumber() {
		return likeNumber;
	}

	public void setLikeNumber(int likeNumber) {
		this.likeNumber = likeNumber;
	}

	public int getSaveNumber() {
		return saveNumber;
	}

	public void setSaveNumber(int saveNumber) {
		this.saveNumber = saveNumber;
	}

	public int getCommentNumber() {
		return commentNumber;
	}

	public void setCommentNumber(int commentNumber) {
		this.commentNumber = commentNumber;
	}

	public int getIsSlide() {
		return isSlide;
	}

	public void setIsSlide(int isSlide) {
		this.isSlide = isSlide;
	}

	public static List<RecipeDTO> toListDTDO(List<Recipe> recipes) {
		List<RecipeDTO> result = new ArrayList<RecipeDTO>();
		if (recipes == null) {
			return result;
		}
		for (Recipe recipe : recipes) {
			RecipeDTO dto = new RecipeDTO();
			dto.setId(recipe.getId());
			dto.setTitle(recipe.getTitle());

			String fileByte = "data:image/png;base64,";
			try {
				byte[] fileBytes = Files.readAllBytes(new File(recipe.getFeatureImage()).toPath());
				byte[] code = Base64Utils.encode(fileBytes);
				fileByte += new String(code, "UTF-8");
			} catch (IOException e) {
				System.out.println("no image");
			}

			dto.setFeatureImage(fileByte);
			dto.setCreateTime(DateFormator.format_yyyy_MM_dd_hh_mm(recipe.getCreateTime()));
			dto.setViews(recipe.getViews());
			dto.setLikeNumber(recipe.getLikeIds().size());
			dto.setCommentNumber(recipe.getCommentIds().size());
			dto.setSaveNumber(recipe.getSavedUserIds().size());
			String status = recipe.getStatus() == 1 ? Constant.STATUS.ACTIVE : Constant.STATUS.DEACTIVE;
			dto.setStatus(status);
			dto.setIsSlide(recipe.getIsSlide());
			result.add(dto);
		}
		return result;
	}

	public static List<List<RecipeDTO>> toPageList(List<RecipeDTO> list) {
		List<List<RecipeDTO>> result = new ArrayList<List<RecipeDTO>>();
		List<RecipeDTO> element = new ArrayList<RecipeDTO>();
		for (int i = 0; i < list.size(); i++) {
			element.add(list.get(i));
			if ((i + 1) % Constant.NUMBER_PERPAGE == 0) {
				result.add(element);
				element = new ArrayList<RecipeDTO>();
			}
		}

		if (element.size() != 0) {
			result.add(element);
		}
		return result;
	}

}
