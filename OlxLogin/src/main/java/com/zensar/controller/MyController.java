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
	import org.springframework.http.MediaType;
	import org.springframework.web.bind.annotation.RestController;
	import com.zensar.entity.User;
import com.zensar.service.LoginService;
	
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
			public List<User> getAllUsers(@RequestHeader("userName") String username,@RequestHeader("password") String password) {
				//if(username.equals("anand")&&password.equals("anand123")) {
					return loginservice.getAllUsers(username, password);
				//}
				//return null;
				}
			@PostMapping
			public ResponseEntity<User> registerUser(@RequestBody User user) {
				//users.add(user);
				User registerUser=loginservice.registerUser(user);
				if(registerUser==null) {
				return new ResponseEntity<User>(user,HttpStatus.BAD_REQUEST);
				}
				return new ResponseEntity<User>(user,HttpStatus.CREATED);
			}
			@PostMapping("/authenticate")
			public String loginUser(@RequestBody User user ) {
				return loginservice.loginUser(user);
				//return user.getUserName()+"\n"+user.getPassword();
			}
			@DeleteMapping("/logout/{userId}")
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




