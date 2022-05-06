package com.zensar.login.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {
	private long id;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String email;
	private long phone;

}
