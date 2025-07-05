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
@Table(name="sce_district", schema="`sce_geo_locations`")
public class DistrictEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int district_id;
	
	@Column(name="district_name")
	private String districtName;
	private int status;
	
	@OneToOne
	@JoinColumn(name = "state_id", referencedColumnName="state_id")
	private StateEntity state;
	
	

}
