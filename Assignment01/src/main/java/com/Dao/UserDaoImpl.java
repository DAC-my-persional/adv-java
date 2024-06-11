package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.User;
import com.utils.DbUtil;

public class UserDaoImpl implements AutoCloseable {
	private Connection connection;

	public UserDaoImpl() throws Exception {
		connection = DbUtil.getConnection();
	}

	public List<User> getAllUser() throws Exception {
		String queryText = "select * from User";
		List<User> UserList = null;
		try (PreparedStatement smt = connection.prepareStatement(queryText)) {
			ResultSet rs = smt.executeQuery();
			UserList = new ArrayList<User>();
			while (rs.next()) {
				User User = new User();
				User.setUserId(rs.getInt(1));
				User.setFirst_Name(rs.getString(2));
				User.setLast_Name(rs.getString(3));
				User.setEmail(rs.getString(4));
				User.setPassword(rs.getString(5));
				User.setDob(rs.getDate(6));
				User.setStatus(rs.getBoolean(7));
				User.setStatus(rs.getBoolean(8));
				UserList.add(User);
			}
		}
		return UserList;

	}

	public User findByEmail(String email) throws Exception {
		String queryText = "select * from User where email=?";
		List<User> userList = getAllUser();
		User User = new User();
		try (PreparedStatement smt = connection.prepareStatement(queryText)) {
			smt.setString(1, email);
			ResultSet rs = smt.executeQuery();

			while (rs.next()) {

				User.setUserId(rs.getInt(1));
				User.setFirst_Name(rs.getString(2));
				User.setLast_Name(rs.getString(3));
				User.setEmail(rs.getString(4));
				User.setPassword(rs.getString(5));
				User.setDob(rs.getDate(6));
				User.setStatus(rs.getBoolean(7));
				User.setStatus(rs.getBoolean(8));
				userList.add(User);

//				System.out.println(User.toString());
			}
		}
		return User;
	}

	User findById(int id) throws Exception {
		String queryText = "select * from User where id=?";
		List<User> userList = getAllUser();
		User User = new User();
		try (PreparedStatement smt = connection.prepareStatement(queryText)) {
			smt.setInt(1, id);
			ResultSet rs = smt.executeQuery();

			while (rs.next()) {
				User.setUserId(rs.getInt(1));
				User.setFirst_Name(rs.getString(2));
				User.setLast_Name(rs.getString(3));
				User.setEmail(rs.getString(4));
				User.setPassword(rs.getString(5));
				User.setDob(rs.getDate(6));
				User.setStatus(rs.getBoolean(7));
				User.setStatus(rs.getBoolean(8));
				userList.add(User);

				System.out.println(User.toString());
			}
		}

		return User;

	}

	public int save(User user) throws Exception {
		String sql = "insert into users values(default,?,?,?,?,?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, user.getFirst_Name());
			stmt.setString(2, user.getLast_Name());
			stmt.setString(3, user.getEmail());
			stmt.setString(4, user.getPassword());
			stmt.setDate(5, user.getDob());
			stmt.setBoolean(6, user.getStatus());
			stmt.setString(7, user.getRole());

			stmt.executeUpdate();
		}
		return 0;

	}

	public int updateStatus(int userId, boolean voted) throws Exception {
		String sql = "UPDATE users SET status = ? WHERE id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setBoolean(1, voted);
			stmt.setInt(2, userId);
			stmt.executeUpdate();
		}
		return 0;
	}

	public int updatePassword(int userId, String newPassword) throws Exception {
		String sql = "UPDATE users SET password = ? WHERE id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, newPassword);
			stmt.setInt(2, userId);
			stmt.executeUpdate();
		}
		return 0;
	}

	public int deleteById(int id) throws Exception {
		String sql = "delete from users where id=?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
		}
		return 0;
	}

	public int update(User user) throws Exception {
		String sql = "update users set first_name=?,last_name=?,email=?,password=?,dob=?,status=?,role=? where id=?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, user.getFirst_Name());
			stmt.setString(2, user.getLast_Name());
			stmt.setString(3, user.getEmail());
			stmt.setString(4, user.getPassword());
			stmt.setDate(5, user.getDob());
			stmt.setBoolean(6, user.getStatus());
			stmt.setString(7, user.getRole());
			stmt.setInt(8, user.getUserId());

			stmt.executeUpdate();
		}
		return 0;
	}

	@Override
	public void close() throws Exception {
		if (connection != null)
			connection.close();
	}
}
