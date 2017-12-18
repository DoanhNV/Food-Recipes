package com.nganle.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.nganle.entity.Comment;
import com.nganle.entity.User;
import com.nganle.support.constant.Constant;
import com.nganle.support.util.DateFormator;
import com.nganle.support.util.Utils;

public class CommentDTO {
	private int id;
	private String content;
	private String createTime;
	private int userId;
	private String userFullName;
	private String userProfile;

	public CommentDTO() {

	}

	public CommentDTO(String content) {
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserFullName() {
		return userFullName;
	}

	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}

	public String getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(String userProfile) {
		this.userProfile = userProfile;
	}

	public static CommentDTO toDTO(Comment comment, User user) {
		CommentDTO dto = new CommentDTO();
		dto.setId(comment.getId());
		dto.setContent(comment.getContent());
		dto.setCreateTime(DateFormator.format_yyyy_MM_dd_hh_mm(new Date()));
		dto.setUserId(user.getId());
		dto.setUserFullName(user.getFullName());
		dto.setUserProfile(user.getProfileImage());
		return dto;
	}
	
	public static List<CommentDTO> toListDTO(List<Comment> comments,List<User> users) {
		List<CommentDTO> result = new ArrayList<CommentDTO>();
		for (Comment comment : comments) {
			CommentDTO dto = new CommentDTO();
			dto.setId(comment.getId());
			dto.setContent(comment.getContent());
			dto.setCreateTime(DateFormator.format_yyyy_MM_dd_hh_mm(comment.getCreateTime()));
			for (User user : users) {
				if(comment.getUserId() == user.getId()) {
					dto.setUserId(user.getId());
					dto.setUserFullName(user.getFullName());
					if (user.getProfileImage().equals(Constant.HOME.DEFAULT_IMAGE)) {
						dto.setUserProfile(user.getProfileImage());
					} else {
						dto.setUserProfile(Utils.convertToFileByte(user.getProfileImage()));
					}
					break;
				}
			}
			result.add(dto);
		}
		return result;
	}

}
