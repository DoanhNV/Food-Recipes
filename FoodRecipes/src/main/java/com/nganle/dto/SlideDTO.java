package com.nganle.dto;

import java.util.ArrayList;
import java.util.List;

import com.nganle.dao.RecipeCategoryDAO;
import com.nganle.dao.impl.RecipeCategoryDAOImpl;
import com.nganle.entity.Recipe;
import com.nganle.entity.RecipeCategory;
import com.nganle.support.util.Utils;

public class SlideDTO {
	private int id;
	private String cateName;
	private String title;
	private String featureImage;
	private int cateId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
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

	public int getCateId() {
		return cateId;
	}

	public void setCateId(int cateId) {
		this.cateId = cateId;
	}

	public static List<SlideDTO> toListDTO(List<Recipe> recipes) {
		List<SlideDTO> slides = new ArrayList<SlideDTO>();
		RecipeCategoryDAO cateDAO = new RecipeCategoryDAOImpl();
		List<RecipeCategory> cates = cateDAO.listAll();
		for (Recipe recipe : recipes) {
			SlideDTO dto = new SlideDTO();
			dto.setId(recipe.getId());
			dto.setTitle(recipe.getTitle());
			dto.setFeatureImage(Utils.convertToFileByte(recipe.getFeatureImage()));
			List<String> recipeCateIds = recipe.getRecipeCateIds();
			String kindCate = recipeCateIds.get(0);
			String[] kindCates = kindCate.split("-");
			for (RecipeCategory cate : cates) {
				if (Integer.parseInt(kindCates[0]) == cate.getId()) {
					dto.setCateId(cate.getId());
					dto.setCateName(cate.getCateTitle());
					break;
				}
			}
			slides.add(dto);
		}
		return slides;
	}
}
