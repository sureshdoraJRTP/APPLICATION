package com.tcs.ies.ed.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
public class EDEligibilityDTLS {
	
	private Integer id;
	private String caseId;
	private Date createdDate;
	private String planName;
	private String planStatus;
	private String planStartDate;
	private String planEndDate;
	private String benefitAmt;
	private String denialReason;
}
