package com.gis.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CampusDto {
	
	private int building_address_id;
	private Double latitude;
	private Double longitude;

}
