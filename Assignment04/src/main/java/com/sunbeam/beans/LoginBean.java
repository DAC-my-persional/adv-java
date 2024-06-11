package com.sunbeam.beans;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

public class LoginBean {
	private String email;
	private String password;
	private User user;

	public LoginBean() {
	}

	public LoginBean(String email, String password, User user) {
		this.email = email;
		this.password = password;
		this.user = user;
	}

	public LoginBean(String email, String password) {
		this.email = email;
		this.password = password;
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

	public User authenticate() {
		try (UserDao udao = new UserDaoImpl()) {
			user=new User(email, password);
			user = udao.findByEmail(email);
			if (user != null && password.equals(user.getPassword())) {
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
