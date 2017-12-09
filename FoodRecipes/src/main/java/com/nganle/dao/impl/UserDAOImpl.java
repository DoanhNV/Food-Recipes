package com.nganle.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.nganle.dao.AbstractDAO;
import com.nganle.dao.UserDAO;
import com.nganle.entity.User;
import com.nganle.support.constant.Constant;
import com.nganle.support.constant.SQLInfo;
import com.nganle.support.constant.SQLQuery;

@Repository
public class UserDAOImpl extends AbstractDAO implements UserDAO {
	private Connection connection = this.getConnection();

	public boolean create(User user) {
		try {
			PreparedStatement prepare = connection.prepareStatement(SQLQuery.USER.CREATE_USER);
			prepare.setString(1, user.getUserName());
			prepare.setString(2, user.getFullName());
			prepare.setString(3, user.getEmail());
			prepare.setString(4, user.getPassword());
			prepare.setString(5, user.getPassword());
			Date birthDay = new Date(user.getBirthday().getTime());
			prepare.setDate(6, birthDay);
			prepare.setString(7, user.getRecipeSavedIds().toString()); // Json
			prepare.setString(8, user.getTipSavedIds().toString()); // json
			prepare.setString(9, user.getProfileImage());
			prepare.setInt(10, user.getNumberOfRecipe());
			prepare.setBoolean(11, user.isAdmin());
			Date createTime = new Date(user.getCreateTime().getTime());
			prepare.setDate(12, createTime);
			Date updateTime = new Date(user.getUpdateTime().getTime());
			prepare.setDate(13, updateTime);
			prepare.setInt(14, Constant.STATUS.ACTIVE_VALUE);
			prepare.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	public User getById(int userId) {
		try {
			PreparedStatement prepare = connection.prepareStatement(SQLQuery.USER.FIND_BY_ID);
			prepare.setInt(1, userId);
			ResultSet set = prepare.executeQuery();
			if (set.next()) {
				User user = new User();
				user.setUserName(set.getString(SQLInfo.USER.FIELD_USER_NAME));
				user.setEmail(set.getString(SQLInfo.USER.FIELD_EMAIL));
				user.setMd5Password(set.getString(SQLInfo.USER.FIELD_MD5_PASSWORD));
				user.setPassword(set.getString(SQLInfo.USER.FIELD_ORIGINAL_PASSWORD));
				user.setFullName(set.getString(SQLInfo.USER.FIELD_FULL_NAME));
				user.setBirthday(set.getDate(SQLInfo.USER.FIELD_BIRTHDAY));
				/*
				 * user.setUserName(set.getString(SQLInfo.USER.FIELD_RECIPE_SAVE_IDS));
				 * user.setUserName(set.getString(SQLInfo.USER.FIELD_TIPE_SAVE_IDS));
				 */
				user.setProfileImage(set.getString(SQLInfo.USER.FIELD_PROFILE_IMAGE));
				user.setNumberOfRecipe(set.getInt(SQLInfo.USER.FIELD_NUMBER_OF_RECIPE));
				user.setAdmin(set.getBoolean(SQLInfo.USER.FIELD_IS_ADMIN));
				user.setCreateTime(set.getDate(SQLInfo.FIELD_CREATE_TIME));
				user.setUpdateTime(set.getDate(SQLInfo.FIELD_UPDATE_TIME));
				user.setStatus(set.getInt(SQLInfo.FIELD_STATUS));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<User> listAll() {
		List<User> result = new ArrayList<User>();
		try {
			PreparedStatement prepare = connection.prepareStatement(SQLQuery.USER.LIST_ALL);
			ResultSet set = prepare.executeQuery();
			while (set.next()) {
				User user = new User();
				user.setId(set.getInt(SQLInfo.FIELD_ID));
				user.setUserName(set.getString(SQLInfo.USER.FIELD_USER_NAME));
				user.setEmail(set.getString(SQLInfo.USER.FIELD_EMAIL));
				user.setMd5Password(set.getString(SQLInfo.USER.FIELD_MD5_PASSWORD));
				user.setPassword(set.getString(SQLInfo.USER.FIELD_ORIGINAL_PASSWORD));
				user.setFullName(set.getString(SQLInfo.USER.FIELD_FULL_NAME));
				user.setBirthday(set.getDate(SQLInfo.USER.FIELD_BIRTHDAY));
				/*
				 * user.setUserName(set.getString(SQLInfo.USER.FIELD_RECIPE_SAVE_IDS));
				 * user.setUserName(set.getString(SQLInfo.USER.FIELD_TIPE_SAVE_IDS));
				 */
				user.setProfileImage(set.getString(SQLInfo.USER.FIELD_PROFILE_IMAGE));
				user.setNumberOfRecipe(set.getInt(SQLInfo.USER.FIELD_NUMBER_OF_RECIPE));
				user.setAdmin(set.getBoolean(SQLInfo.USER.FIELD_IS_ADMIN));
				user.setCreateTime(set.getDate(SQLInfo.FIELD_CREATE_TIME));
				user.setUpdateTime(set.getDate(SQLInfo.FIELD_UPDATE_TIME));
				user.setStatus(set.getInt(SQLInfo.FIELD_STATUS));
				result.add(user);
			}
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean delete(int userId) {
		try {
			PreparedStatement prepare = connection.prepareStatement(SQLQuery.USER.DELETE_BY_ID);
			prepare.setInt(1, userId);
			prepare.execute();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public User getByUserNameAndPassword(String userName, String password) {
		try {
			PreparedStatement prepare = connection.prepareStatement(SQLQuery.USER.FIND_BY_USER_AND_PASS);
			prepare.setString(1, userName);
			prepare.setString(2, password);
			ResultSet set = prepare.executeQuery();
			if (set.next()) {
				User user = new User();
				user.setId(set.getInt(SQLInfo.FIELD_ID));
				user.setUserName(set.getString(SQLInfo.USER.FIELD_USER_NAME));
				user.setEmail(set.getString(SQLInfo.USER.FIELD_EMAIL));
				user.setMd5Password(set.getString(SQLInfo.USER.FIELD_MD5_PASSWORD));
				user.setPassword(set.getString(SQLInfo.USER.FIELD_ORIGINAL_PASSWORD));
				user.setFullName(set.getString(SQLInfo.USER.FIELD_FULL_NAME));
				user.setBirthday(set.getDate(SQLInfo.USER.FIELD_BIRTHDAY));
				/*
				 * user.setUserName(set.getString(SQLInfo.USER.FIELD_RECIPE_SAVE_IDS));
				 * user.setUserName(set.getString(SQLInfo.USER.FIELD_TIPE_SAVE_IDS));
				 */
				user.setProfileImage(set.getString(SQLInfo.USER.FIELD_PROFILE_IMAGE));
				user.setNumberOfRecipe(set.getInt(SQLInfo.USER.FIELD_NUMBER_OF_RECIPE));
				user.setAdmin(set.getBoolean(SQLInfo.USER.FIELD_IS_ADMIN));
				user.setCreateTime(set.getDate(SQLInfo.FIELD_CREATE_TIME));
				user.setUpdateTime(set.getDate(SQLInfo.FIELD_UPDATE_TIME));
				user.setStatus(set.getInt(SQLInfo.FIELD_STATUS));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean isExistByUserName(String userName) {
		try {
			PreparedStatement prepare = connection.prepareStatement(SQLQuery.USER.FIND_BY_USER_NAME);
			prepare.setString(1, userName);
			ResultSet set = prepare.executeQuery();
			return set.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean changeStatus(int userId, int status) {
		try {
			PreparedStatement prepare = connection.prepareStatement(SQLQuery.USER.UPDATE_STATUS);
			prepare.setInt(1, status);
			prepare.setInt(2, userId);
			prepare.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
