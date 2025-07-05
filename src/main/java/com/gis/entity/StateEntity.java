package com.gis.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name="sce_state", schema="`sce_geo_locations`")
public class StateEntity {
	
	@Id
	private int state_id;
	@Column(name="state_name")
	private String stateName;
	private int status;
	
	@OneToOne
	@JoinColumn(name="country_id", referencedColumnName="country_id")
	private CountryEntity country;
	

}
