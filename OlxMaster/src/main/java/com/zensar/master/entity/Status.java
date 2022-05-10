package com.zensar.master.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Status {
	@Id
	private long statusId;
	private String status;
	public String getStatusId() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getStatus() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
