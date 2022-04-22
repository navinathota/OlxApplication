package com.zensar.master.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zensar.master.entity.Category;
import com.zensar.master.entity.Status;
@Service
public class MasterserviceImpl implements Masterservice{
	 static List<Category> category=new ArrayList<Category>();
	  static {
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
		
			}
	@Override
	public List<Category> getAllAdvertisementCategories() {
		// TODO Auto-generated method stub
		return category;
	}

	@Override
	public List<Status> getAllAdvertisementStatus() {
		// TODO Auto-generated method stub
		return status;
	}

}
