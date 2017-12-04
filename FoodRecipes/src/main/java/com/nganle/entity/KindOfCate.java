package com.nganle.entity;

import java.util.Date;

public class KindOfCate extends AbstractEntity {
	private String kindTitle;
	private Date createTime;
	private Date createDate;
	private int createrId;

	public String getKindTitle() {
		return kindTitle;
	}

	public void setKindTitle(String kindTitle) {
		this.kindTitle = kindTitle;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getCreaterId() {
		return createrId;
	}

	public void setCreaterId(int createrId) {
		this.createrId = createrId;
	}

}
