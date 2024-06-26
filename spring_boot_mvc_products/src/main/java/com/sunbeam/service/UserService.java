package com.sunbeam.service;

import com.sunbeam.entities.User;

public interface UserService {
//user authentication
	User authenticateUser(String email,String password);

}
