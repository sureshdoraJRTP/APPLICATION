package com.tcs.ies.ar.domain;

import java.util.Date;

import lombok.Data;
@Data
public class Citizen {

	private String citizenId;
	private String firstName;
	private String lastName;
	private String email;
	
	private Date dob;
	private String gender;
	private String ssn;
	private Long phoneNumber;
	
	
	
}
