package com.gis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gis.entity.BuildingEntity;
import com.gis.entity.CampusEntity;
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
	
	List<BuildingEntity> findByCampus(CampusEntity campus);
		
//	@Query("SELECT b FROM BuildingEntity b LEFT JOIN FETCH b.buildingAddress " +
//	           "WHERE (:country IS NULL OR b.country = :country) " +
//	           "AND (:state IS NULL OR b.state = :state) " +
//	           "AND (:district IS NULL OR b.district = :district) " +
//	           "AND (:city IS NULL OR b.city = :city) " +
//	           "AND (:campus IS NULL OR b.campus = :campus)")
//	    List<BuildingEntity> findByOptionalCountryAndStateAndDistrictAndCityAndCampus(
//	        @Param("country") CountryEntity country,
//	        @Param("state") StateEntity state,
//	        @Param("district") DistrictEntity district,
//	        @Param("city") CityEntity city,
//	        @Param("campus") CampusEntity campus);
	
//	List<BuildingEntity> findByCountryOrStateOrDistrictOrCityOrCampus(CountryEntity country, StateEntity state,
//			DistrictEntity district, CityEntity city, CampusEntity campus);
}
