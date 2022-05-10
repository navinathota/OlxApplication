package com.zensar.master.service;

import java.util.List;

import com.zensar.master.dto.MasterDto;
import com.zensar.master.entity.Category;
import com.zensar.master.entity.Status;

public interface Masterservice {
	List<MasterDto> getAllAdvertisementCategories(int pageNumber,int pageSize);
	List<MasterDto> getAllAdvertisementStatus(int pageNumber,int pageSize);
	List<MasterDto> findOlxByCategory( String category);
	List<MasterDto> findOlxByStatus( String status);
}
