package com.zensar.master.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.master.entity.Category;
import com.zensar.master.entity.Status;
import com.zensar.master.service.Masterservice;
@RestController
@RequestMapping("/advertise")
public class MasterController {
	@Autowired
	private Masterservice masterservice;
	 /*List<Category> category=new ArrayList<Category>();
	public MasterController() {
		category.add(new Category(1L,"Furniture"));
		category.add(new Category(2L,"Cars"));
		category.add(new Category(3L,"Mobiles"));
		category.add(new Category(4L,"RealEstate"));
		category.add(new Category(5L,"Sports"));
	}
	//doesn't take 2 public methods use static methods,cause public uses void which returns null in post, work on issue later
	static List<Status> status=new ArrayList<Status>();
		static   {
		status.add(new Status(1L,"Open category"));
		status.add(new Status(2L,"Closed category"));
	
		}*/
	@GetMapping(value="/category",produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public List<Category> getAllAdvertisementCategories() {
	return masterservice.getAllAdvertisementCategories();
	}
	@GetMapping(value="/status",produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public List<Status> getAllAdvertisementStatus(){
	return masterservice.getAllAdvertisementStatus();
	}

}
