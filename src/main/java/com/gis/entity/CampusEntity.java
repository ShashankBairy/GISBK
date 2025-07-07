package com.gis.entity;

import jakarta.persistence.Column;
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
@Table(name="sce_campus", schema="`sce_geo_locations`")
public class CampusEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int campus_id;
	
	private String campus_code;
	@Column(name= "campus_name")
	private String campusName;
	private String campus_type;
	private int status;
	private String address_dno;
	private String land_mark;
	private String location;
	private String public_ip;
	private String college_type;
	
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

}
