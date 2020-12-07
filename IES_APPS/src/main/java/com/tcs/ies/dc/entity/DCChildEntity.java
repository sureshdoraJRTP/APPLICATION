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
@Table(name = "DC_CHILD")
public class DCChildEntity {

;
	@Id
	@GeneratedValue
	@Column(name = "CHILD_ID")
	private Integer childId;
	@Column(name = "CASE_ID")
	private Integer caseId;
	@Column(name = "CITIZAN_NAME")
	private String citizanName;
	@Column(name = "CHILD_NAME")
	private String childName;
	@Column(name = "GENDER")
	private String childGender;
	@Column(name = "DOB")
	private Date cdob;
	@Column(name = "SSN")
	private Long ssn;
}
