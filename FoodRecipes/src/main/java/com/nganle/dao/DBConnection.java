package com.nganle.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String PORT = "3306";
	private static final String HOST = "localhost";
	private static final String DATABASE_NAME = "foodrecipes";
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "";
	private static final String CONNECTION_STRING = "jdbc:mysql://"+HOST+":"+PORT+"/"+DATABASE_NAME;
	private static Connection connection = null;
	
	public static Connection getConnection(){
		try {
			if(connection != null && !connection.isClosed()) {
				return connection;
			}
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(CONNECTION_STRING, USER_NAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
