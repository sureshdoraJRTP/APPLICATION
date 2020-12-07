package com.tcs.ies.ed.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "ED_ELIG_DTLS_TBL")
public class EDEligibilityDTLSEntity {
	@Id
	@GeneratedValue
	@Column(name = "ED_TRACE_ID")
	private Integer id;
	@Column(name = "CASE_NUMBER")
	private String caseId;
	@Column(name = "CREATED_dATE")
	private Date createdDate;
	@Column(name = "PLAN_NAME")
	private String planName;
	@Column(name = "PLAN_STATUS")
	private String planStatus;
	@Column(name = "PLAN_START_DATE")
	private String planStartDate;
	@Column(name = "PLAN_END_DATE")
	private String planEndDate;
	@Column(name = "BENEFIT_AMOUNT")
	private String benefitAmt;
	@Column(name = "DENIAL_REASON")
	private String denialReason;
}
