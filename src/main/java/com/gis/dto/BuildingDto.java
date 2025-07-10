package com.gis.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuildingDto {
	
	private String building_name;
	private String buidling_address;
	private String land_mark;
	private String street;
	private String building_purpose;
	private String latitude;
	private String longitude;
	private String campus_name;
	private String campus_type;
	private String college_type;


}
