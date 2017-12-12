package com.nganle.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.nganle.dao.DBConnection;
import com.nganle.dao.RecipeDAO;
import com.nganle.entity.Recipe;
import com.nganle.support.constant.SQLInfo;
import com.nganle.support.constant.SQLQuery;
import com.nganle.support.util.Utils;

@Repository
public class RecipeDAOImpl implements RecipeDAO {

	private Connection connection = DBConnection.getConnection();

	public boolean create(Recipe recipe) {
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(SQLQuery.RECIPE.CREATE);
			prepareStatement.setString(1, recipe.getTitle());
			prepareStatement.setString(2, recipe.getContent());
			prepareStatement.setString(3, recipe.getFeatureImage());
			prepareStatement.setDouble(4, recipe.getCost());
			prepareStatement.setString(5, recipe.getKeySearch());
			prepareStatement.setString(6, Utils.toSQlArray(recipe.getMaterialIds()));
			prepareStatement.setString(7, Utils.toSQlArray(recipe.getSavedUserIds()));
			prepareStatement.setString(8, Utils.toSQlArray(recipe.getLikeIds()));
			prepareStatement.setString(9, Utils.toSQlArray(recipe.getCommentIds()));
			prepareStatement.setDate(10, Utils.getCurrentSQLDate());
			prepareStatement.setDate(11, Utils.getCurrentSQLDate());
			prepareStatement.setInt(12, recipe.getCreaterId());
			prepareStatement.setInt(13, recipe.getStatus());
			prepareStatement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(Recipe recipe) {
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(SQLQuery.RECIPE.UPDATE);
			prepareStatement.setString(1, recipe.getTitle());
			prepareStatement.setString(2, recipe.getContent());
			prepareStatement.setString(3, recipe.getFeatureImage());
			prepareStatement.setDouble(4, recipe.getCost());
			prepareStatement.setString(5, recipe.getKeySearch());
			prepareStatement.setString(6, Utils.toSQlArray(recipe.getMaterialIds()));
			prepareStatement.setDate(7, Utils.getCurrentSQLDate());
			prepareStatement.setInt(8, recipe.getStatus());
			prepareStatement.setInt(8, recipe.getId());
			prepareStatement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delete(int id) {
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(SQLQuery.RECIPE.DELETE);
			prepareStatement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Recipe getById(int id) {
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(SQLQuery.RECIPE.GET_BY_ID);
			prepareStatement.setInt(1, id);
			ResultSet set = prepareStatement.executeQuery();
			if (set.next()) {
				Recipe recipe = new Recipe();
				recipe.setId(id);
				recipe.setTitle(set.getString(SQLInfo.RECIPE.TITLE));
				recipe.setContent(set.getString(SQLInfo.RECIPE.CONTENT));
				recipe.setFeatureImage(set.getString(SQLInfo.RECIPE.FEATURE_IMAGE));
				recipe.setCost(set.getDouble(SQLInfo.RECIPE.COST));
				recipe.setKeySearch(set.getString(SQLInfo.RECIPE.KEY_SEARCH));
				recipe.setMaterialIds(Utils.toList(set.getString(SQLInfo.RECIPE.MATERIAL_IDS)));
				recipe.setCommentIds(Utils.toList(set.getString(SQLInfo.RECIPE.COMMENT_IDS)));
				recipe.setLikeIds(Utils.toList(set.getString(SQLInfo.RECIPE.LIKE_IDS)));
				recipe.setSavedUserIds(Utils.toList(set.getString(SQLInfo.RECIPE.SAVED_USER_IDS)));
				recipe.setCreateTime(set.getDate(SQLInfo.FIELD_CREATE_TIME));
				recipe.setUpdateTime(set.getDate(SQLInfo.FIELD_UPDATE_TIME));
				recipe.setCreaterId(set.getInt(SQLInfo.FIELD_CREATER_ID));
				recipe.setStatus(set.getInt(SQLInfo.FIELD_STATUS));
				return recipe;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Recipe> listAll() {
		List<Recipe> result = new ArrayList<Recipe>();
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(SQLQuery.RECIPE.GET_BY_ID);
			ResultSet set = prepareStatement.executeQuery();
			while (set.next()) {
				Recipe recipe = new Recipe();
				recipe.setId(set.getInt(SQLInfo.FIELD_ID));
				recipe.setTitle(set.getString(SQLInfo.RECIPE.TITLE));
				recipe.setContent(set.getString(SQLInfo.RECIPE.CONTENT));
				recipe.setFeatureImage(set.getString(SQLInfo.RECIPE.FEATURE_IMAGE));
				recipe.setCost(set.getDouble(SQLInfo.RECIPE.COST));
				recipe.setKeySearch(set.getString(SQLInfo.RECIPE.KEY_SEARCH));
				recipe.setMaterialIds(Utils.toList(set.getString(SQLInfo.RECIPE.MATERIAL_IDS)));
				recipe.setCommentIds(Utils.toList(set.getString(SQLInfo.RECIPE.COMMENT_IDS)));
				recipe.setLikeIds(Utils.toList(set.getString(SQLInfo.RECIPE.LIKE_IDS)));
				recipe.setSavedUserIds(Utils.toList(set.getString(SQLInfo.RECIPE.SAVED_USER_IDS)));
				recipe.setCreateTime(set.getDate(SQLInfo.FIELD_CREATE_TIME));
				recipe.setUpdateTime(set.getDate(SQLInfo.FIELD_UPDATE_TIME));
				recipe.setCreaterId(set.getInt(SQLInfo.FIELD_CREATER_ID));
				recipe.setStatus(set.getInt(SQLInfo.FIELD_STATUS));
				result.add(recipe);
			}
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean changeStatus(int id, int status) {
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(SQLQuery.RECIPE.UPDATE);
			prepareStatement.setInt(1, status);
			prepareStatement.setInt(2, id);
			prepareStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean addSavedId(int id, int userId) {
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(SQLQuery.RECIPE.ADD_SAVED_IDS);
			prepareStatement.setInt(1, userId);
			prepareStatement.setInt(2, id);
			prepareStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean addLike(int id, int userId) {
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(SQLQuery.RECIPE.ADD_LIKED_IDS);
			prepareStatement.setInt(1, userId);
			prepareStatement.setInt(2, id);
			prepareStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean addComment(int id, int commentId) {
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(SQLQuery.RECIPE.ADD_COMMENT_IDS);
			prepareStatement.setInt(1, commentId);
			prepareStatement.setInt(2, id);
			prepareStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}