package com.zensar.controller;
	import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestHeader;
	import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.MediaType;
	import org.springframework.web.bind.annotation.RestController;

import com.zensar.dto.UserDto;
import com.zensar.entity.User;
import com.zensar.service.LoginService;
import com.zensar.exceptions.InvalidStockIdException;
	
	@RestController
	@RequestMapping(value="/user",produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },consumes= { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public class MyController {
		@Autowired
		private LoginService loginservice;
		/*static List<User> users=new ArrayList<User>();
			static {
				users.add(new User(1L, "Anand", "Kulkarni", "anand", "anand123", "anand@gmail.com", 12345));
			}*/
			@GetMapping
			public List<UserDto> getAllUsers(@RequestHeader("userName") String username,
					@RequestHeader("password") String password,
					@RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber,
					@RequestParam(value = "pageSize", defaultValue = "5", required = false) int pageSize) {

					if(username.equals("anand")&&password.equals("anand123")) {
					return loginservice.getAllUsers(username, password,pageNumber, pageSize);
				}
				return null;
				}
			@PostMapping
			public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto,@RequestHeader("auth-token") String username) {
				UserDto registerUser=loginservice.registerUser( userDto,username);
				if(registerUser==null) {
				return new ResponseEntity<UserDto>(registerUser,HttpStatus.BAD_REQUEST);
				}
				return new ResponseEntity<UserDto>(registerUser,HttpStatus.CREATED);
			}
			@PostMapping("/authenticate")
			public String loginUser(@RequestBody User user ) throws InvalidStockIdException{
				return loginservice.loginUser(user);
				//return user.getUserName()+"\n"+user.getPassword();
			}
			@DeleteMapping("/logout/{userId}")//throws InvalidStockIdException
			public boolean logoutUser(@PathVariable("userId") long id1,@RequestHeader("userName") String username,@RequestHeader("password") String password) {
				/*if(username.equals("anand")&&password.equals("anand123")) {
						for(User user:users) {
							if(user.getId()==id1) {
								users.remove(user);
								return true;
							}
						}
				}*/
				return loginservice.logoutUser(id1, username, password);
			}
	}




