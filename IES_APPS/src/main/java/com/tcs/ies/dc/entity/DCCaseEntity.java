package com.tcs.ies.dc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "DC_CASES")
public class DCCaseEntity {

	@Id
	@GeneratedValue
	@Column(name="ID")
	private Integer caseId;
	@Column(name = "Application_ID")
	private String citizenId;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "DOB")
	private Date dob;
	@Column(name = "GENDER")
	private String gender;
	@Column(name = "SSN")
	private String ssn;
	@Column(name = "PHONE_NUMBER")
	private Long phoneNumber;
}
