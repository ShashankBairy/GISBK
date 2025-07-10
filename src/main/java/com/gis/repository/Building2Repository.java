package com.gis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gis.entity.Building;
import com.gis.entity.Campus;

@Repository
public interface Building2Repository extends JpaRepository<Building, Integer> {

	List<Building> findByCampus(Campus campus);
	
}
