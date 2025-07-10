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

@Table(name="CAMPUS", schema="`sce_geo_locations`")
public class Campus {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CAMPUS_ID")
	private int campus_id;
	
	@Column(name="CAMPUS_CODE")
	private String campus_code;
	
	@Column(name="CAMPUS_NAME")
	private String campusName;
	
	@Column(name="CAMPUS_TYPE")
	private String campus_type;
	
	@Column(name="CODE")
	private String code;
	
	@Column(name="STATUS")
	private int status;
	
	@Column(name="ADDRESS_DNO")
	private String address_dno;
	
	@Column(name="LAND_MARK")
	private String land_mark;
	
	@Column(name="LOCATION")
	private String location;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="PIN")
	private String pin;
	
	@Column(name="PRINCIPAL_MOBILE")
	private String pricipal_mobile;
	
	@Column(name="STREET")
	private String street;
	
	@Column(name="CITY_ID")
	private Integer city_id;
	
	@Column(name="COUNTRY_ID")
	private Integer country_id;
	
	@Column(name="DISTRICT_ID")
	private Integer district_id;
	
	@Column(name="STATE_ID")
	private Integer state_id;
	
	@Column(name="ZONE_ID")
	private Integer zone_id;
	
	@Column(name="EXECUTIVE_DEAN")
	private String executive_dean;
	
	@Column(name="PUBLIC_IP")
	private String public_ip;
	
	@Column(name="EXECUTIVE_DEAN_MOBILE")
	private String executive_dean_mobile;
	
	@Column(name="CAMPUS_INCHARGE")
	private String campus_incharge;
	
	@Column(name="CAMPUS_INCHARGE_NO")
	private String campus_incharge_no;
	
	@Column(name="PRINCIPAL_MAIL_ID")
	private String principal_mail_id;
	
	@Column(name="STRENGTH_LIMIT")
	private int strength_limit;
	
	@Column(name="ADMIN_DEAN")
	private String admin_dean;
	
	@Column(name="AVAILABLE_CAMPUS")
	private int available_campus;
	
	@Column(name="STUDY_TYPE")
	private String study_type;
	
	@Column(name="PRESENT_STATUS")
	private String present_status;
	
	@Column(name="COLLEGE_TYPE")
	private String college_type;
	
}
