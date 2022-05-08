package com.zensar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.zensar.entity.User;

@Repository
public interface LoginRepository extends JpaRepository<User,Long>{
	//if application fails to start with exception embedded to database check if database is created in mysql or the url is proper
}
