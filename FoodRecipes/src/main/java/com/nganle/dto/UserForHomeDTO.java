package com.nganle.dto;

import java.util.ArrayList;
import java.util.List;

import com.nganle.entity.User;
import com.nganle.support.constant.Constant;
import com.nganle.support.util.Utils;

public class UserForHomeDTO {
	private int id;
	private String fullName;
	private int tipSavedNumber;
	private int recipeSavedNumber;
	private String featureImage;

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

	public int getTipSavedNumber() {
		return tipSavedNumber;
	}

	public void setTipSavedNumber(int tipSavedNumber) {
		this.tipSavedNumber = tipSavedNumber;
	}

	public int getRecipeSavedNumber() {
		return recipeSavedNumber;
	}

	public void setRecipeSavedNumber(int recipeSavedNumber) {
		this.recipeSavedNumber = recipeSavedNumber;
	}

	public String getFeatureImage() {
		return featureImage;
	}

	public void setFeatureImage(String featureImage) {
		this.featureImage = featureImage;
	}
	
	public static UserForHomeDTO toDTO(User user) {
		UserForHomeDTO dto = new UserForHomeDTO();
		dto.setId(user.getId());
		dto.setFullName(user.getFullName());
		if(user.getProfileImage().equals(Constant.HOME.DEFAULT_IMAGE)) {
			dto.setFeatureImage(user.getProfileImage());
		}else {
			dto.setFeatureImage(Utils.convertToFileByte(user.getProfileImage()));
		}
		return dto;
	}
	
	
	public static List<UserForHomeDTO> toListDTO(List<User> users){
		List<UserForHomeDTO> result = new ArrayList<UserForHomeDTO>();
		for (User user : users) {
			UserForHomeDTO dto = new UserForHomeDTO();
			dto.setId(user.getId());
			dto.setFullName(user.getFullName());
			String profileImage = user.getProfileImage();
			if(profileImage.equals("/resources/asset/img/cooker.png")) {
				dto.setFeatureImage(profileImage);
			}else {
				dto.setFeatureImage(Utils.convertToFileByte(profileImage));
			}
			dto.setRecipeSavedNumber(user.getRecipeSavedIds().size());
			dto.setTipSavedNumber(user.getTipSavedIds().size());
			result.add(dto);
		}
		return result;
	}
}
