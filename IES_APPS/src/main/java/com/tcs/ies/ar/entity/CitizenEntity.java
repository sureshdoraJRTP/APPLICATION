package com.tcs.ies.ar.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
@Data
@Entity
@Table(name = "CITIZEN_DETAILS")
public class CitizenEntity {

	@Id
	@Column(name = "CITIZEN_ID")
	@GenericGenerator(name = "arId-gen",strategy = "com.tcs.ies.generator.ARGenerater")
	@GeneratedValue(generator = "arId-gen")
	private String citizenId;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "DATE_OF_BIRTH")
	private Date dob;
	@Column(name = "GENDER")
	private String gender;
	@Column(name = "SSN")
	private String ssn;
	@Column(name = "PHONE_NUMBER")
	private Long phoneNumber;
	
}
