package com.blog.DAO;

import java.sql.Connection;
import java.sql.SQLException;

import com.blog.DBUtil.DBUtil;

public class DAO {
	
	protected Connection connection;
	public DAO() throws Exception {
		connection = DBUtil.getConnection();
	}
	public void close() {
		try {
			if(connection != null)
				connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
