package com.tcs.ies.admin.domain;

import java.util.Date;

import lombok.Data;
@Data
public class Employee {

	private Integer empId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private Date dob;
	private String gender;
	private String ssn;
	private Long phoneNumber;
	private String role;
	private String status;
	
	
}
