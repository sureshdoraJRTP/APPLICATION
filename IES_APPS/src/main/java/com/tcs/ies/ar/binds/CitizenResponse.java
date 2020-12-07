package com.tcs.ies.ar.binds;

import java.util.Date;

import lombok.Data;
@Data
public class CitizenResponse {
	private String firstName;

	private String lastName;

	private String gender;

	private Date dob;

	private String stateName;
}
