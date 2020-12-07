package com.tcs.ies.dc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "DC_INCOME")
public class DCEducationEntity {

	
	@Id
	@GeneratedValue
	@Column(name = "INCOME_ID")
	private Integer incomeId;
	@Column(name = "CASE_ID")
	private Integer caseId;
	@Column(name = "NAME")
	private String name;
	@Column(name = "IS_EMPLOYEE")
	private String isEmployee;
	@Column(name = "INCOME")
	private Double income;
}
