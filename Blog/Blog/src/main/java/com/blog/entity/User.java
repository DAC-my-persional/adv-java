package com.blog.entity;

public class User {

	private int id;
	private String email;
	private String password;
	private String fullName;
	private String phoneNo;
	private String address;
	
	public User()
	{
		
	}

	public User(int id,String fullName, String email, String password, String phoneNo,String address) {
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.phoneNo = phoneNo;
		this.address = address;
	}
	public String getAddress()
	{
		return address;
	}
	
	public void setAddress(String address)
	{
		this.address = address;
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

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	
	public void setId(int id)
	{
		this.id =  id;
	}
	
	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", fullName=" + fullName
				+ ", phoneNo=" + phoneNo + ", address=" + address + "]";
	}
	
}
