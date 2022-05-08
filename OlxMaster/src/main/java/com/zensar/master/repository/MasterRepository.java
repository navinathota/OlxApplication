package com.zensar.master.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zensar.master.entity.Category;

import com.zensar.master.entity.Status;
@Repository
public interface MasterRepository extends JpaRepository<Category,Long>{
	
}
