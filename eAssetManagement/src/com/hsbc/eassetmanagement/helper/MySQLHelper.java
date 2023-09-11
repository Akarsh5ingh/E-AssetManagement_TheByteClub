package com.hsbc.eassetmanagement.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MySQLHelper {
private static ResourceBundle resourceBundle;
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		resourceBundle = ResourceBundle.getBundle("com.hsbc.eassetmanagement.resources.db");
		String userName = resourceBundle.getString("username");
		String password = resourceBundle.getString("password");
		String url = resourceBundle.getString("url");
		String driver = resourceBundle.getString("driverClassName");
		
		//Step1: Load the driver
		Class.forName(driver);
		
		//create the connection
		Connection conn = DriverManager.getConnection(url, userName, password);
		
		return conn;
	}
}
