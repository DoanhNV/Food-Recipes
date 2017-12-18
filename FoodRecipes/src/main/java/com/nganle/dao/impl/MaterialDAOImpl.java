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
import com.nganle.dao.MaterialDAO;
import com.nganle.entity.Material;
import com.nganle.support.constant.Constant;
import com.nganle.support.constant.SQLInfo;
import com.nganle.support.constant.SQLQuery;
import com.nganle.support.util.Utils;

@Repository
public class MaterialDAOImpl extends AbstractDAO implements MaterialDAO {
	private Connection connection = DBConnection.getConnection();

	public boolean create(Material material) {
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(SQLQuery.MATERIAL.CREATE);
			prepareStatement.setString(1, material.getMaterialName());
			prepareStatement.setString(2, material.getFeatureImage() == null ?"":material.getFeatureImage());
			prepareStatement.setTimestamp(3, Utils.getCurrentSQLDate());
			prepareStatement.setTimestamp(4, Utils.getCurrentSQLDate());
			prepareStatement.setInt(5, material.getCreaterId());
			prepareStatement.setInt(6, Constant.STATUS.ACTIVE_VALUE);
			prepareStatement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Material material) {
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(SQLQuery.MATERIAL.UPDATE);
			prepareStatement.setString(1, material.getMaterialName());
			prepareStatement.setString(2, material.getFeatureImage());
			prepareStatement.setTimestamp(3, Utils.getCurrentSQLDate());
			prepareStatement.setInt(4, material.getStatus());
			prepareStatement.setInt(5, material.getId());
			prepareStatement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Material getById(int id) {
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(SQLQuery.MATERIAL.GET_BY_ID);
			prepareStatement.setInt(1, id);
			ResultSet set = prepareStatement.executeQuery();
			while (set.next()) {
				Material material = new Material();
				material.setId(set.getInt(SQLInfo.FIELD_ID));
				material.setMaterialName(set.getString(SQLInfo.MATERIAL.FIELD_MATERIAL_NAME));
				material.setFeatureImage(set.getString(SQLInfo.MATERIAL.FIELD_FEATURE_IMAGE));
				material.setCreateTime(set.getTimestamp(SQLInfo.FIELD_CREATE_TIME));
				material.setUpdateTime(set.getTimestamp(SQLInfo.FIELD_UPDATE_TIME));
				material.setCreaterId(set.getInt(SQLInfo.FIELD_CREATER_ID));
				material.setStatus(set.getInt(SQLInfo.FIELD_STATUS));
				return material;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Material> listAll() {
		List<Material> result = new ArrayList<Material>();
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(SQLQuery.MATERIAL.LIST_ALL);
			ResultSet set = prepareStatement.executeQuery();
			while (set.next()) {
				Material material = new Material();
				material.setId(set.getInt(SQLInfo.FIELD_ID));
				material.setMaterialName(set.getString(SQLInfo.MATERIAL.FIELD_MATERIAL_NAME));
				material.setFeatureImage(set.getString(SQLInfo.MATERIAL.FIELD_FEATURE_IMAGE));
				material.setCreateTime(set.getTimestamp(SQLInfo.FIELD_CREATE_TIME));
				material.setUpdateTime(set.getTimestamp(SQLInfo.FIELD_UPDATE_TIME));
				material.setCreaterId(set.getInt(SQLInfo.FIELD_CREATER_ID));
				material.setStatus(set.getInt(SQLInfo.FIELD_STATUS));
				result.add(material);
			}
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean deleteById(int id) {
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(SQLQuery.MATERIAL.DELETE);
			prepareStatement.setInt(1, id);
			prepareStatement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<Material> getTopLimit(int limit, String field, String order) {
		List<Material> result = new ArrayList<Material>();
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(SQLQuery.MATERIAL.GET_TOP_LIMIT);
			prepareStatement.setString(1, field);
			prepareStatement.setString(2, order);
			prepareStatement.setInt(3, limit);
			ResultSet set = prepareStatement.executeQuery();
			while (set.next()) {
				Material material = new Material();
				material.setId(set.getInt(SQLInfo.FIELD_ID));
				material.setMaterialName(set.getString(SQLInfo.MATERIAL.FIELD_MATERIAL_NAME));
				material.setFeatureImage(set.getString(SQLInfo.MATERIAL.FIELD_FEATURE_IMAGE));
				material.setCreateTime(set.getTimestamp(SQLInfo.FIELD_CREATE_TIME));
				material.setUpdateTime(set.getTimestamp(SQLInfo.FIELD_UPDATE_TIME));
				material.setCreaterId(set.getInt(SQLInfo.FIELD_CREATER_ID));
				material.setStatus(set.getInt(SQLInfo.FIELD_STATUS));
				result.add(material);
			}
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
