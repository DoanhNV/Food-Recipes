package com.nganle.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.nganle.dao.DBConnection;
import com.nganle.dao.RecipeCategoryDAO;
import com.nganle.entity.RecipeCategory;
import com.nganle.support.constant.Constant;
import com.nganle.support.constant.SQLInfo;
import com.nganle.support.constant.SQLQuery;
import com.nganle.support.util.Utils;

@Repository
public class RecipeCategoryDAOImpl implements RecipeCategoryDAO {
	
	private Connection connection = DBConnection.getConnection();
	
	public boolean create(RecipeCategory cate) {
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(SQLQuery.RECIPE_CATE.CREATE);
			prepareStatement.setString(1, cate.getCateTitle());
			prepareStatement.setInt(2, cate.getKindId());
			prepareStatement.setTimestamp(3, Utils.getCurrentSQLDate());
			prepareStatement.setTimestamp(4, Utils.getCurrentSQLDate());
			prepareStatement.setInt(5,cate.getNumberOfRecipe());
			prepareStatement.setInt(6, cate.getCreaterId());
			prepareStatement.setInt(7, Constant.STATUS.ACTIVE_VALUE);
			prepareStatement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(RecipeCategory cate) {
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(SQLQuery.RECIPE_CATE.UPDATE);
			prepareStatement.setString(1, cate.getCateTitle());
			prepareStatement.setInt(2, cate.getKindId());
			prepareStatement.setTimestamp(3, Utils.getCurrentSQLDate());
			prepareStatement.setInt(4, cate.getStatus());
			prepareStatement.setInt(5, cate.getId());
			prepareStatement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delete(int id) {
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(SQLQuery.RECIPE_CATE.DELETE);
			prepareStatement.setInt(1, id);
			prepareStatement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public RecipeCategory getById(int id) {
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(SQLQuery.RECIPE_CATE.GET_BY_ID);
			prepareStatement.setInt(1, id);
			ResultSet set = prepareStatement.executeQuery();
			if(set.next()) {
				RecipeCategory cate = new RecipeCategory();
				cate.setId(set.getInt(SQLInfo.FIELD_ID));
				cate.setCateTitle(set.getString(SQLInfo.RECIPE_CATE.FIELD_CATE_TITLE));
				cate.setKindId(set.getInt(SQLInfo.RECIPE_CATE.FIELD_KIND_ID));
				cate.setCreateTime(set.getTimestamp(SQLInfo.FIELD_CREATE_TIME));
				cate.setUpdateTime(set.getTimestamp(SQLInfo.FIELD_UPDATE_TIME));
				cate.setNumberOfRecipe(set.getInt(SQLInfo.RECIPE_CATE.FIELD_NUMBER_OF_RECIPE));
				cate.setCreaterId(set.getInt(SQLInfo.FIELD_CREATER_ID));
				cate.setStatus(set.getInt(SQLInfo.FIELD_STATUS));
				return cate;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<RecipeCategory> listAll() {
		List<RecipeCategory>  result = new ArrayList<RecipeCategory>();
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(SQLQuery.RECIPE_CATE.LIST_ALL);
			ResultSet set = prepareStatement.executeQuery();
			while(set.next()) {
				RecipeCategory cate = new RecipeCategory();
				cate.setId(set.getInt(SQLInfo.FIELD_ID));
				cate.setCateTitle(set.getString(SQLInfo.RECIPE_CATE.FIELD_CATE_TITLE));
				cate.setKindId(set.getInt(SQLInfo.RECIPE_CATE.FIELD_KIND_ID));
				cate.setCreateTime(set.getTimestamp(SQLInfo.FIELD_CREATE_TIME));
				cate.setUpdateTime(set.getTimestamp(SQLInfo.FIELD_UPDATE_TIME));
				cate.setNumberOfRecipe(set.getInt(SQLInfo.RECIPE_CATE.FIELD_NUMBER_OF_RECIPE));
				cate.setCreaterId(set.getInt(SQLInfo.FIELD_CREATER_ID));
				cate.setStatus(set.getInt(SQLInfo.FIELD_STATUS));
				result.add(cate);
			}
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
