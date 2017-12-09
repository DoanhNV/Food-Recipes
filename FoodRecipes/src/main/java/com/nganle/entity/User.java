package com.nganle.entity;

import java.util.Date;
import java.util.List;

public class User extends AbstractEntity {
	private String userName;
	private String email;
	private String fullName;
	private String password;
	private String md5Password;
	private Date birthday;
	private List<String> recipeSavedIds;
	private List<String> tipSavedIds;
	private String profileImage;
	private int numberOfRecipe;
	private boolean isAdmin;
	private Date createTime;
	private Date updateTime;
	private int status;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMd5Password() {
		return md5Password;
	}

	public void setMd5Password(String md5Password) {
		this.md5Password = md5Password;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public List<String> getRecipeSavedIds() {
		return recipeSavedIds;
	}

	public void setRecipeSavedIds(List<String> recipeSavedIds) {
		this.recipeSavedIds = recipeSavedIds;
	}

	public List<String> getTipSavedIds() {
		return tipSavedIds;
	}

	public void setTipSavedIds(List<String> tipSavedIds) {
		this.tipSavedIds = tipSavedIds;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public int getNumberOfRecipe() {
		return numberOfRecipe;
	}

	public void setNumberOfRecipe(int numberOfRecipe) {
		this.numberOfRecipe = numberOfRecipe;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
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

	@Override
	public String toString() {
		return "User [userName=" + userName + ", email=" + email + ", fullName=" + fullName + ", password=" + password
				+ ", md5Password=" + md5Password + ", birthday=" + birthday + ", recipeSavedIds=" + recipeSavedIds
				+ ", tipSavedIds=" + tipSavedIds + ", profileImage=" + profileImage + ", numberOfRecipe="
				+ numberOfRecipe + ", isAdmin=" + isAdmin + ", createTime=" + createTime + ", updateTime=" + updateTime
				+ ", status=" + status + "]";
	}
	
}
