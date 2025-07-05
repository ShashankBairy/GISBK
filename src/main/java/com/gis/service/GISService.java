package com.gis.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gis.dto.CampusDto;
import com.gis.entity.BuildingAddressEntity;
import com.gis.entity.BuildingEntity;
import com.gis.entity.CityEntity;
import com.gis.entity.CountryEntity;
import com.gis.entity.DistrictEntity;
import com.gis.entity.StateEntity;
import com.gis.repository.BuildingAddressRepository;
import com.gis.repository.BuildingRepository;
import com.gis.repository.CityRepository;
import com.gis.repository.CountryRepository;
import com.gis.repository.DistrictRepository;
import com.gis.repository.StateRepository;

@Service
public class GISService {
	
	@Autowired
	private BuildingAddressRepository buildingAddressRepo;
	
	@Autowired
	private BuildingRepository buildingRepo;
	
	@Autowired
	private StateRepository stateRepo;
	
	@Autowired
	private DistrictRepository districtRepo;
	
	@Autowired
	private CountryRepository countryRepo;
	
	@Autowired
	private CityRepository cityRepo;
	
	
	
	public List<BuildingAddressEntity> getAllBuildings (){
		return buildingAddressRepo.findAll();
	}
	
	public List<CampusDto> getAddressByState(String state_name){
		
		List<BuildingEntity> buildings = getBuildingsByStateName(state_name);
		
		List<CampusDto> buildingids = new ArrayList<>();
//		List<BuildingAddressEntity> buildingids = new ArrayList<>();
		
		for(BuildingEntity a : buildings) {
			BuildingAddressEntity buildingAdd = buildingAddressRepo.findByBuilding(a).orElse(null);
			if (buildingAdd != null) {
	            CampusDto campus = new CampusDto();
	            campus.setBuilding_address_id(buildingAdd.getBuilding_address_id());
	            campus.setLatitude(buildingAdd.getLatitude());
	            campus.setLongitude(buildingAdd.getLongitude());
	            buildingids.add(campus);
	        }
		}
		
		return buildingids;
		
	}
	
	public List<BuildingEntity> getBuildingsByStateName(String state_name){
		StateEntity state = stateRepo.findByStateName(state_name);
		
		List<BuildingEntity> buildings = buildingRepo.findByState(state);
		return buildings;
	}
	
	public StateEntity getState(int state_id) {
		return stateRepo.findById(state_id).orElse(null);
	}
	
	public BuildingAddressEntity getBuildingAddById(int id) {
		BuildingAddressEntity buildingAdd = buildingAddressRepo.findById(id).orElse(null);
		return buildingAdd;
	}
	
	public List<BuildingEntity> getBuildingByDistrict(String district_name){
		DistrictEntity district = districtRepo.findByDistrictName(district_name);
		List<BuildingEntity> buildings = buildingRepo.findByDistrict(district);
		return buildings;
	}
	
	public List<CampusDto> getBuildingAddByDis(String district_name){
		List<BuildingEntity> buildings = getBuildingByDistrict(district_name);
		
		List<CampusDto> buildingAdd = new ArrayList<>();
		
		for(BuildingEntity a : buildings) {
			BuildingAddressEntity newBuilding = buildingAddressRepo.findByBuilding(a).orElse(null);
			if (buildingAdd != null) { // Add null check
	            CampusDto campus = new CampusDto();
	            campus.setBuilding_address_id(newBuilding.getBuilding_address_id());
	            campus.setLatitude(newBuilding.getLatitude());
	            campus.setLongitude(newBuilding.getLongitude());
	            buildingAdd.add(campus);
	        }
		}
		
		return buildingAdd;
	}
	
	public CampusDto buildingAddToCampusDto(int building_address_id, Double latitude, Double longitude ){
		CampusDto campus = new CampusDto();
		campus.setBuilding_address_id(building_address_id);
		campus.setLatitude(latitude);
		campus.setLongitude(longitude);
		return campus;
	}
	
	public List<CampusDto> buildingAddByCountry(String country_name){
		CountryEntity country = countryRepo.findByCountryName(country_name);
		
		List<CampusDto> campuses = new ArrayList<>();
		if(country == null) {
			return Collections.emptyList();	
		}
		List<BuildingEntity> buildings = buildingRepo.findByCountry(country);
		
		for(BuildingEntity a : buildings) {
			buildingAddressRepo.findByBuilding(a).ifPresent(buildingAdd -> {
	            CampusDto campus = buildingAddToCampusDto(
	                buildingAdd.getBuilding_address_id(),
	                buildingAdd.getLatitude(),
	                buildingAdd.getLongitude()
	            );
	            campuses.add(campus);
	        });
		}
		
		return campuses;
	}
	
	public List<CampusDto> getBuildingAddByCity(String city_name){
		CityEntity city = cityRepo.findByCityName(city_name);
		if(city == null) {
			return Collections.emptyList();
		}
		
		List<CampusDto> campuses = new ArrayList<>();
		
		List<BuildingEntity> buildings = buildingRepo.findByCity(city);
		
		for(BuildingEntity building : buildings) {
			buildingAddressRepo.findByBuilding(building).ifPresent(buildingAdd ->{
				CampusDto campus = buildingAddToCampusDto(
						 buildingAdd.getBuilding_address_id(),
			             buildingAdd.getLatitude(),
			             buildingAdd.getLongitude()
			             );
				campuses.add(campus);
			});
		}
		
		return campuses;
	}

}
