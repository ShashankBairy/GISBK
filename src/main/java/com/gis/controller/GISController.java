package com.gis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gis.dto.CampusDto;
import com.gis.entity.BuildingAddressEntity;
import com.gis.entity.BuildingEntity;
import com.gis.entity.StateEntity;
import com.gis.service.GISService;

@RestController
@RequestMapping
@CrossOrigin
public class GISController {
	
	@Autowired
	private GISService gisservice;
	
	@GetMapping("/getAllBuildings")
	public List<BuildingAddressEntity> getAllBuildings(){
		return gisservice.getAllBuildings();
	}
	
	@GetMapping("/buildingsByStatename")
	public List<BuildingEntity> getByStateName(@RequestParam String state_name){
		return gisservice.getBuildingsByStateName(state_name);
	}
	
	@GetMapping("/getState")
	public StateEntity getState(@RequestParam int state_id) {
		return gisservice.getState(state_id);
	}
	
	@GetMapping("/buildingAddByStatename")
	public List<CampusDto> getBuildingAdd(@RequestParam String state_name){
		return gisservice.getAddressByState(state_name);
	}
	
	@GetMapping("/getBuildingAddress")
	public BuildingAddressEntity getBuildingAddById(@RequestParam int id) {
		return gisservice.getBuildingAddById(id);
	}
	
	@GetMapping("/getBuildingAddByDis")
	public List<CampusDto> getBuildingAddByDis(@RequestParam String district_name){
		return gisservice.getBuildingAddByDis(district_name);
	}
	
	@GetMapping("/getBuildinhAddByCountry")
	public List<CampusDto> getBuildingAddByCountry(@RequestParam String country_name){
		return gisservice.buildingAddByCountry(country_name);
	}
	
	@GetMapping("/getBuildingAddByCity")
	public List<CampusDto> getBuildingAddByCity(@RequestParam String city_name){
		return gisservice.getBuildingAddByCity(city_name);
	}
	
	 @GetMapping
	    public List<CampusDto> getBuildingsByLocation(
	            @RequestParam(name = "country", required = false) String countryName,
	            @RequestParam(name = "state", required = false) String stateName,
	            @RequestParam(name = "district", required = false) String districtName,
	            @RequestParam(name = "city", required = false) String cityName,
	            @RequestParam(name = "campus", required = false) String campusName) {

	        List<CampusDto> buildings = gisservice.findBuildingsByLocation(
	                countryName, stateName,districtName, cityName, campusName);

	        return buildings;
	    }
	 
	 @GetMapping("/allbuildingids")
	 public List<CampusDto> getAllBuildingsAdd(){
		 return gisservice.getAllBuildingAddress();
	 }
    

}
