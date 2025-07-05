package com.gis.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gis.entity.BuildingAddressEntity;
import com.gis.entity.BuildingEntity;

@Repository
public interface BuildingAddressRepository extends JpaRepository<BuildingAddressEntity, Integer> {

     Optional<BuildingAddressEntity> findByBuilding(BuildingEntity building);
	
}
