package com.gis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gis.entity.CityEntity;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, Integer>{

	CityEntity findByCityName(String cityName);
}
