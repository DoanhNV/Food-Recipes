package com.nganle.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.nganle.dao.AbstractDAO;
import com.nganle.dao.UserDAO;
import com.nganle.entity.User;
import com.nganle.support.constant.SQLString;

@Repository
public class UserDAOImpl extends AbstractDAO implements UserDAO {
	private Connection connection = this.getConnection();
	
	public boolean create(User user) {
		try {
			PreparedStatement prepare = connection.prepareStatement(SQLString.USER.CREATE_USER);
			prepare.setString(1, user.getUserName());
			prepare.setString(2, user.getFullName());
			prepare.setString(3, user.getEmail());
			prepare.setString(4, user.getPassword());
			prepare.setString(5, user.getMd5Password());
			Date birthDay = new Date(user.getBirthday().getTime());
			prepare.setDate(6,birthDay);
			prepare.setString(7, user.getRecipeSavedIds().toString()); // Json
			prepare.setString(8, user.getTipSavedIds().toString()); // json
			prepare.setString(9, user.getProfileImage());
			prepare.setInt(10, user.getNumberOfRecipe());
			prepare.setBoolean(11, user.isAdmin());
			Date createTime = new Date(user.getCreateTime().getTime());
			prepare.setDate(12, createTime);
			Date updateTime = new Date(user.getUpdateTime().getTime());
			prepare.setDate(13, updateTime);
			prepare.setInt(14, user.getStatus());
			return prepare.execute();
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
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean delete(String userId) {
		// TODO Auto-generated method stub
		return false;
	}

}
