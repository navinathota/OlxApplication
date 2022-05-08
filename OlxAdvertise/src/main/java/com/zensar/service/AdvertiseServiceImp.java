package com.zensar.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zensar.entity.Advertise;
@Service
public class AdvertiseServiceImp implements AdvertiseService{
	static List<Advertise> advertisement = new ArrayList<Advertise>();
	//static List<Advertisement> advertises=new ArrayList<Advertisement>();

	static {
		advertisement.add(new Advertise(1L, "laptop sale", 54000, "Electronic goods", "intel core 3 Sony Vaio", "anand",
				"7/21/22", "24/21/22", "OPEN"));
		advertisement.add(new Advertise(2L, "Sofa for sale", 30000, "Furniture goods", "Sofa 5 years old for sale in pune", "anand",
				"7/21/22", "21/21/22", "OPEN"));
	}
	
	@Override
	public Advertise addAdvertise(Advertise advertise, String username, String password) {
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
	public Advertise getAdvertise(long postId, String username, String password) {
		if (username.equals("anand") && password.equals("anand123")) {
			
			for(Advertise advertise:advertisement) {
				if(advertise.getId()==postId) {
					return advertise;
				}
				
			}
		}
			return null;
	}
	
	@Override//working now
	public Advertise updateAdvertise(long id, Advertise advertises, String username, String password) {
	if (username.equals("anand") && password.equals("anand123")) {
	Advertise advertise = getAdvertise(id, "anand", "anand123");
	advertise.setTitle(advertises.getTitle());
	advertise.setPrice(advertises.getPrice());
	advertise.setDescription(advertises.getDescription());
	return advertise;
	} return null;
	}


	/*@Override
	public Advertise updateAdvertise(long id, Advertise advertises, String username, String password) {
		if (username.equals("anand") && password.equals("anand123") ) {
			Advertise advertise = getAdvertise(id, "anand", "anand123");
			advertise.setTitle(advertises.getTitle());
			advertise.setPrice(advertises.getPrice());
			advertise.setDescription(advertises.getDescription());
			advertise.setUserName(username);
			advertise.setCreatedDate("24-04-2022");
			advertise.setModifiedDate("24-04-2022");
			advertise.setStatus("OPEN");
			advertise.setId(id);
 			return advertise;
		}

		return null;
	}*/
	@Override
	public List<Advertise> getAllAdvertise(String username, String password) {
		if (username.equals("anand") && password.equals("anand123")) {
			return advertisement;
			}
			
			return null;
	}

	@Override
	public boolean deleteAdvertise(long id, String username, String password) {
		if (username.equals("anand") && password.equals("anand123")) {
			for(Advertise advertise:advertisement) {
				if(advertise.getId()==id) {
					advertisement.remove(advertise);
					
					return true;
				}
			}
				
			}
			return false;
	}

	@Override
	public Advertise searchAdvertisementsByCriteria(String category, String toDate, Long filtercriteria,
			String fromDate) {
		for(Advertise advertise:advertisement) {
			if(advertise.getId()==filtercriteria||advertise.getCategory().equals(category)||advertise.getCreatedDate().equals(fromDate)||advertise.getModifiedDate().equals(toDate)) {
				return advertise;
			}

			
		}
		return null;
	}

	@Override
	public List<Advertise> searchAdvertise() {
		return advertisement;
	}

	@Override
	public List<Advertise> advertiseDetails(long id, String username, String password) {
		if (username.equals("anand") && password.equals("anand123")) {
			for(Advertise advertise:advertisement) {
				if(advertise.getId()==id) {
			
					return advertisement;
				}
			}
		}
		return null;
	}

}
