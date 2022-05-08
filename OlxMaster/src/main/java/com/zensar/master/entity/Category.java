package com.zensar.master.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Category {
	@Id//check if id and other annotations are imported from persistence package else exceptions may occur
	private long id;
	private String category;
}
