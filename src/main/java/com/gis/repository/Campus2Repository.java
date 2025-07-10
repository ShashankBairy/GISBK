package com.gis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gis.entity.Campus;

@Repository
public interface Campus2Repository extends JpaRepository<Campus, Integer> {

	Campus findByCampusName(String campus_name);
	
}
