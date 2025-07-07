package com.gis.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gis.dto.CampusDto;
import com.gis.entity.BuildingAddressEntity;
import com.gis.entity.BuildingEntity;
import com.gis.entity.CampusEntity;
import com.gis.entity.CityEntity;
import com.gis.entity.CountryEntity;
import com.gis.entity.DistrictEntity;
import com.gis.entity.StateEntity;
import com.gis.repository.BuildingAddressRepository;
import com.gis.repository.BuildingRepository;
import com.gis.repository.CampusRepository;
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
	
	@Autowired CampusRepository campusRepo;
	
	
	
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
	
	public CampusDto buildingAddToCampusDto(int building_address_id,String building_name, 
			Double latitude, Double longitude,String campus_name ){
		CampusDto campus = new CampusDto();
		campus.setBuilding_address_id(building_address_id);
		campus.setBuilding_name(building_name);
		campus.setLatitude(latitude);
		campus.setLongitude(longitude);
		campus.setCampus_name(campus_name);
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
	                a.getBuilding_name(),
	                buildingAdd.getLatitude(),
	                buildingAdd.getLongitude(),
	                buildingAdd.getBuilding().getCampus().getCampusName()
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
						 building.getBuilding_name(),
			             buildingAdd.getLatitude(),
			             buildingAdd.getLongitude(),
			             buildingAdd.getBuilding().getCampus().getCampusName()
			             );
				campuses.add(campus);
			});
		}
		
		return campuses;
	}
	
	public List<CampusDto> findBuildingsByLocation(
            String countryName,
            String stateName,
            String districtName,
            String cityName,
            String campusName) {
		
		List<CampusDto> campuses = new ArrayList<>();

        // Check which parameter is provided and fetch buildings accordingly
        if (countryName != null && !countryName.isEmpty()) {
            CountryEntity country = countryRepo.findByCountryName(countryName);
            if (country != null) {
                List<BuildingEntity> buildings= buildingRepo.findByCountry(country);
                for(BuildingEntity building: buildings) {
                	buildingAddressRepo.findByBuilding(building).ifPresent(buildingAdd ->{
        				CampusDto campus = buildingAddToCampusDto(
        						 buildingAdd.getBuilding_address_id(),
        						 building.getBuilding_name(),
        			             buildingAdd.getLatitude(),
        			             buildingAdd.getLongitude(),
        			             buildingAdd.getBuilding().getCampus().getCampusName()

        			             );
        				campuses.add(campus);
        			});
              
                }
                return campuses;
            }
        } else if (stateName != null && !stateName.isEmpty()) {
            StateEntity state = stateRepo.findByStateName(stateName);
            if (state != null) {
            	List<BuildingEntity> buildings= buildingRepo.findByState(state);
            	for(BuildingEntity building: buildings) {
                	buildingAddressRepo.findByBuilding(building).ifPresent(buildingAdd ->{
        				CampusDto campus = buildingAddToCampusDto(
        						 buildingAdd.getBuilding_address_id(),
        						 building.getBuilding_name(),
        			             buildingAdd.getLatitude(),
        			             buildingAdd.getLongitude(),
        			             buildingAdd.getBuilding().getCampus().getCampusName()
        			             );
        				campuses.add(campus);
        			});
              
                }
            	return campuses;
            }
        } else if (districtName != null && !districtName.isEmpty()) {
            DistrictEntity district = districtRepo.findByDistrictName(districtName);
            if (district != null) {
            	List<BuildingEntity> buildings= buildingRepo.findByDistrict(district);
            	for(BuildingEntity building: buildings) {
                	buildingAddressRepo.findByBuilding(building).ifPresent(buildingAdd ->{
        				CampusDto campus = buildingAddToCampusDto(
        						 buildingAdd.getBuilding_address_id(),
        						 building.getBuilding_name(),
        			             buildingAdd.getLatitude(),
        			             buildingAdd.getLongitude(),
        			             buildingAdd.getBuilding().getCampus().getCampusName()

        			             );
        				campuses.add(campus);
        			});
              
                }
            	return campuses;
            }
        }else if (cityName != null && !cityName.isEmpty()) {
            CityEntity city = cityRepo.findByCityName(cityName);
            if (city != null) {
            	List<BuildingEntity> buildings= buildingRepo.findByCity(city);
            	for(BuildingEntity building: buildings) {
                	buildingAddressRepo.findByBuilding(building).ifPresent(buildingAdd ->{
        				CampusDto campus = buildingAddToCampusDto(
        						 buildingAdd.getBuilding_address_id(),
        						 building.getBuilding_name(),
        			             buildingAdd.getLatitude(),
        			             buildingAdd.getLongitude(),
        			             buildingAdd.getBuilding().getCampus().getCampusName()

        			             );
        				campuses.add(campus);
        			});
              
                }
            	return campuses;
            }
        } else if (campusName != null && !campusName.isEmpty()) {
            CampusEntity campus = campusRepo.findByCampusName(campusName);
            if (campus != null) {
            	List<BuildingEntity> buildings= buildingRepo.findByCampus(campus);
            	for(BuildingEntity building: buildings) {
                	buildingAddressRepo.findByBuilding(building).ifPresent(buildingAdd ->{
        				CampusDto campusAdd = buildingAddToCampusDto(
        						 buildingAdd.getBuilding_address_id(),
        						 building.getBuilding_name(),
        			             buildingAdd.getLatitude(),
        			             buildingAdd.getLongitude(),
        			             buildingAdd.getBuilding().getCampus().getCampusName()

        			             );
        				campuses.add(campusAdd);
        			});
              
                }
            	return campuses;
            }
        }

        // Return empty list if no valid parameter is provided
        return Collections.emptyList();
    }
	
	public BuildingAddressEntity buildingIdToAdd(BuildingEntity building){
		BuildingAddressEntity buildingAdd = buildingAddressRepo.findByBuilding(building).orElse(null);
		return buildingAdd;
	}
	
	public List<CampusDto> getAllBuildingAddress(){
		List<BuildingEntity> buildings = buildingRepo.findAll();
		
		List<CampusDto> campuses = new ArrayList<>();
		
		for(BuildingEntity building: buildings) {
        	buildingAddressRepo.findByBuilding(building).ifPresent(buildingAdd ->{
				CampusDto campusAdd = buildingAddToCampusDto(
						 buildingAdd.getBuilding_address_id(),
						 building.getBuilding_name(),
			             buildingAdd.getLatitude(),
			             buildingAdd.getLongitude(),
			             buildingAdd.getBuilding().getCampus().getCampusName()

			             );
				campuses.add(campusAdd);
			});
		}
		
		return campuses;
	}

}
