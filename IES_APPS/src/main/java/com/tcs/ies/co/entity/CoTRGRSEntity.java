package com.tcs.ies.co.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "CO_TRGRS_TBL")
public class CoTRGRSEntity {
	@Id
	@GeneratedValue
	@Column(name = "TRG_ID")
	private Integer id;
	@Column(name = "CASE_NUMBER")
	private String caseId;
	@Column(name = "CREATED_dATE")
	private Date createdDate;
	
	@Column(name = "TRG_STATUS")
	private String planStatus;
	
	@Column(name = "UPDATE_DATE")
	private String updateDate;
	

}
