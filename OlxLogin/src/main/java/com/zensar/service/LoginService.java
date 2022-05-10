package com.zensar.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zensar.dto.UserDto;
import com.zensar.entity.User;
@Service
public interface LoginService {
		
	public List<UserDto> getAllUsers(String username,String password,int pageNumber, int pageSize);
	String loginUser( User user );
	boolean logoutUser( long id1, String username, String password);
	UserDto registerUser(UserDto userDto, String username);
}
