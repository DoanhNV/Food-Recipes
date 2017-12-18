package com.nganle.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.nganle.dao.DBConnection;
import com.nganle.dao.TipCateDAO;
import com.nganle.entity.TipCategory;
import com.nganle.support.constant.Constant;
import com.nganle.support.constant.SQLInfo;
import com.nganle.support.constant.SQLQuery;
import com.nganle.support.util.Utils;

@Repository
public class TipCateDAOImpl implements TipCateDAO {
	private Connection connection = DBConnection.getConnection();

	public boolean create(TipCategory cate) {
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(SQLQuery.TIP_CATE.CREATE);
			prepareStatement.setString(1, cate.getCateName());
			prepareStatement.setTimestamp(2, Utils.getCurrentSQLDate());
			prepareStatement.setTimestamp(3, Utils.getCurrentSQLDate());
			prepareStatement.setInt(4, cate.getNumberOfTips());
			prepareStatement.setInt(5, cate.getCreaterid());
			prepareStatement.setInt(6, Constant.STATUS.ACTIVE_VALUE);
			prepareStatement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(TipCategory cate) {
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(SQLQuery.TIP_CATE.UPDATE);
			prepareStatement.setString(1, cate.getCateName());
			prepareStatement.setTimestamp(2, Utils.getCurrentSQLDate());
			prepareStatement.setInt(3, cate.getStatus());
			prepareStatement.setInt(4, cate.getId());
			prepareStatement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delete(int id) {
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(SQLQuery.TIP_CATE.DELETE);
			prepareStatement.setInt(1, id);
			prepareStatement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public TipCategory getById(int id) {
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(SQLQuery.TIP_CATE.GET_BY_ID);
			prepareStatement.setInt(1, id);
			ResultSet set = prepareStatement.executeQuery();
			if(set.next()) {
				TipCategory cate = new TipCategory();
				cate.setId(set.getInt(SQLInfo.FIELD_ID));
				cate.setCateName(set.getString(SQLInfo.TIP_CATE.FIELD_CATE_NAME));
				cate.setCreateTime(set.getTimestamp(SQLInfo.FIELD_CREATE_TIME));
				cate.setUpdateTime(set.getTimestamp(SQLInfo.FIELD_UPDATE_TIME));
				cate.setNumberOfTips(set.getInt(SQLInfo.TIP_CATE.FIELD_NUMBER_OF_TIPS));
				cate.setCreaterid(set.getInt(SQLInfo.FIELD_CREATER_ID));
				cate.setStatus(set.getInt(SQLInfo.FIELD_STATUS));
				return cate;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<TipCategory> listAll() {
		List<TipCategory> result = new ArrayList<TipCategory>();
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(SQLQuery.TIP_CATE.LIST_ALL);
			ResultSet set = prepareStatement.executeQuery();
			while(set.next()) {
				TipCategory cate = new TipCategory();
				cate.setId(set.getInt(SQLInfo.FIELD_ID));
				cate.setCateName(set.getString(SQLInfo.TIP_CATE.FIELD_CATE_NAME));
				cate.setCreateTime(set.getTimestamp(SQLInfo.FIELD_CREATE_TIME));
				cate.setUpdateTime(set.getTimestamp(SQLInfo.FIELD_UPDATE_TIME));
				cate.setNumberOfTips(set.getInt(SQLInfo.TIP_CATE.FIELD_NUMBER_OF_TIPS));
				cate.setCreaterid(set.getInt(SQLInfo.FIELD_CREATER_ID));
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
