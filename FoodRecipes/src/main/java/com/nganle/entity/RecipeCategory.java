package com.nganle.entity;

import java.util.Date;

public class RecipeCategory extends AbstractEntity {
	private String cateTitle;
	private int kindId;
	private Date createTime;
	private Date updateTime;
	private int numberOfRecipe;
	private int createrId;
	private int status;

	public String getCateTitle() {
		return cateTitle;
	}

	public void setCateTitle(String cateTitle) {
		this.cateTitle = cateTitle;
	}

	public int getKindId() {
		return kindId;
	}

	public void setKindId(int kindId) {
		this.kindId = kindId;
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

	public int getNumberOfRecipe() {
		return numberOfRecipe;
	}

	public void setNumberOfRecipe(int numberOfRecipe) {
		this.numberOfRecipe = numberOfRecipe;
	}

	public int getCreaterId() {
		return createrId;
	}

	public void setCreaterId(int createrId) {
		this.createrId = createrId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
