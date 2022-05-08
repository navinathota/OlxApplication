package com.zensar.master.service;

import java.util.List;

import com.zensar.master.entity.Category;
import com.zensar.master.entity.Status;

public interface Masterservice {
	List<Category> getAllAdvertisementCategories();
	List<Status> getAllAdvertisementStatus();
}
