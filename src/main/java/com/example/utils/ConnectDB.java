package com.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	private static final String JDBCDRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String JDBCURL = "jdbc:mysql://localhost:3306/managerproduct";
	private static final String USERNAME = "binh";
	private static final String PASSWORD = "12345";
	
//	Mo connection
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(JDBCDRIVER);
			connection = DriverManager.getConnection(JDBCURL,USERNAME,PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException(e);
		}
		return connection;
	}
	
//	close Connection
	public static void closeConnection(Connection connection) {
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
