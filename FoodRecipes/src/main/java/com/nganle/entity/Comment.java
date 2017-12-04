package com.nganle.entity;

import java.util.Date;

public class Comment extends AbstractEntity {
	private int content;
	private int userId;
	private Date createTime;
	private Date updateTime;
	private int status;

	public int getContent() {
		return content;
	}

	public void setContent(int content) {
		this.content = content;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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
