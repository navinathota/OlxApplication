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
public class Advertise {
	@Id//check dependency properly if persistence annotation unavailable
	private long id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String userName;
    private String createdDate;
    private String modifiedDate;
    private String status;
    //private String postedBy;
    
    
}
