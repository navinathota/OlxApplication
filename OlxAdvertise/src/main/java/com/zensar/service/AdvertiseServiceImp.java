package com.zensar.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zensar.entity.Advertisement;
@Service 
public class AdvertiseServiceImp implements AdvertiseService{
	static List<Advertisement> advertisement = new ArrayList<Advertisement>();
	//public List<Advertisement> advertises=new ArrayList<Advertisement>();

	static {
		advertisement.add(new Advertisement(1L, "laptop sale", 54000, "Electronic goods", "intel core 3 Sony Vaio", "anand",
				"7/21/22", "7/21/22", "OPEN"));
		advertisement.add(new Advertisement(1L, "laptop sale", 54000, "Electronic goods", "intel core 3 Sony Vaio", "anand",
				"7/21/22", "7/21/22", "OPEN"));
	}
	
	@Override
	public Advertisement addAdvertise(Advertisement advertise, String username, String password) {
		if (username.equals("anand") && password.equals("anand123")) {
			advertisement.add(advertise);
			advertise.setCategory("Electronic goods");
			advertise.setUserName("anand");
			advertise.setCreatedDate("7/21/22");
			advertise.setModifiedDate("7/21/22");
			advertise.setStatus("OPEN");
			return advertise;
		}

		return null;
	}

	@Override
	public Advertisement getAdvertise(long postId, String username, String password) {
		if (username.equals("anand") && password.equals("anand123")) {
			
			for(Advertisement advertise:advertisement) {
				if(advertise.getId()==postId) {
					return advertise;
				}
				
			}
		}
			return null;
	}

	@Override
	public Advertisement updateAdvertise(long id, Advertisement advertises, String username, String password) {
		if (username.equals("anand") && password.equals("anand123")) {
			Advertisement advertise = getAdvertise(id, "anand", "anand123");
			advertise.setTitle(advertises.getTitle());
			advertise.setPrice(advertises.getPrice());
			advertise.setDescription(advertises.getDescription());
			
			return advertise;
		}

		return null;
	}

	@Override
	public List<Advertisement> getAllAdvertise(String username, String password) {
		if (username.equals("anand") && password.equals("anand123")) {
			return advertisement;
			}
			
			return null;
	}

	@Override
	public boolean deleteAdvertise(long id, String username, String password) {
		if (username.equals("anand") && password.equals("anand123")) {
			for(Advertisement advertise:advertisement) {
				if(advertise.getId()==id) {
					advertisement.remove(advertise);
					
					return true;
				}
			}
				
			}
			return false;
	}

	@Override
	public Advertisement searchAdvertisementsByCriteria(String category, String toDate, Long filtercriteria,
			String fromDate) {
		for(Advertisement advertise:advertisement) {
			if(advertise.getId()==filtercriteria||advertise.getCategory().equals(category)||advertise.getCreatedDate().equals(fromDate)||advertise.getModifiedDate().equals(toDate)) {
				return advertise;
			}

			
		}
		return null;
	}

	@Override
	public List<Advertisement> searchAdvertise() {
		return advertisement;
	}

	@Override
	public List<Advertisement> advertiseDetails(long id, String username, String password) {
		if (username.equals("anand") && password.equals("anand123")) {
			for(Advertisement advertise:advertisement) {
				if(advertise.getId()==id) {
			
					return advertisement;
				}
			}
		}
		return null;
	}

}
