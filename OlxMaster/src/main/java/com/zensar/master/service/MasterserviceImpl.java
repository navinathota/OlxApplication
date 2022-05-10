package com.zensar.master.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.master.dto.MasterDto;
import com.zensar.master.entity.Category;
import com.zensar.master.entity.Status;
import com.zensar.master.repository.MasterRepository;
import com.zensar.master.repository.MasterRepository2;
@Service
public class MasterserviceImpl implements Masterservice{
	@Autowired
	private MasterRepository masterRepository;
	private MasterRepository2 masterRepository2;
	private ModelMapper modelMapper=new ModelMapper();

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
	public List<MasterDto> getAllAdvertisementCategories(int pageNumber,int pageSize) {
		// TODO Auto-generated method stub
		//return category;
		List<Category> ListOlx = masterRepository.findAll();
		
		List<MasterDto> olxResponses = new ArrayList<>();

		for (Category olx : category) {
			MasterDto response=modelMapper.map(olx, MasterDto.class);
			olxResponses.add(response);
		}
		return olxResponses;
	}

	@Override
	public List<MasterDto> getAllAdvertisementStatus(int pageNumber,int pageSize) {
		// TODO Auto-generated method stub
		//return status;
		List<Status> ListStatus = masterRepository2.findAll();
		
		List<MasterDto> olxResponses = new ArrayList<>();

		for (Status olx : status) {
			MasterDto response=modelMapper.map(olx, MasterDto.class);
			olxResponses.add(response);
		}
		return olxResponses;
	}

	
  
	 @Override
		public List<MasterDto> findOlxByCategory(String category) {
		  List<Category> findcategory=masterRepository.findOlxByCategory(category);
		  List<MasterDto> olxResponses = new ArrayList<>();
		  for(Category st:findcategory) {
			  MasterDto response=modelMapper.map(st, MasterDto.class);
		  olxResponses.add(response);
		  }
		  return olxResponses;
		}
	  
	  @Override
		public List<MasterDto> findOlxByStatus(String statusList) {
		  List<Status> findStatus=masterRepository2.findOlxByStatus(statusList);
		  List<MasterDto> olxResponses = new ArrayList<>();
		  for(Status st:findStatus) {
			  MasterDto response=modelMapper.map(st, MasterDto.class);
		  olxResponses.add(response);
		  }

		  return olxResponses;
		}
	/*
	 * private OlxCategories mapToOlxCategories(OlxMasterDto olxRequest) {
	 * OlxCategories newOlx = new OlxCategories(); newOlx.setId(olxRequest.getId());
	 * newOlx.setCategory(olxRequest.getCategory());
	 * return newOlx; }
	 * private OlxCategories mapToOlxCategories1(OlxMasterDto olx) {
	 * OlxCategories newOlx = new OlxCategories();
	 * newOlx.setId(olx.getId());
	 * newOlx.setCategory(olx.getCategory());
	 * return newOlx;
	 * }
	 */
	private MasterDto mapToResponse(Category olx) {
		MasterDto olxResponse = new MasterDto();
		olxResponse.setId(olx.getId());
		olxResponse.setCategory(olx.getCategory());
		return olxResponse;
	}
	/* private Status mapToStatus(MasterDto olxRequest) {
	 * Status newOlx = new Status();
	 * newOlx.setStatus(olxRequest.getStatus());
	 * return newOlx; 
	 * }
	 * private Status mapToOlxStatus(MasterDto olx) {
	 * Status newOlx = new Status();
	 * newOlx.setStatusId(olx.getStatusId());
	 * newOlx.setStatus(olx.getStatus());
	 * return newOlx;
	 * }
	 */
	private MasterDto mapToResponse(Status olx) {
		MasterDto olxResponse = new MasterDto();
		olxResponse.setStatus(olx.getStatusId());
		olxResponse.setStatus(olx.getStatus());
		return olxResponse;
	}

	
	
	
}
