package com.gis.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
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

@Table(name="BUILDING", schema="`sce_geo_locations`")
public class Building {
	
	@Id
	@GeneratedValue
	@Column(name="BUILDING_ID")
	private int building_id;
	
	@Column(name="BUILDING_NAME")
	private String buildingName;
	
	@Column(name="ADDRESS_DNO")
	private String address_dno;
	
	@Column(name="BUILDING_ADDRESS")
	private String building_address;
	
	@Column(name="LAND_MARK")
	private String land_mark;
	
	@Column(name="PIN")
	private String pin;
	
	@Column(name="BUILDING_PURPOSE")
	private String building_purpose;
	
	@Column(name="STREET")
	private String street;
	
	@OneToOne
	@JoinColumn(name="CAMPUS_ID",referencedColumnName="CAMPUS_ID")
	private Campus campus;
	
	@Column(name="LATITUDE")
	private String latitude;
	
	@Column(name="LONGITUDE")
	private String longitude;
	
	@Column(name="CAPACITY")
	private int capacity;
	
	@Column(name="SQ_FT")
	private int sq_ft;
	
	@Column(name="RENT")
	private int rent;
//	
//	@Column(name="FUSION_BUILDING_CODE")
//	private int fusion_building_code;
	
//	@Column(name="FUSION_BUILDING_NAME")
//	private String fusion_building_name;
//	
//	@Column(name="FUSION_BUILDING_CODE_PROD")
//	private String fusion_buidling_code_prod;
//	
//	@Column(name="FUSION_BUILDING_NAME_PROD")
//	private String fusion_buidling_name_prod;
	
	
	

}
