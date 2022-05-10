package com.zensar.master.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zensar.master.entity.Category;
@Repository
public interface MasterRepository extends JpaRepository<Category,Long>{
	
	@Query(value="select * from category where category=:category",nativeQuery=true)
	List<Category> findOlxByCategory(@Param("category") String category);
	
}
