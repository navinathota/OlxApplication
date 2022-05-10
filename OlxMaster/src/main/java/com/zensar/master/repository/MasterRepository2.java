package com.zensar.master.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zensar.master.entity.Status;
@Repository
public interface MasterRepository2 extends JpaRepository<Status,Long>{
	
	@Query(value="select * from status where status=:statusList",nativeQuery=true)
	List<Status> findOlxByStatus(@Param("statusList") String status);

}
