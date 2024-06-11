package com.sunbeam.beans;

import java.sql.Date;
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

public class RegisterBean {
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String dob;
	private String role;
	private User user;

	public RegisterBean() {

	}

	public RegisterBean(String firstName, String lastName, String email, String password, String dob, String role,
			User user) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.role = role;
		this.user = user;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int registerUser() {
		try (UserDao udao = new UserDaoImpl()) {
					Date date=Date.valueOf(dob);
					user=new User(firstName, lastName, email, password,date , 0, role);
			int count=udao.save(user,date);
			if(count!=0)
				return count;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
