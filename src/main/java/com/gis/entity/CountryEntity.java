package com.gis.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="sce_country", schema="`sce_geo_locations`")
public class CountryEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int country_id;
	@Column(name="country_name")
	private String countryName;
	private int status;
	

}
