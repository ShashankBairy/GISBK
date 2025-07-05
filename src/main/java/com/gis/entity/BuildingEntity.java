package com.gis.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name="sce_building", schema="`sce_geo_locations`")
public class BuildingEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int building_id;
	
	private String building_name;
	private String building_purpose;
	private String street;
	private int status;
	private Integer sq_ft;
	private String los;
	private String los_name;
	
	@OneToOne
	@JoinColumn(name="country_id", referencedColumnName="country_id")
	private CountryEntity country;
	
	@OneToOne
	@JoinColumn(name = "state_id", referencedColumnName="state_id")
	private StateEntity state;
	
	@OneToOne
	@JoinColumn(name="district_id", referencedColumnName="district_id")
	private DistrictEntity district;
	
	@OneToOne
	@JoinColumn(name="city_id", referencedColumnName="city_id")
	private CityEntity city;
	
	@OneToOne
	@JoinColumn(name="campus_id", referencedColumnName="campus_id")
	private CampusEntity campus;
	
	
	

}
