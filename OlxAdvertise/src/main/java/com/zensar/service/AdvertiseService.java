package com.zensar.service;

import java.util.List;

import com.zensar.entity.Advertisement;


public interface AdvertiseService {
	Advertisement addAdvertise( Advertisement advertise,String username,  String password);
	 
	 Advertisement getAdvertise( long postId, String username, String password);
    
	 Advertisement updateAdvertise( long id,  Advertisement advertises, String username, String password);
	 
	 List<Advertisement> getAllAdvertise( String username, String password);
	 
	 boolean deleteAdvertise( long id, String username, String password);
	 
	 Advertisement searchAdvertisementsByCriteria( String category, String toDate,Long filtercriteria, String fromDate);
	 
	 List<Advertisement> searchAdvertise();
	 
	 List<Advertisement> advertiseDetails( long id, String username, String password);
}
