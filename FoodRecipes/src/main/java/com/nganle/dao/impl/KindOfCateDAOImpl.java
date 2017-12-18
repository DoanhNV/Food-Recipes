package com.nganle.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.nganle.dao.AbstractDAO;
import com.nganle.dao.DBConnection;
import com.nganle.dao.KindOfCateDAO;
import com.nganle.entity.KindOfCate;
import com.nganle.support.constant.Constant;
import com.nganle.support.constant.SQLInfo;
import com.nganle.support.constant.SQLQuery;
import com.nganle.support.util.Utils;

@Repository
public class KindOfCateDAOImpl extends AbstractDAO implements KindOfCateDAO {
	private Connection connection = DBConnection.getConnection();

	public boolean create(KindOfCate kindOfCate) {
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(SQLQuery.KINDOFCATE.CREATE);
			prepareStatement.setString(1, kindOfCate.getKindTitle());
			prepareStatement.setTimestamp(2, Utils.getCurrentSQLDate());
			prepareStatement.setTimestamp(3, Utils.getCurrentSQLDate());
			prepareStatement.setInt(4, kindOfCate.getCreaterId());
			prepareStatement.setInt(5, Constant.STATUS.ACTIVE_VALUE);
			prepareStatement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(KindOfCate kindOfCate) {
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(SQLQuery.KINDOFCATE.UPDATE);
			prepareStatement.setString(1, kindOfCate.getKindTitle());
			prepareStatement.setTimestamp(2, Utils.getCurrentSQLDate());
			prepareStatement.setInt(3, kindOfCate.getStatus());
			prepareStatement.setInt(4, kindOfCate.getId());
			prepareStatement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delete(int kindId) {
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(SQLQuery.KINDOFCATE.DELETE);
			prepareStatement.setInt(1, kindId);
			prepareStatement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public KindOfCate findById(int kindId) {
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(SQLQuery.KINDOFCATE.GET_BY_ID);
			prepareStatement.setInt(1, kindId);
			ResultSet set = prepareStatement.executeQuery();
			if (set.next()) {
				KindOfCate kind = new KindOfCate();
				kind.setId(set.getInt(SQLInfo.FIELD_ID));
				kind.setKindTitle(set.getString(SQLInfo.KIND_OF_CATE.FIELD_KIND_TITLE));
				kind.setCreateTime(set.getDate(SQLInfo.FIELD_CREATE_TIME));
				kind.setUpdateTime(set.getDate(SQLInfo.FIELD_UPDATE_TIME));
				kind.setCreaterId(set.getInt(SQLInfo.FIELD_CREATER_ID));
				kind.setStatus(set.getInt(SQLInfo.FIELD_STATUS));
				return kind;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<KindOfCate> listAll() {
		List<KindOfCate> kinds = new ArrayList<KindOfCate>();
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(SQLQuery.KINDOFCATE.LIST_ALL);
			ResultSet set = prepareStatement.executeQuery();
			while (set.next()) {
				KindOfCate kind = new KindOfCate();
				kind.setId(set.getInt(SQLInfo.FIELD_ID));
				kind.setKindTitle(set.getString(SQLInfo.KIND_OF_CATE.FIELD_KIND_TITLE));
				kind.setCreateTime(set.getTimestamp(SQLInfo.FIELD_CREATE_TIME));
				kind.setUpdateTime(set.getTimestamp(SQLInfo.FIELD_UPDATE_TIME));
				kind.setCreaterId(set.getInt(SQLInfo.FIELD_CREATER_ID));
				kind.setStatus(set.getInt(SQLInfo.FIELD_STATUS));
				kinds.add(kind);
			}
			return kinds;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
