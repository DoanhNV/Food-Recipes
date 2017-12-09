package com.nganle.entity;

import java.util.Date;

public class KindOfCate extends AbstractEntity {
	private String kindTitle;
	private Date createTime;
	private Date updateTime;
	private int createrId;
	private int status;

	public KindOfCate() {

	}

	public KindOfCate(String kindTitle) {
		this.kindTitle = kindTitle;
	}

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

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
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
