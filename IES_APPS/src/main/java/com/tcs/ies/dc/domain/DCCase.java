package com.tcs.ies.dc.domain;

import java.util.Date;

import lombok.Data;
@Data
public class DCCase {
	private Integer caseId;
	private String citizenId;
	private String firstName;
	private String lastName;
	private String email;
	
	private Date dob;
	private String gender;
	private String ssn;
	private Long phoneNumber;
}
