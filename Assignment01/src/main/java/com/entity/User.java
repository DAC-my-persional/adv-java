package com.entity;

import java.sql.Date;

public class User {
	private int userId;
	private String first_Name;
	private String last_Name;
	private String email;
	private String password;
	private Date dob;
	private boolean status;
	private String role;

	public User() {

	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirst_Name() {
		return first_Name;
	}

	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}

	public String getLast_Name() {
		return last_Name;
	}

	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", first_Name=" + first_Name + ", last_Name=" + last_Name + ", email="
				+ email + ", password=" + password + ", dob=" + dob + ", status=" + status + ", role=" + role + "]";
	}

	public User(int userId, String first_Name, String last_Name, String email, String password, Date dob, boolean status,
			String role) {
		super();
		this.userId = userId;
		this.first_Name = first_Name;
		this.last_Name = last_Name;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.status = status;
		this.role = role;
	}

}
