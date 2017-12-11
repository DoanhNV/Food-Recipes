package com.nganle.entity;

import java.util.Date;
import java.util.List;

public class Tip extends AbstractEntity {
	private String title;
	private String content;
	private List<String> tipCateIds;
	private Date createTime;
	private Date updateTime;
	private String featureImage;
	private List<String> savedUserIds;
	private int createrId;
	private int view;
	private int status;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<String> getTipCateIds() {
		return tipCateIds;
	}

	public void setTipCateIds(List<String> tipCateIds) {
		this.tipCateIds = tipCateIds;
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

	public String getFeatureImage() {
		return featureImage;
	}

	public void setFeatureImage(String featureImage) {
		this.featureImage = featureImage;
	}

	public List<String> getSavedUserIds() {
		return savedUserIds;
	}

	public void setSavedUserIds(List<String> savedUserIds) {
		this.savedUserIds = savedUserIds;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getCreaterId() {
		return createrId;
	}

	public void setCreaterId(int createrId) {
		this.createrId = createrId;
	}

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}

}
