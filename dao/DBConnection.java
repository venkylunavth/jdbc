package com.ecom.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String user = "root";
	private static String password = "lvSEP@2000";
	private static String url = "jdbc:mysql://localhost:3306/ecom1";
	private static Connection con = null;

	public static Connection getConnection() {
		if (con == null) {
			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, user, password);
			} catch (ClassNotFoundException e) {
				System.out.println("driver not found");
			} catch (SQLException e) {
				System.out.println("can not connect with database : " + e);
			}
		}
		return con;
	}
}
