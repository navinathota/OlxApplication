package com.zensar.entity;


import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
	@Id
	//without @entity and id annotations bean creation exceptions come to connect to entitymanagerfactory
private long id;
private String firstName;
private String lastName;
private String userName;
private String password;
private String email;
private long phone;
}


