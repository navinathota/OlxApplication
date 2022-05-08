package com.zensar.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zensar.entity.User;
@Service
public interface LoginService {
		
	public List<User> getAllUsers(String username,String password);
	User registerUser( User user);
	String loginUser( User user );
	boolean logoutUser( long id1, String username, String password);
}
