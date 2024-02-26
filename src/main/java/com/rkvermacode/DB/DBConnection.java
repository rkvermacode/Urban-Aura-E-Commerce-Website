package com.rkvermacode.DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	private static String DB_URL = "jdbc:mysql://localhost:3306/urban_aura";
	private static String USER_NAME = "root";
	private static String PASSWORD = "root";
	
	private static Connection conn;
	public static Connection getConnection() {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL,USER_NAME, PASSWORD);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
