package com.sunbeam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.custom_exceptions.AuthenticationException;
import com.sunbeam.dao.UserDao;
import com.sunbeam.entities.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	// depcy
	@Autowired
	private UserDao userDao;

	@Override
	public User authenticateUser(String email, String password) {
		// invoke dao's method
		return userDao.findByEmailAndPassword(email, password)
				.orElseThrow(
						() -> 
						new AuthenticationException("Invalid Email or Password !!!!!"));
	}
	/*
	 * In case of invalid login -throws NoSuchElemExc In case of valid login - rets
	 * User ref to the caller.
	 */

}
