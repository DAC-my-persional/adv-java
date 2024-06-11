package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	private static final String URL="jdbc:mysql://localhost:3306/election_db_servlet";
	private static final String USERNAME="root";
	private static final String PASSWORD="password";
	
	public static Connection getConnection() throws Exception {
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}
}
