package com.nganle.dto;

import java.util.ArrayList;
import java.util.List;

import com.nganle.entity.User;
import com.nganle.support.constant.Constant;
import com.nganle.support.util.DateFormator;

public class UserDTO {
	private int userId;
	private String userName;
	private String fullName;
	private String birthday;
	private int numberOfRecipes;
	private String status;
	private String createDate;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public int getNumberOfRecipes() {
		return numberOfRecipes;
	}

	public void setNumberOfRecipes(int numberOfRecipes) {
		this.numberOfRecipes = numberOfRecipes;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public static List<UserDTO> toListDTO(List<User> users) {
		List<UserDTO> result = new ArrayList<UserDTO>();
		for (User user : users) {
			UserDTO dto = new UserDTO();
			dto.setUserId(user.getId());
			dto.setUserName(user.getUserName());
			dto.setFullName(user.getFullName());
			dto.setBirthday(DateFormator.format_yyyy_MM_dd(user.getBirthday()));
			dto.setNumberOfRecipes(user.getNumberOfRecipe());
			dto.setCreateDate(DateFormator.format_yyyy_MM_dd_hh_mm(user.getCreateTime()));
			if (user.getStatus() == 0) {
				dto.setStatus(Constant.STATUS.DEACTIVE);
			} else if (user.getStatus() == 1) {
				dto.setStatus(Constant.STATUS.ACTIVE);
			}
			result.add(dto);
		}
		return result;
	}
	
	public static List<List<UserDTO>> pageListUser(List<UserDTO> userDTOs){
		List<List<UserDTO>> result = new ArrayList<List<UserDTO>>();
		List<UserDTO> element = new ArrayList<UserDTO>();
		for (int i = 0; i < userDTOs.size(); i++) {
			element.add(userDTOs.get(i));
			if((i+1) % Constant.NUMBER_PERPAGE == 0) {
				result.add(element);
				element = new ArrayList<UserDTO>();
			}
		}
		if(element.size() != 0) {
			result.add(element);
		}
		return result;
	}

}
