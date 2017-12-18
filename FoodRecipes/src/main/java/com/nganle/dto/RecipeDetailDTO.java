package com.nganle.dto;

import java.util.ArrayList;
import java.util.List;

import com.nganle.dao.MaterialDAO;
import com.nganle.dao.RecipeCategoryDAO;
import com.nganle.dao.impl.MaterialDAOImpl;
import com.nganle.dao.impl.RecipeCategoryDAOImpl;
import com.nganle.entity.Material;
import com.nganle.entity.Recipe;
import com.nganle.entity.RecipeCategory;
import com.nganle.entity.Step;
import com.nganle.support.constant.Constant;
import com.nganle.support.util.DateFormator;

public class RecipeDetailDTO {
	private int id;
	private String title;
	private String cateTitle;
	private String createTime;
	private int savedNumber;
	private List<MaterialBasicDTO> materials;
	private List<Step> steps;
	private List<CommentDTO> comments;
	private String videoUrl;
	private String estimateTime;
	private List<Integer> listSavedId;

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

	public String getCateTitle() {
		return cateTitle;
	}

	public void setCateTitle(String cateTitle) {
		this.cateTitle = cateTitle;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public int getSavedNumber() {
		return savedNumber;
	}

	public void setSavedNumber(int savedNumber) {
		this.savedNumber = savedNumber;
	}

	public List<MaterialBasicDTO> getMaterials() {
		return materials;
	}

	public void setMaterials(List<MaterialBasicDTO> materials) {
		this.materials = materials;
	}

	public List<Step> getSteps() {
		return steps;
	}

	public void setSteps(List<Step> steps) {
		this.steps = steps;
	}

	public List<CommentDTO> getComments() {
		return comments;
	}

	public void setComments(List<CommentDTO> comments) {
		this.comments = comments;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public String getEstimateTime() {
		return estimateTime;
	}

	public void setEstimateTime(String estimateTime) {
		this.estimateTime = estimateTime;
	}
	
	public List<Integer> getListSavedId() {
		return listSavedId;
	}

	public void setListSavedId(List<Integer> listSavedId) {
		this.listSavedId = listSavedId;
	}

	public static RecipeDetailDTO toRecipeDTO(Recipe recipe, List<Step> steps) {
		RecipeDetailDTO dto = new RecipeDetailDTO();
		RecipeCategoryDAO cateDAO = new RecipeCategoryDAOImpl();
		MaterialDAO materialDAO = new MaterialDAOImpl();
		dto.setId(recipe.getId());
		dto.setTitle(recipe.getTitle());
		dto.setCreateTime(DateFormator.format_yyyy_MM_dd_hh_mm(recipe.getCreateTime()));
		List<Integer> savedUserIds = recipe.getSavedUserIds();
		dto.setListSavedId(savedUserIds);
		dto.setSavedNumber(recipe.getSavedUserIds().size());
		List<String> recipeCateIds = recipe.getRecipeCateIds();
		String[] dataId = recipeCateIds.get(0).split("-");
		RecipeCategory cate = cateDAO.getById(Integer.parseInt(dataId[0]));
		dto.setCateTitle(cate.getCateTitle());
		dto.setSteps(steps);

		List<Material> materials = materialDAO.listAll();
		List<Integer> materialIds = recipe.getMaterialIds();
		List<MaterialBasicDTO> listM = new ArrayList<MaterialBasicDTO>();
		for (Integer id : materialIds) {
			MaterialBasicDTO mDTO = new MaterialBasicDTO();
			for (Material material : materials) {
				if (id == material.getId()) {
					mDTO.setTitle(material.getMaterialName());
					mDTO.setId(id);
					break;
				}
			}
			listM.add(mDTO);
		}
		dto.setMaterials(listM);
		dto.setVideoUrl(recipe.getVideoUrl().replace("watch?v=", "embed/").replace("https://", ""));
		String estimateTime = recipe.getEstimateTime();
		String[] time = estimateTime.split(Constant.ESTIMATE_TIME_SEPARATOR);
		dto.setEstimateTime(time[0] + Constant.HOUR_SUFFIX + time[1] + Constant.MINUTE_SUFFIX);
		return dto;
	}

}
