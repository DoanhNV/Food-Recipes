package com.nganle.entity;

import java.util.Date;

public class TipCategory extends AbstractEntity {
	private String cateName;
	private Date createTime;
	private Date updateTime;
	private int numberOfTips;
	private int createrid;
	private int status;

	public TipCategory() {

	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
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

	public int getNumberOfTips() {
		return numberOfTips;
	}

	public void setNumberOfTips(int numberOfTips) {
		this.numberOfTips = numberOfTips;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getCreaterid() {
		return createrid;
	}

	public void setCreaterid(int createrid) {
		this.createrid = createrid;
	}

}
