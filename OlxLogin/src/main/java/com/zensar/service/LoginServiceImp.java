package com.zensar.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.zensar.dto.UserDto;
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
	
	/*public List<User> getAllUsers(String username, String password) {
		if(username.equals("anand")&&password.equals("anand123")) {
		return users;
		}
		return null;
	}*/
	@Override
	public List<UserDto> getAllUsers(String username, String password, int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		Page<User> listOlx = loginRepository.findAll( PageRequest.of(pageNumber, pageSize) );
		List<User> page = listOlx.getContent();

		List<UserDto> userResponse = new ArrayList<>();
		if(username.equals("anand")&&password.equals("anand123")) {
		for (User user :page ) {
			//UserResponse mapToResponse = mapToResponse(user);
			UserDto response=modelMapper.map(user, UserDto.class);
			userResponse.add(response);
		}
		return userResponse;

	}
		return null;
	}
	@Override
	public UserDto registerUser(UserDto userDto, String username) {
		
      User newOlx= modelMapper.map(userDto, User.class);
      if(username.equals("anand")){

		//if (token.equals("anand")) {
			 User signin = loginRepository.save(newOlx);
			return modelMapper.map(signin, UserDto.class);

		} else {
			return null;
		}
	}
	/*@Override
	public User registerUser(User user) {
		users.add(user);
		return user;
	}
*/
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

	private UserDto mapToEntity(UserDto userRequest) {
		UserDto newUser= new UserDto();
		newUser.setId(userRequest.getId());
		newUser.setFirstName(userRequest.getFirstName());
		newUser.setLastName(userRequest.getLastName());
		newUser.setUserName(userRequest.getUserName());
	    newUser.setPassword(userRequest.getPassword());
	    newUser.setEmail(userRequest.getEmail());
	    newUser.setPhone(userRequest.getPhone());
		return newUser;
		}
		/*private UserDto mapToResponse(UserDto userResponse) {
		UserDto newUser= new UserDto();
		newUser.setId(userResponse.getId());
		newUser.setFirstName(userResponse.getFirstName());
		newUser.setLastName(userResponse.getLastName());
		newUser.setUserName(userResponse.getUserName());
		newUser.setPassword(userResponse.getPassword());
	    newUser.setEmail(userResponse.getEmail());
	    newUser.setPhone(userResponse.getPhone());
		return newUser;
		}
		*/
		private UserDto mapToDto(UserDto user) {
		UserDto userResponse=new UserDto();
		userResponse.setId(user.getId());
		userResponse.setFirstName(user.getFirstName());
		userResponse.setLastName(user.getLastName());
		userResponse.setPhone(user.getPhone());
		userResponse.setEmail(user.getEmail());
		userResponse.setUserName(user.getUserName());
		userResponse.setPassword(user.getPassword());
		return userResponse;
		}
		
		}
