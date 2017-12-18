package com.nganle.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.nganle.dao.CommentDAO;
import com.nganle.dao.DBConnection;
import com.nganle.entity.Comment;
import com.nganle.support.constant.Constant;
import com.nganle.support.constant.SQLInfo;
import com.nganle.support.constant.SQLQuery;
import com.nganle.support.util.Utils;

@Repository
public class CommentDAOImpl implements CommentDAO {
	private Connection connection = DBConnection.getConnection();

	public boolean create(Comment comment) {
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(SQLQuery.COMMENT.CREATE);
			prepareStatement.setString(1, comment.getContent());
			prepareStatement.setInt(2, comment.getRecipeId());
			prepareStatement.setInt(3, comment.getUserId());
			prepareStatement.setTimestamp(4, Utils.getCurrentSQLDate());
			prepareStatement.setTimestamp(5, Utils.getCurrentSQLDate());
			prepareStatement.setInt(6, Constant.STATUS.ACTIVE_VALUE);
			prepareStatement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(Comment comment) {
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(SQLQuery.COMMENT.UPDATE);
			prepareStatement.setString(1, comment.getContent());
			prepareStatement.setTimestamp(2, Utils.getCurrentSQLDate());
			prepareStatement.setInt(3, comment.getStatus());
			prepareStatement.setInt(4, comment.getId());
			prepareStatement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delete(int id) {
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(SQLQuery.COMMENT.DELETE);
			prepareStatement.setInt(1, id);
			prepareStatement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<Comment> getByRecipeId(int recipeid) {
		List<Comment> result = new ArrayList<Comment>();
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(SQLQuery.COMMENT.GET_BY_RECIPE_ID);
			prepareStatement.setInt(1, recipeid);
			ResultSet set = prepareStatement.executeQuery();
			while (set.next()) {
				Comment comment = new Comment();
				comment.setId(set.getInt(SQLInfo.FIELD_ID));
				comment.setContent(set.getString(SQLInfo.COMMENT.CONTENT));
				comment.setRecipeId(set.getInt(SQLInfo.COMMENT.RECIPE_ID));
				comment.setUserId(set.getInt(SQLInfo.COMMENT.USER_ID));
				comment.setCreateTime(set.getTimestamp(SQLInfo.FIELD_CREATE_TIME));
				comment.setUpdateTime(set.getTimestamp(SQLInfo.FIELD_UPDATE_TIME));
				comment.setStatus(set.getInt(SQLInfo.FIELD_STATUS));
				result.add(comment);
			}
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Comment> listAll() {
		List<Comment> result = new ArrayList<Comment>();
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(SQLQuery.COMMENT.GET_BY_RECIPE_ID);
			ResultSet set = prepareStatement.executeQuery();
			while (set.next()) {
				Comment comment = new Comment();
				comment.setId(set.getInt(SQLInfo.FIELD_ID));
				comment.setContent(set.getString(SQLInfo.COMMENT.CONTENT));
				comment.setRecipeId(set.getInt(SQLInfo.COMMENT.RECIPE_ID));
				comment.setUserId(set.getInt(SQLInfo.COMMENT.USER_ID));
				comment.setCreateTime(set.getTimestamp(SQLInfo.FIELD_CREATE_TIME));
				comment.setUpdateTime(set.getTimestamp(SQLInfo.FIELD_UPDATE_TIME));
				comment.setStatus(set.getInt(SQLInfo.FIELD_STATUS));
				result.add(comment);
			}
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
