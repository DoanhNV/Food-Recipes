package com.nganle.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.nganle.dao.AbstractDAO;
import com.nganle.dao.UserDAO;
import com.nganle.entity.User;
import com.nganle.support.constant.Constant;
import com.nganle.support.constant.SQLInfo;
import com.nganle.support.constant.SQLQuery;
import com.nganle.support.util.Utils;

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
			prepare.setTimestamp(6,  new Timestamp(user.getBirthday().getTime()));
			prepare.setString(7, user.getProfileImage());
			prepare.setInt(8, user.getNumberOfRecipe());
			prepare.setBoolean(9, user.isAdmin());
			prepare.setTimestamp(10, Utils.getCurrentSQLDate());
			prepare.setTimestamp(11, Utils.getCurrentSQLDate());
			prepare.setInt(12, Constant.STATUS.ACTIVE_VALUE);
			prepare.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(User user) {
		try {
			PreparedStatement prepare = connection.prepareStatement(SQLQuery.USER.UPDATE);
			prepare.setString(1, user.getFullName());
			prepare.setString(2, user.getEmail());
			prepare.setString(3, user.getPassword());
			prepare.setString(4, user.getPassword());
			prepare.setString(5, user.getProfileImage());
			prepare.setTimestamp(6, new Timestamp(user.getBirthday().getTime()));
			prepare.setTimestamp(7,Utils.getCurrentSQLDate());
			prepare.setInt(8, user.getId());
			prepare.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public User getById(int userId) {
		try {
			PreparedStatement prepare = connection.prepareStatement(SQLQuery.USER.FIND_BY_ID);
			prepare.setInt(1, userId);
			ResultSet set = prepare.executeQuery();
			if (set.next()) {
				User user = new User();
				user.setId(set.getInt(SQLInfo.FIELD_ID));
				user.setUserName(set.getString(SQLInfo.USER.FIELD_USER_NAME));
				user.setEmail(set.getString(SQLInfo.USER.FIELD_EMAIL));
				user.setMd5Password(set.getString(SQLInfo.USER.FIELD_MD5_PASSWORD));
				user.setPassword(set.getString(SQLInfo.USER.FIELD_ORIGINAL_PASSWORD));
				user.setFullName(set.getString(SQLInfo.USER.FIELD_FULL_NAME));
				user.setBirthday(set.getTimestamp(SQLInfo.USER.FIELD_BIRTHDAY));
				user.setRecipeSavedIds(Utils.toListString(set.getString(SQLInfo.USER.FIELD_RECIPE_SAVE_IDS)));
				user.setTipSavedIds(Utils.toListString(set.getString(SQLInfo.USER.FIELD_TIP_SAVE_IDS)));
				user.setProfileImage(set.getString(SQLInfo.USER.FIELD_PROFILE_IMAGE));
				user.setNumberOfRecipe(set.getInt(SQLInfo.USER.FIELD_NUMBER_OF_RECIPE));
				user.setAdmin(set.getBoolean(SQLInfo.USER.FIELD_IS_ADMIN));
				user.setCreateTime(set.getTimestamp(SQLInfo.FIELD_CREATE_TIME));
				user.setUpdateTime(set.getTimestamp(SQLInfo.FIELD_UPDATE_TIME));
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
				user.setBirthday(set.getTimestamp(SQLInfo.USER.FIELD_BIRTHDAY));
				/*
				 * user.setUserName(set.getString(SQLInfo.USER.FIELD_RECIPE_SAVE_IDS));
				 * user.setUserName(set.getString(SQLInfo.USER.FIELD_TIPE_SAVE_IDS));
				 */
				user.setProfileImage(set.getString(SQLInfo.USER.FIELD_PROFILE_IMAGE));
				user.setNumberOfRecipe(set.getInt(SQLInfo.USER.FIELD_NUMBER_OF_RECIPE));
				user.setAdmin(set.getBoolean(SQLInfo.USER.FIELD_IS_ADMIN));
				user.setCreateTime(set.getTimestamp(SQLInfo.FIELD_CREATE_TIME));
				user.setUpdateTime(set.getTimestamp(SQLInfo.FIELD_UPDATE_TIME));
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
				user.setBirthday(set.getTimestamp(SQLInfo.USER.FIELD_BIRTHDAY));
				/*
				 * user.setUserName(set.getString(SQLInfo.USER.FIELD_RECIPE_SAVE_IDS));
				 * user.setUserName(set.getString(SQLInfo.USER.FIELD_TIPE_SAVE_IDS));
				 */
				user.setProfileImage(set.getString(SQLInfo.USER.FIELD_PROFILE_IMAGE));
				user.setNumberOfRecipe(set.getInt(SQLInfo.USER.FIELD_NUMBER_OF_RECIPE));
				user.setAdmin(set.getBoolean(SQLInfo.USER.FIELD_IS_ADMIN));
				user.setCreateTime(set.getTimestamp(SQLInfo.FIELD_CREATE_TIME));
				user.setUpdateTime(set.getTimestamp(SQLInfo.FIELD_UPDATE_TIME));
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

	public List<User> getTopOrder(int limit, String field, String order) {
		List<User> result = new ArrayList<User>();
		try {
			PreparedStatement prepare = connection.prepareStatement(SQLQuery.USER.GET_TOP_ORDER);
			prepare.setString(1, field);
			prepare.setString(2,order);
			prepare.setInt(3, limit);
			ResultSet set = prepare.executeQuery();
			while (set.next()) {
				User user = new User();
				user.setId(set.getInt(SQLInfo.FIELD_ID));
				user.setUserName(set.getString(SQLInfo.USER.FIELD_USER_NAME));
				user.setEmail(set.getString(SQLInfo.USER.FIELD_EMAIL));
				user.setMd5Password(set.getString(SQLInfo.USER.FIELD_MD5_PASSWORD));
				user.setPassword(set.getString(SQLInfo.USER.FIELD_ORIGINAL_PASSWORD));
				user.setFullName(set.getString(SQLInfo.USER.FIELD_FULL_NAME));
				user.setBirthday(set.getTimestamp(SQLInfo.USER.FIELD_BIRTHDAY));
				user.setRecipeSavedIds(Utils.toListString(set.getString(SQLInfo.USER.FIELD_RECIPE_SAVE_IDS)));
				user.setTipSavedIds(Utils.toListString(set.getString(SQLInfo.USER.FIELD_TIP_SAVE_IDS)));
				user.setProfileImage(set.getString(SQLInfo.USER.FIELD_PROFILE_IMAGE));
				user.setNumberOfRecipe(set.getInt(SQLInfo.USER.FIELD_NUMBER_OF_RECIPE));
				user.setAdmin(set.getBoolean(SQLInfo.USER.FIELD_IS_ADMIN));
				user.setCreateTime(set.getTimestamp(SQLInfo.FIELD_CREATE_TIME));
				user.setUpdateTime(set.getTimestamp(SQLInfo.FIELD_UPDATE_TIME));
				user.setStatus(set.getInt(SQLInfo.FIELD_STATUS));
				result.add(user);
			}
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<User> findInList(List<Integer> ids) {
		List<User> result = new ArrayList<User>();
		if(ids== null || ids.size() == 0) {
			return result;
		}
		try {
			String formatQuery = String.format(SQLQuery.USER.FIND_IN_LIST,  Utils.toSqlInListFromInt(ids));
			PreparedStatement prepare = connection.prepareStatement(formatQuery);
			ResultSet set = prepare.executeQuery();
			while (set.next()) {
				User user = new User();
				user.setId(set.getInt(SQLInfo.FIELD_ID));
				user.setUserName(set.getString(SQLInfo.USER.FIELD_USER_NAME));
				user.setEmail(set.getString(SQLInfo.USER.FIELD_EMAIL));
				user.setMd5Password(set.getString(SQLInfo.USER.FIELD_MD5_PASSWORD));
				user.setPassword(set.getString(SQLInfo.USER.FIELD_ORIGINAL_PASSWORD));
				user.setFullName(set.getString(SQLInfo.USER.FIELD_FULL_NAME));
				user.setBirthday(set.getTimestamp(SQLInfo.USER.FIELD_BIRTHDAY));
				user.setRecipeSavedIds(Utils.toListString(set.getString(SQLInfo.USER.FIELD_RECIPE_SAVE_IDS)));
				user.setTipSavedIds(Utils.toListString(set.getString(SQLInfo.USER.FIELD_TIP_SAVE_IDS)));
				user.setProfileImage(set.getString(SQLInfo.USER.FIELD_PROFILE_IMAGE));
				user.setNumberOfRecipe(set.getInt(SQLInfo.USER.FIELD_NUMBER_OF_RECIPE));
				user.setAdmin(set.getBoolean(SQLInfo.USER.FIELD_IS_ADMIN));
				user.setCreateTime(set.getTimestamp(SQLInfo.FIELD_CREATE_TIME));
				user.setUpdateTime(set.getTimestamp(SQLInfo.FIELD_UPDATE_TIME));
				user.setStatus(set.getInt(SQLInfo.FIELD_STATUS));
				result.add(user);
			}
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean saveRecipe(List<String> recipeSavedIds,int id) {
		try {
			PreparedStatement prepare = connection.prepareStatement(SQLQuery.USER.SAVED_RECIPE);
			prepare.setString(1, Utils.toCateList(recipeSavedIds));
			prepare.setInt(2, id);
			prepare.execute();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
