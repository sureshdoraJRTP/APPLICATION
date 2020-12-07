package com.tcs.ies.co.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data

public class CoTRGRS {
	
	private Integer id;
	private String caseId;
	private Date createdDate;
	private String planStatus;
	private String updateDate;
	

}
