package com.gis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gis.entity.BuildingEntity;
import com.gis.entity.CityEntity;
import com.gis.entity.CountryEntity;
import com.gis.entity.DistrictEntity;
import com.gis.entity.StateEntity;

@Repository
public interface BuildingRepository extends JpaRepository<BuildingEntity, Integer> {

	List<BuildingEntity> findByState(StateEntity state);
	
	List<BuildingEntity> findByDistrict(DistrictEntity district);
	
	List<BuildingEntity> findByCountry(CountryEntity country);
	
	List<BuildingEntity> findByCity(CityEntity city);
}
