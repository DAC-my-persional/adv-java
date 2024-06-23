package com.blog.DAO;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.blog.entity.User;

public class UserDAOImpl extends DAO implements UserDAO
{

	public UserDAOImpl() throws Exception {
		
	}
	
	public int userRegistration(User u) throws SQLException
	{
		String query = "insert into users (id,full_name,email,password,phone_no,address) values(?,?,?,?,?,?)";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1,u.getId());
		statement.setString(2,u.getFullName());
		statement.setString(3, u.getEmail());
		statement.setString(4, u.getPassword());
		statement.setString(5, u.getPhoneNo());
		statement.setString(6, u.getAddress());
		
		int count = statement.executeUpdate();
		
		return count;
	}
	
	
	public List<User>displayAllUsers() throws SQLException 
	{
		String query = "Select * from users";
		PreparedStatement statement = connection.prepareStatement(query);
		ResultSet result = statement.executeQuery();
		List<User > userList = new ArrayList<>();
		
		while(result.next())
		{
			User u1 = new User();
			u1.setId(result.getInt(1));
			u1.setFullName(result.getString(2));
			u1.setEmail(result.getString(3));
			u1.setPassword(result.getString(4));
			u1.setPhoneNo(result.getString(5));
			u1.setAddress(result.getString(6));
			
			userList.add(u1);
		}
		return userList;
	}
	
	
	public User checkLogin(String email)
	{
		String sql="Select id,full_name,email, password,address from users where email=?";
		try (PreparedStatement stmt = connection.prepareStatement(sql))
		{
			
			stmt.setString(1, email);
			
			ResultSet rs= stmt.executeQuery();
			User u;
			rs.next();
			int id = rs.getInt("id");
			String fullName = rs.getString("full_Name");
			String email1 = rs.getString("email");
			String password1 = rs.getString("password");
			String address = rs.getString("address");
			u = new User(id,fullName,email1,password1,address,address);
			
			return u;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
