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

@Table(name="sce_building_address", schema="`sce_geo_locations`")
public class BuildingAddressEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int building_address_id;
	private String address;
	private Double latitude;
	private Double longitude;
	private String postal_address;
	
	@OneToOne
	@JoinColumn(name="building_id", referencedColumnName="building_id")
	private BuildingEntity building;
	

}
