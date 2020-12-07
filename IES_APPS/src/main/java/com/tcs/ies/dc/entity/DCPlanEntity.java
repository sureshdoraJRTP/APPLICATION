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
@Table(name = "DC_PLANS")
public class DCPlanEntity {

	@Id
	@GeneratedValue
	@Column(name="ID")
	private Integer planId;
	@Column(name="CASE_ID")
	private Integer caseId;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "DC_PLANS")
	private String plns;
	
}
