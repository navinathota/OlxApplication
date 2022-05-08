package com.zensar.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.zensar.entity.User;
import com.zensar.repository.LoginRepository;
@Service
@Component
public class LoginServiceImp implements LoginService {
	
	@Autowired
	private LoginRepository loginRepository;
	//private ModelMapper modelMapper=new ModelMapper();
	@Autowired
	private ModelMapper modelMapper;
	
	static List<User> users=new ArrayList<User>();
	static {
		users.add(new User(1L, "Anand", "Kulkarni", "anand", "anand123", "anand@gmail.com", 12345));
	}
	@Override
	public List<User> getAllUsers(String username, String password) {
		if(username.equals("anand")&&password.equals("anand123")) {
		return users;
		}
		return null;
	}

	@Override
	public User registerUser(User user) {
		users.add(user);
		return user;
	}

	@Override
	public String loginUser(User user) {
		return user.getUserName()+"\n"+user.getPassword();
	}

	@Override
	public boolean logoutUser(long id1, String username, String password) {
		if(username.equals("anand")&&password.equals("anand123")) {
			for(User user:users) {
				if(user.getId()==id1) {
					users.remove(user);
					return true;
				}
			}
	}
		return false;
	}

}
