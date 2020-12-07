package com.tcs.ies.admin.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
@Data
@Entity
@Table(name = "EMPLOYEE_ACCOUNT")
public class EmployeeEntity {

	@Id
	@GeneratedValue
	@Column(name = "EMPLOYEE_ID")
	private Integer empId;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "PASSWORD")
	private String password;
	
	 @Column(name = "DATE_OF_BIRTH")
	 @Temporal(TemporalType.DATE)
	 @DateTimeFormat(pattern = "yyyy-MM-dd")
	 private Date dob;
	 
	@Column(name = "GENDER")
	private String gender;
	@Column(name = "SSN")
	private String ssn;
	@Column(name = "PHONE_NUMBER")
	private Long phoneNumber;
	@Column(name = "ROLE")
	private String role;
	@Column(name = "ACCOUNT_STATUS")
	private String status;
	
	
}
