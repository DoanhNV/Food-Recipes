package com.nganle.dto;

import com.nganle.entity.User;
import com.nganle.support.constant.Constant;
import com.nganle.support.util.DateFormator;
import com.nganle.support.util.Utils;

public class UserProfileDTO {
	private int id;
	private String fullName;
	private String birthDay;
	private String email;
	private String profileImage;
	private String listSQlSavedRecipe;
	private String listSQLSavedTip;
	private int recipeSavedNumber;
	private int tipSavedNumber;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public String getListSQlSavedRecipe() {
		return listSQlSavedRecipe;
	}

	public void setListSQlSavedRecipe(String listSQlSavedRecipe) {
		this.listSQlSavedRecipe = listSQlSavedRecipe;
	}

	public String getListSQLSavedTip() {
		return listSQLSavedTip;
	}

	public void setListSQLSavedTip(String listSQLSavedTip) {
		this.listSQLSavedTip = listSQLSavedTip;
	}

	public int getRecipeSavedNumber() {
		return recipeSavedNumber;
	}

	public void setRecipeSavedNumber(int recipeSavedNumber) {
		this.recipeSavedNumber = recipeSavedNumber;
	}

	public int getTipSavedNumber() {
		return tipSavedNumber;
	}

	public void setTipSavedNumber(int tipSavedNumber) {
		this.tipSavedNumber = tipSavedNumber;
	}
	
	public static UserProfileDTO toDTOForUpdate(User user) {
		UserProfileDTO dto = new UserProfileDTO();
		dto.setId(user.getId());
		dto.setFullName(user.getFullName());
		dto.setEmail(user.getEmail());
		dto.setBirthDay(DateFormator.format_yyyy_MM_dd(user.getBirthday()));
		return dto;
	}


	public static UserProfileDTO toDTO(User user) {
		UserProfileDTO dto = new UserProfileDTO();
		dto.setId(user.getId());
		dto.setFullName(user.getFullName());
		dto.setEmail(user.getEmail());
		dto.setBirthDay(DateFormator.format_yyyy_MM_dd(user.getBirthday()));
		if (user.getProfileImage().equals(Constant.HOME.DEFAULT_IMAGE)) {
			dto.setProfileImage(user.getProfileImage());
		} else {
			dto.setProfileImage(Utils.convertToFileByte(user.getProfileImage()));
		}
		if (user.getRecipeSavedIds() != null) {
			dto.setListSQlSavedRecipe(Utils.toSqlInList(user.getRecipeSavedIds()));
		}
		if (user.getTipSavedIds() != null) {
			dto.setListSQLSavedTip(Utils.toSqlInList(user.getTipSavedIds()));
		}
		int recipeLength = dto.getListSQlSavedRecipe() == null ? 0 : user.getRecipeSavedIds().size();
		int tipLength = dto.getListSQLSavedTip() == null ? 0 : user.getTipSavedIds().size();
		dto.setRecipeSavedNumber(recipeLength);
		dto.setTipSavedNumber(tipLength);
		return dto;
	}

}
