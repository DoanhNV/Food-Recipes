package com.nganle.entity;

import java.util.Date;
import java.util.List;

public class Recipe extends AbstractEntity {
	private String title;
	private List<String> recipeCateIds;
	private String content;
	private int createrId;
	private String featureImage;
	private List<Integer> materialIds;
	private List<Integer> likeIds;
	private List<Integer> commentIds;
	private Double cost;
	private int views;
	private List<Integer> savedUserIds;
	private Date createTime;
	private Date updateTime;
	private int status;
	private String estimateTime;
	private String videoUrl;
	private int isSlide;

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

	public String getEstimateTime() {
		return estimateTime;
	}

	public void setEstimateTime(String estimateTime) {
		this.estimateTime = estimateTime;
	}

	public List<Integer> getMaterialIds() {
		return materialIds;
	}

	public void setMaterialIds(List<Integer> materialIds) {
		this.materialIds = materialIds;
	}

	public List<Integer> getLikeIds() {
		return likeIds;
	}

	public void setLikeIds(List<Integer> likeIds) {
		this.likeIds = likeIds;
	}

	public List<Integer> getCommentIds() {
		return commentIds;
	}

	public void setCommentIds(List<Integer> commentIds) {
		this.commentIds = commentIds;
	}

	public List<Integer> getSavedUserIds() {
		return savedUserIds;
	}

	public void setSavedUserIds(List<Integer> savedUserIds) {
		this.savedUserIds = savedUserIds;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public int getIsSlide() {
		return isSlide;
	}

	public void setIsSlide(int isSlide) {
		this.isSlide = isSlide;
	}

}
