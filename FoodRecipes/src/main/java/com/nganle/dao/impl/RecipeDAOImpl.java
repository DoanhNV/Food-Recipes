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
import com.nganle.support.constant.Constant;
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
			prepareStatement.setString(5, Utils.toSQlArray(recipe.getMaterialIds()));
			prepareStatement.setString(6, Utils.toSQlArray(recipe.getSavedUserIds()));
			prepareStatement.setString(7, Utils.toSQlArray(recipe.getLikeIds()));
			prepareStatement.setString(8, Utils.toSQlArray(recipe.getCommentIds()));
			prepareStatement.setTimestamp(9, Utils.getCurrentSQLDate());
			prepareStatement.setTimestamp(10, Utils.getCurrentSQLDate());
			prepareStatement.setInt(11, recipe.getCreaterId());
			prepareStatement.setInt(12, Constant.STATUS.ACTIVE_VALUE);
			prepareStatement.setString(13, recipe.getEstimateTime());
			prepareStatement.setString(14, Utils.toCateList(recipe.getRecipeCateIds()));
			prepareStatement.setString(15, recipe.getVideoUrl());
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
			prepareStatement.setString(5, Utils.toSQlArray(recipe.getMaterialIds()));
			prepareStatement.setTimestamp(6, Utils.getCurrentSQLDate());
			prepareStatement.setString(7, recipe.getEstimateTime());
			prepareStatement.setString(8, recipe.getVideoUrl());
			prepareStatement.setString(9, Utils.toCateList(recipe.getRecipeCateIds()));
			prepareStatement.setInt(10, recipe.getId());
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
			prepareStatement.setInt(1, id);
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
				recipe.setMaterialIds(Utils.toList(set.getString(SQLInfo.RECIPE.MATERIAL_IDS)));
				recipe.setCommentIds(Utils.toList(set.getString(SQLInfo.RECIPE.COMMENT_IDS)));
				recipe.setLikeIds(Utils.toList(set.getString(SQLInfo.RECIPE.LIKE_IDS)));
				recipe.setSavedUserIds(Utils.toList(set.getString(SQLInfo.RECIPE.SAVED_USER_IDS)));
				recipe.setCreateTime(set.getTimestamp(SQLInfo.FIELD_CREATE_TIME));
				recipe.setUpdateTime(set.getTimestamp(SQLInfo.FIELD_UPDATE_TIME));
				recipe.setCreaterId(set.getInt(SQLInfo.FIELD_CREATER_ID));
				recipe.setStatus(set.getInt(SQLInfo.FIELD_STATUS));
				recipe.setViews(set.getInt(SQLInfo.RECIPE.VIEWS));
				recipe.setEstimateTime(set.getString(SQLInfo.RECIPE.ESTIMATE_TIME));
				recipe.setVideoUrl(set.getString(SQLInfo.RECIPE.VIDEO_URL));
				recipe.setRecipeCateIds(Utils.toListString(set.getString(SQLInfo.RECIPE.RECIPE_CATE_IDS)));
				recipe.setIsSlide(set.getInt(SQLInfo.RECIPE.IS_SLIDE));
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
			PreparedStatement prepareStatement = connection.prepareStatement(SQLQuery.RECIPE.LIST_ALL);
			ResultSet set = prepareStatement.executeQuery();
			while (set.next()) {
				Recipe recipe = new Recipe();
				recipe.setId(set.getInt(SQLInfo.FIELD_ID));
				recipe.setTitle(set.getString(SQLInfo.RECIPE.TITLE));
				recipe.setContent(set.getString(SQLInfo.RECIPE.CONTENT));
				recipe.setFeatureImage(set.getString(SQLInfo.RECIPE.FEATURE_IMAGE));
				recipe.setCost(set.getDouble(SQLInfo.RECIPE.COST));
				recipe.setMaterialIds(Utils.toList(set.getString(SQLInfo.RECIPE.MATERIAL_IDS)));
				recipe.setCommentIds(Utils.toList(set.getString(SQLInfo.RECIPE.COMMENT_IDS)));
				recipe.setLikeIds(Utils.toList(set.getString(SQLInfo.RECIPE.LIKE_IDS)));
				recipe.setSavedUserIds(Utils.toList(set.getString(SQLInfo.RECIPE.SAVED_USER_IDS)));
				recipe.setCreateTime(set.getTimestamp(SQLInfo.FIELD_CREATE_TIME));
				recipe.setUpdateTime(set.getTimestamp(SQLInfo.FIELD_UPDATE_TIME));
				recipe.setCreaterId(set.getInt(SQLInfo.FIELD_CREATER_ID));
				recipe.setStatus(set.getInt(SQLInfo.FIELD_STATUS));
				recipe.setViews(set.getInt(SQLInfo.RECIPE.VIEWS));
				recipe.setEstimateTime(set.getString(SQLInfo.RECIPE.ESTIMATE_TIME));
				recipe.setVideoUrl(set.getString(SQLInfo.RECIPE.VIDEO_URL));
				recipe.setRecipeCateIds(Utils.toListString(set.getString(SQLInfo.RECIPE.RECIPE_CATE_IDS)));
				recipe.setIsSlide(set.getInt(SQLInfo.RECIPE.IS_SLIDE));
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
			PreparedStatement prepareStatement = connection.prepareStatement(SQLQuery.RECIPE.CHANGE_STATUS);
			prepareStatement.setInt(1, status);
			prepareStatement.setInt(2, id);
			prepareStatement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean addSavedId(int id,List<Integer> savedUserIds) {
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(SQLQuery.RECIPE.ADD_SAVED_IDS);
			prepareStatement.setString(1, Utils.toSQlArray(savedUserIds));
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

	public boolean changeSlide(int id, int slideValue) {
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(SQLQuery.RECIPE.CHANGE_SLIDE);
			prepareStatement.setInt(1, slideValue);
			prepareStatement.setInt(2, id);
			prepareStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<Recipe> getSlide() {
		List<Recipe> result = new ArrayList<Recipe>();
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(SQLQuery.RECIPE.GET_SLIDE);
			ResultSet set = prepareStatement.executeQuery();
			while (set.next()) {
				Recipe recipe = new Recipe();
				recipe.setId(set.getInt(SQLInfo.FIELD_ID));
				recipe.setTitle(set.getString(SQLInfo.RECIPE.TITLE));
				recipe.setContent(set.getString(SQLInfo.RECIPE.CONTENT));
				recipe.setFeatureImage(set.getString(SQLInfo.RECIPE.FEATURE_IMAGE));
				recipe.setCost(set.getDouble(SQLInfo.RECIPE.COST));
				recipe.setMaterialIds(Utils.toList(set.getString(SQLInfo.RECIPE.MATERIAL_IDS)));
				recipe.setCommentIds(Utils.toList(set.getString(SQLInfo.RECIPE.COMMENT_IDS)));
				recipe.setLikeIds(Utils.toList(set.getString(SQLInfo.RECIPE.LIKE_IDS)));
				recipe.setSavedUserIds(Utils.toList(set.getString(SQLInfo.RECIPE.SAVED_USER_IDS)));
				recipe.setCreateTime(set.getTimestamp(SQLInfo.FIELD_CREATE_TIME));
				recipe.setUpdateTime(set.getTimestamp(SQLInfo.FIELD_UPDATE_TIME));
				recipe.setCreaterId(set.getInt(SQLInfo.FIELD_CREATER_ID));
				recipe.setStatus(set.getInt(SQLInfo.FIELD_STATUS));
				recipe.setViews(set.getInt(SQLInfo.RECIPE.VIEWS));
				recipe.setEstimateTime(set.getString(SQLInfo.RECIPE.ESTIMATE_TIME));
				recipe.setVideoUrl(set.getString(SQLInfo.RECIPE.VIDEO_URL));
				recipe.setRecipeCateIds(Utils.toListString(set.getString(SQLInfo.RECIPE.RECIPE_CATE_IDS)));
				recipe.setIsSlide(set.getInt(SQLInfo.RECIPE.IS_SLIDE));
				result.add(recipe);
			}
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Recipe> getTopViews(int number) {
		List<Recipe> result = new ArrayList<Recipe>();
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(SQLQuery.RECIPE.GET_TOP_VIEW);
			prepareStatement.setInt(1, number);
			ResultSet set = prepareStatement.executeQuery();
			while (set.next()) {
				Recipe recipe = new Recipe();
				recipe.setId(set.getInt(SQLInfo.FIELD_ID));
				recipe.setTitle(set.getString(SQLInfo.RECIPE.TITLE));
				recipe.setContent(set.getString(SQLInfo.RECIPE.CONTENT));
				recipe.setFeatureImage(set.getString(SQLInfo.RECIPE.FEATURE_IMAGE));
				recipe.setCost(set.getDouble(SQLInfo.RECIPE.COST));
				recipe.setMaterialIds(Utils.toList(set.getString(SQLInfo.RECIPE.MATERIAL_IDS)));
				recipe.setCommentIds(Utils.toList(set.getString(SQLInfo.RECIPE.COMMENT_IDS)));
				recipe.setLikeIds(Utils.toList(set.getString(SQLInfo.RECIPE.LIKE_IDS)));
				recipe.setSavedUserIds(Utils.toList(set.getString(SQLInfo.RECIPE.SAVED_USER_IDS)));
				recipe.setCreateTime(set.getTimestamp(SQLInfo.FIELD_CREATE_TIME));
				recipe.setUpdateTime(set.getTimestamp(SQLInfo.FIELD_UPDATE_TIME));
				recipe.setCreaterId(set.getInt(SQLInfo.FIELD_CREATER_ID));
				recipe.setStatus(set.getInt(SQLInfo.FIELD_STATUS));
				recipe.setViews(set.getInt(SQLInfo.RECIPE.VIEWS));
				recipe.setEstimateTime(set.getString(SQLInfo.RECIPE.ESTIMATE_TIME));
				recipe.setVideoUrl(set.getString(SQLInfo.RECIPE.VIDEO_URL));
				recipe.setRecipeCateIds(Utils.toListString(set.getString(SQLInfo.RECIPE.RECIPE_CATE_IDS)));
				recipe.setIsSlide(set.getInt(SQLInfo.RECIPE.IS_SLIDE));
				result.add(recipe);
			}
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Recipe> searchByTitle(String title) {
		List<Recipe> result = new ArrayList<Recipe>();
		try {
			String formatQuery = String.format(SQLQuery.RECIPE.SEARCH_BY_TITLE, Utils.toSqlLikesTitle(title, SQLInfo.RECIPE.TITLE));
			PreparedStatement prepareStatement = connection.prepareStatement(formatQuery);
			ResultSet set = prepareStatement.executeQuery();
			while (set.next()) {
				Recipe recipe = new Recipe();
				recipe.setId(set.getInt(SQLInfo.FIELD_ID));
				recipe.setTitle(set.getString(SQLInfo.RECIPE.TITLE));
				recipe.setContent(set.getString(SQLInfo.RECIPE.CONTENT));
				recipe.setFeatureImage(set.getString(SQLInfo.RECIPE.FEATURE_IMAGE));
				recipe.setCost(set.getDouble(SQLInfo.RECIPE.COST));
				recipe.setMaterialIds(Utils.toList(set.getString(SQLInfo.RECIPE.MATERIAL_IDS)));
				recipe.setCommentIds(Utils.toList(set.getString(SQLInfo.RECIPE.COMMENT_IDS)));
				recipe.setLikeIds(Utils.toList(set.getString(SQLInfo.RECIPE.LIKE_IDS)));
				recipe.setSavedUserIds(Utils.toList(set.getString(SQLInfo.RECIPE.SAVED_USER_IDS)));
				recipe.setCreateTime(set.getTimestamp(SQLInfo.FIELD_CREATE_TIME));
				recipe.setUpdateTime(set.getTimestamp(SQLInfo.FIELD_UPDATE_TIME));
				recipe.setCreaterId(set.getInt(SQLInfo.FIELD_CREATER_ID));
				recipe.setStatus(set.getInt(SQLInfo.FIELD_STATUS));
				recipe.setViews(set.getInt(SQLInfo.RECIPE.VIEWS));
				recipe.setEstimateTime(set.getString(SQLInfo.RECIPE.ESTIMATE_TIME));
				recipe.setVideoUrl(set.getString(SQLInfo.RECIPE.VIDEO_URL));
				recipe.setRecipeCateIds(Utils.toListString(set.getString(SQLInfo.RECIPE.RECIPE_CATE_IDS)));
				recipe.setIsSlide(set.getInt(SQLInfo.RECIPE.IS_SLIDE));
				result.add(recipe);
			}
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Recipe> searchByCate(List<String> listSqlCate) {
		List<Recipe> result = new ArrayList<Recipe>();
		try {
			String formatQuery = String.format(SQLQuery.RECIPE.SEARCH_BY_CATE, Utils.toSqlLikes(listSqlCate,SQLInfo.RECIPE.RECIPE_CATE_IDS));
			PreparedStatement prepareStatement = connection.prepareStatement(formatQuery);
			ResultSet set = prepareStatement.executeQuery();
			while (set.next()) {
				Recipe recipe = new Recipe();
				recipe.setId(set.getInt(SQLInfo.FIELD_ID));
				recipe.setTitle(set.getString(SQLInfo.RECIPE.TITLE));
				recipe.setContent(set.getString(SQLInfo.RECIPE.CONTENT));
				recipe.setFeatureImage(set.getString(SQLInfo.RECIPE.FEATURE_IMAGE));
				recipe.setCost(set.getDouble(SQLInfo.RECIPE.COST));
				recipe.setMaterialIds(Utils.toList(set.getString(SQLInfo.RECIPE.MATERIAL_IDS)));
				recipe.setCommentIds(Utils.toList(set.getString(SQLInfo.RECIPE.COMMENT_IDS)));
				recipe.setLikeIds(Utils.toList(set.getString(SQLInfo.RECIPE.LIKE_IDS)));
				recipe.setSavedUserIds(Utils.toList(set.getString(SQLInfo.RECIPE.SAVED_USER_IDS)));
				recipe.setCreateTime(set.getTimestamp(SQLInfo.FIELD_CREATE_TIME));
				recipe.setUpdateTime(set.getTimestamp(SQLInfo.FIELD_UPDATE_TIME));
				recipe.setCreaterId(set.getInt(SQLInfo.FIELD_CREATER_ID));
				recipe.setStatus(set.getInt(SQLInfo.FIELD_STATUS));
				recipe.setViews(set.getInt(SQLInfo.RECIPE.VIEWS));
				recipe.setEstimateTime(set.getString(SQLInfo.RECIPE.ESTIMATE_TIME));
				recipe.setVideoUrl(set.getString(SQLInfo.RECIPE.VIDEO_URL));
				recipe.setRecipeCateIds(Utils.toListString(set.getString(SQLInfo.RECIPE.RECIPE_CATE_IDS)));
				recipe.setIsSlide(set.getInt(SQLInfo.RECIPE.IS_SLIDE));
				result.add(recipe);
			}
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Recipe> searchByMaterial(List<Integer> listSqlMaterial , int limit) {
		List<Recipe> result = new ArrayList<Recipe>();
		try {
			String queryFormat = String.format(SQLQuery.RECIPE.SEARCH_BY_MATERIAL,  Utils.toSqlLikesFrInt(listSqlMaterial,SQLInfo.RECIPE.MATERIAL_IDS),limit);
			PreparedStatement prepareStatement = connection.prepareStatement(queryFormat);
			ResultSet set = prepareStatement.executeQuery();
			while (set.next()) {
				Recipe recipe = new Recipe();
				recipe.setId(set.getInt(SQLInfo.FIELD_ID));
				recipe.setTitle(set.getString(SQLInfo.RECIPE.TITLE));
				recipe.setContent(set.getString(SQLInfo.RECIPE.CONTENT));
				recipe.setFeatureImage(set.getString(SQLInfo.RECIPE.FEATURE_IMAGE));
				recipe.setCost(set.getDouble(SQLInfo.RECIPE.COST));
				recipe.setMaterialIds(Utils.toList(set.getString(SQLInfo.RECIPE.MATERIAL_IDS)));
				recipe.setCommentIds(Utils.toList(set.getString(SQLInfo.RECIPE.COMMENT_IDS)));
				recipe.setLikeIds(Utils.toList(set.getString(SQLInfo.RECIPE.LIKE_IDS)));
				recipe.setSavedUserIds(Utils.toList(set.getString(SQLInfo.RECIPE.SAVED_USER_IDS)));
				recipe.setCreateTime(set.getTimestamp(SQLInfo.FIELD_CREATE_TIME));
				recipe.setUpdateTime(set.getTimestamp(SQLInfo.FIELD_UPDATE_TIME));
				recipe.setCreaterId(set.getInt(SQLInfo.FIELD_CREATER_ID));
				recipe.setStatus(set.getInt(SQLInfo.FIELD_STATUS));
				recipe.setViews(set.getInt(SQLInfo.RECIPE.VIEWS));
				recipe.setEstimateTime(set.getString(SQLInfo.RECIPE.ESTIMATE_TIME));
				recipe.setVideoUrl(set.getString(SQLInfo.RECIPE.VIDEO_URL));
				recipe.setRecipeCateIds(Utils.toListString(set.getString(SQLInfo.RECIPE.RECIPE_CATE_IDS)));
				recipe.setIsSlide(set.getInt(SQLInfo.RECIPE.IS_SLIDE));
				result.add(recipe);
			}
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Recipe> getTopNews(int limit) {
		List<Recipe> result = new ArrayList<Recipe>();
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(SQLQuery.RECIPE.GET_TOP_NEWS);
			prepareStatement.setInt(1, limit);
			ResultSet set = prepareStatement.executeQuery();
			while (set.next()) {
				Recipe recipe = new Recipe();
				recipe.setId(set.getInt(SQLInfo.FIELD_ID));
				recipe.setTitle(set.getString(SQLInfo.RECIPE.TITLE));
				recipe.setContent(set.getString(SQLInfo.RECIPE.CONTENT));
				recipe.setFeatureImage(set.getString(SQLInfo.RECIPE.FEATURE_IMAGE));
				recipe.setCost(set.getDouble(SQLInfo.RECIPE.COST));
				recipe.setMaterialIds(Utils.toList(set.getString(SQLInfo.RECIPE.MATERIAL_IDS)));
				recipe.setCommentIds(Utils.toList(set.getString(SQLInfo.RECIPE.COMMENT_IDS)));
				recipe.setLikeIds(Utils.toList(set.getString(SQLInfo.RECIPE.LIKE_IDS)));
				recipe.setSavedUserIds(Utils.toList(set.getString(SQLInfo.RECIPE.SAVED_USER_IDS)));
				recipe.setCreateTime(set.getTimestamp(SQLInfo.FIELD_CREATE_TIME));
				recipe.setCreaterId(set.getInt(SQLInfo.FIELD_CREATER_ID));
				recipe.setStatus(set.getInt(SQLInfo.FIELD_STATUS));
				recipe.setViews(set.getInt(SQLInfo.RECIPE.VIEWS));
				recipe.setEstimateTime(set.getString(SQLInfo.RECIPE.ESTIMATE_TIME));
				recipe.setRecipeCateIds(Utils.toListString(set.getString(SQLInfo.RECIPE.RECIPE_CATE_IDS)));
				result.add(recipe);
			}
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Recipe> searchByListId(String listSqlId) {
		List<Recipe> result = new ArrayList<Recipe>();
		if(listSqlId.equals("()")) {
			return result;
		}
		try {
			String formatQuery = String.format(SQLQuery.RECIPE.SEARCH_BY_LIST_ID,listSqlId);
			PreparedStatement prepareStatement = connection.prepareStatement(formatQuery);
			ResultSet set = prepareStatement.executeQuery();
			while (set.next()) {
				Recipe recipe = new Recipe();
				recipe.setId(set.getInt(SQLInfo.FIELD_ID));
				recipe.setTitle(set.getString(SQLInfo.RECIPE.TITLE));
				recipe.setContent(set.getString(SQLInfo.RECIPE.CONTENT));
				recipe.setFeatureImage(set.getString(SQLInfo.RECIPE.FEATURE_IMAGE));
				recipe.setCost(set.getDouble(SQLInfo.RECIPE.COST));
				recipe.setMaterialIds(Utils.toList(set.getString(SQLInfo.RECIPE.MATERIAL_IDS)));
				recipe.setCommentIds(Utils.toList(set.getString(SQLInfo.RECIPE.COMMENT_IDS)));
				recipe.setLikeIds(Utils.toList(set.getString(SQLInfo.RECIPE.LIKE_IDS)));
				recipe.setSavedUserIds(Utils.toList(set.getString(SQLInfo.RECIPE.SAVED_USER_IDS)));
				recipe.setCreateTime(set.getTimestamp(SQLInfo.FIELD_CREATE_TIME));
				recipe.setCreaterId(set.getInt(SQLInfo.FIELD_CREATER_ID));
				recipe.setStatus(set.getInt(SQLInfo.FIELD_STATUS));
				recipe.setViews(set.getInt(SQLInfo.RECIPE.VIEWS));
				recipe.setEstimateTime(set.getString(SQLInfo.RECIPE.ESTIMATE_TIME));
				recipe.setRecipeCateIds(Utils.toListString(set.getString(SQLInfo.RECIPE.RECIPE_CATE_IDS)));
				result.add(recipe);
			}
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean increaseView(int id) {
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(SQLQuery.RECIPE.INCREASE_VIEW);
			prepareStatement.setInt(1, id);
			prepareStatement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean checkExistByCateId(int id) {
		try {
			String formatQuery = String.format(SQLQuery.RECIPE.GET_BY_CATE_ID, "'%"+id+"-%'");
			PreparedStatement prepareStatement = connection.prepareStatement(formatQuery);
			ResultSet set = prepareStatement.executeQuery();
			return set.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
