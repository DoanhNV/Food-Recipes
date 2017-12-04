package com.nganle.entity;

import java.util.Date;

public class Slide extends AbstractEntity {
	private int slideIndex;
	private Date createTime;
	private int recipeId;

	public Slide() {

	}

	public Slide(int slideIndex, Date createTime, int recipeId) {
		super();
		this.slideIndex = slideIndex;
		this.createTime = createTime;
		this.recipeId = recipeId;
	}

	public int getSlideIndex() {
		return slideIndex;
	}

	public void setSlideIndex(int slideIndex) {
		this.slideIndex = slideIndex;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}

}
