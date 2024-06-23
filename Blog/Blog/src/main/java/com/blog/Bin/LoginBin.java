package com.blog.Bin;

import com.blog.DAO.UserDAO;
import com.blog.DAO.UserDAOImpl;
import com.blog.entity.User;

public class LoginBin {
	private String email;
	private String password;
	private User user;
	
	
	
	public LoginBin() {
		super();
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
	
	public void authenticate()
	{
		try
		{
			UserDAO userdao = new UserDAOImpl();
			 User u = userdao.checkLogin(email);
			if(u != null && u.getPassword().equals(password))
			{
				this.user = u;
			}
			else 
				this.user = null;
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
