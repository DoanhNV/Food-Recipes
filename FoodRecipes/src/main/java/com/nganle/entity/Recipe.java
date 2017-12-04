package com.nganle.entity;

import java.util.Date;
import java.util.List;

public class Recipe extends AbstractEntity {
	private String title;
	private List<String> recipeCateIds;
	private String keySearch;
	private String content;
	private int createrId;
	private String featureImage;
	private List<String> materialIds;
	private List<String> likeIds;
	private List<String> commentIds;
	private Double cost;
	private int views;
	private List<String> savedUserIds;
	private Date createTime;
	private Date updateTime;
	private int status;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getRecipeCateIds() {
		return recipeCateIds;
	}

	public void setRecipeCateIds(List<String> recipeCateIds) {
		this.recipeCateIds = recipeCateIds;
	}

	public String getKeySearch() {
		return keySearch;
	}

	public void setKeySearch(String keySearch) {
		this.keySearch = keySearch;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getCreaterId() {
		return createrId;
	}

	public void setCreaterId(int createrId) {
		this.createrId = createrId;
	}

	public String getFeatureImage() {
		return featureImage;
	}

	public void setFeatureImage(String featureImage) {
		this.featureImage = featureImage;
	}

	public List<String> getMaterialIds() {
		return materialIds;
	}

	public void setMaterialIds(List<String> materialIds) {
		this.materialIds = materialIds;
	}

	public List<String> getLikeIds() {
		return likeIds;
	}

	public void setLikeIds(List<String> likeIds) {
		this.likeIds = likeIds;
	}

	public List<String> getCommentIds() {
		return commentIds;
	}

	public void setCommentIds(List<String> commentIds) {
		this.commentIds = commentIds;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public List<String> getSavedUserIds() {
		return savedUserIds;
	}

	public void setSavedUserIds(List<String> savedUserIds) {
		this.savedUserIds = savedUserIds;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
