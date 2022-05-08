package com.zensar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zensar.entity.Advertise;
@Repository
public interface AdvertiseRepository extends JpaRepository<Advertise,Long> {

}
