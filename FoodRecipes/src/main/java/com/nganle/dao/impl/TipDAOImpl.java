package com.nganle.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.nganle.dao.DBConnection;
import com.nganle.dao.TipDAO;
import com.nganle.entity.Tip;
import com.nganle.support.constant.Constant;
import com.nganle.support.constant.SQLInfo;
import com.nganle.support.constant.SQLQuery;
import com.nganle.support.util.Utils;

@Repository
public class TipDAOImpl implements TipDAO {

	private Connection connection = DBConnection.getConnection();

	public boolean create(Tip tip) {
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(SQLQuery.TIP.CREATE);
			prepareStatement.setString(1, tip.getTitle());
			prepareStatement.setString(2, tip.getContent());
			prepareStatement.setString(3, Utils.toSQlArray(tip.getTipCateIds()));
			prepareStatement.setDate(4, Utils.getCurrentSQLDate());
			prepareStatement.setDate(5, Utils.getCurrentSQLDate());
			prepareStatement.setString(6, tip.getFeatureImage());
			prepareStatement.setString(7, Utils.toSQlArray(tip.getSavedUserIds()));
			prepareStatement.setInt(8, tip.getView());
			prepareStatement.setInt(9, tip.getCreaterId());
			prepareStatement.setInt(10, Constant.STATUS.ACTIVE_VALUE);
			prepareStatement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(Tip tip) {
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(SQLQuery.TIP.UPDATE);
			prepareStatement.setString(1, tip.getTitle());
			prepareStatement.setString(2, tip.getContent());
			prepareStatement.setString(3, Utils.toSQlArray(tip.getTipCateIds()));
			prepareStatement.setDate(4, Utils.getCurrentSQLDate());
			prepareStatement.setString(5, tip.getFeatureImage());
			prepareStatement.setString(6, Utils.toSQlArray(tip.getSavedUserIds()));
			prepareStatement.setInt(7, tip.getStatus());
			prepareStatement.setInt(8, tip.getId());
			prepareStatement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delete(int id) {
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(SQLQuery.TIP.DELETE);
			prepareStatement.setInt(1, id);
			prepareStatement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Tip getById(int id) {
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(SQLQuery.TIP.GET_BY_ID);
			prepareStatement.setInt(1, id);
			ResultSet set = prepareStatement.executeQuery();
			if (set.next()) {
				Tip tip = new Tip();
				tip.setId(id);
				tip.setTitle(set.getString(SQLInfo.TIP.TITLE));
				tip.setContent(set.getString(SQLInfo.TIP.CONTENT));
				tip.setTipCateIds(Utils.toList(set.getString(SQLInfo.TIP.TIP_CATE_IDS)));
				tip.setCreateTime(set.getDate(SQLInfo.FIELD_CREATE_TIME));
				tip.setUpdateTime(set.getDate(SQLInfo.FIELD_UPDATE_TIME));
				tip.setFeatureImage(set.getString(SQLInfo.TIP.FEATURE_IMAGE));
				tip.setSavedUserIds(Utils.toList(set.getString(SQLInfo.TIP.SAVED_USER_IDS)));
				tip.setCreaterId(set.getInt(SQLInfo.FIELD_CREATER_ID));
				tip.setStatus(set.getInt(SQLInfo.FIELD_STATUS));
				tip.setView(set.getInt(SQLInfo.TIP.VIEW));
				return tip;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Tip> listAll() {
		List<Tip> result = new ArrayList<Tip>();
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(SQLQuery.TIP.LIST_ALL);
			ResultSet set = prepareStatement.executeQuery();
			while (set.next()) {
				Tip tip = new Tip();
				tip.setId(set.getInt(SQLInfo.FIELD_ID));
				tip.setTitle(set.getString(SQLInfo.TIP.TITLE));
				tip.setContent(set.getString(SQLInfo.TIP.CONTENT));
				tip.setTipCateIds(Utils.toList(set.getString(SQLInfo.TIP.TIP_CATE_IDS)));
				tip.setCreateTime(set.getDate(SQLInfo.FIELD_CREATE_TIME));
				tip.setUpdateTime(set.getDate(SQLInfo.FIELD_UPDATE_TIME));
				tip.setFeatureImage(set.getString(SQLInfo.TIP.FEATURE_IMAGE));
				tip.setSavedUserIds(Utils.toList(set.getString(SQLInfo.TIP.SAVED_USER_IDS)));
				tip.setCreaterId(set.getInt(SQLInfo.FIELD_CREATER_ID));
				tip.setStatus(set.getInt(SQLInfo.FIELD_STATUS));
				tip.setView(set.getInt(SQLInfo.TIP.VIEW));
				result.add(tip);
			}
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
