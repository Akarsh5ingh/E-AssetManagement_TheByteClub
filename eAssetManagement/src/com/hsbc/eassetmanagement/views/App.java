package com.hsbc.eassetmanagement.views;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.hsbc.eassetmanagement.helper.MySQLHelper;

public class App {

	public static void main(String[] args) {
		Connection conn;
		ResourceBundle resourceBundle;
		PreparedStatement statement;
		ResultSet resultSet;
		
		try {
			conn = MySQLHelper.getConnection();
			System.out.println(conn);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

}
