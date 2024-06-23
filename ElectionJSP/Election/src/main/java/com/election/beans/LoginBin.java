package com.election.beans;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.election.DAO.UserDAO;
import com.election.DAO.UserDaoImpl;
import com.election.entity.User;

public class LoginBin {
	private String email;
	private String password;
	private User user;

	public LoginBin()
	{
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
//	public void authenticate()
//	{
//		String url = "jdbc:mysql://localhost:3306/electiondb";
//		String user = "root";
//		String pass = "managaer";
//		
//		try(Connection con = DriverManager.getConnection(url,user,pass)) {
//			String query = "Select * from users where email = ? and password = ?";
//			
//			PreparedStatement statment = con.prepareStatement(query);
//			statment.setString(1, this.email);
//			statment.setString(2, this.password);
//			
//			ResultSet rs = statment.executeQuery();
//			if(rs.next())
//			{
//				int id = rs.getInt("id");
//				String firstName = rs.getString("first_name");
//				String lastName = rs.getString("last_name");
//				email = rs.getString("email");
//				password = rs.getString("password");
//				Date dob  = rs.getDate("dob");
//				int status = rs.getInt("status");
//				String role = rs.getString("role");
//				this.user = new User(id,firstName,lastName,email,password,dob,status,role);
//			}
//			else	
//			{
//				this.user = null;
//			}
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
	
	public void authenticate()
	{
		try(UserDAO user = new UserDaoImpl())
		{
			 User u = user.findByEmail(email);
			 if(u != null && u.getPassword().equals(password))
				 this.user = u;
			 else
				 this.user = null;
		}catch (Exception e) {
			e.printStackTrace();
		}
	}	
}
