package com.gis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gis.entity.StateEntity;

@Repository
public interface StateRepository extends JpaRepository<StateEntity, Integer> {

	StateEntity findByStateName(String stateName);
	
}
