package com.blog.DAO;

import java.sql.SQLException;
import java.util.List;

import com.blog.entity.User;

public interface UserDAO extends AutoCloseable {

	int userRegistration(User u) throws SQLException;
	List<User>displayAllUsers() throws SQLException;
	User checkLogin(String email);
}
