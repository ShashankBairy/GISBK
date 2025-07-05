package com.gis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gis.entity.DistrictEntity;

@Repository
public interface DistrictRepository extends JpaRepository<DistrictEntity, Integer> {

	DistrictEntity findByDistrictName(String district_name);
}
