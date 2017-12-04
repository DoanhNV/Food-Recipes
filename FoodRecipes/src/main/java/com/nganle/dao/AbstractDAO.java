package com.nganle.dao;

import java.sql.Connection;

public abstract class AbstractDAO {
	protected static Connection connection = DBConnection.getConnection();

	public Connection getConnection() {
		return connection;
	}

}
