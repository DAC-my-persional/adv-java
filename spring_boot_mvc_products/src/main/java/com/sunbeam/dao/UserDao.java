package com.sunbeam.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.User;

public interface UserDao extends JpaRepository<User, Long> {
	// add a method for user authentication
	//User authenticateUser(String email, String password);
	//use derived finder method
	Optional<User> findByEmailAndPassword(String em,String pass);

}
