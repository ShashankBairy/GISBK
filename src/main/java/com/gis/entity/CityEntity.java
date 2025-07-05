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
@Table(name="sce_city", schema="`sce_geo_locations`")
public class CityEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int city_id;
	
	private String city_code;
	
	@Column(name= "city_name")
	private String cityName;
	private int status;
	
	@OneToOne
	@JoinColumn(name="district_id", referencedColumnName="district_id")
	private DistrictEntity district;
	

}
