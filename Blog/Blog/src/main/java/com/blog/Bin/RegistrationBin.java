package com.blog.Bin;

import com.blog.DAO.UserDAO;
import com.blog.DAO.UserDAOImpl;
import com.blog.entity.User;

public class RegistrationBin {
	private String fullName;
	private String email;
	private String password;
	private String phoneNo;
	private String address;
	private int count;

	public RegistrationBin() {
		
	}
	
	public int getCount()
	{
		return count;
	}
	
	public void setCount(int count)
	{
		this.count = count;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
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
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void registerUser()
	{
		User u = new User(0,fullName,email,password,phoneNo,address);
		
		try
		{
			UserDAO userdao = new UserDAOImpl();
			userdao.userRegistration(u);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
