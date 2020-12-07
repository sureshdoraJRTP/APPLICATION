package com.tcs.ies.admin.domain;

import java.util.Date;

import lombok.Data;
@Data
public class Plan {

	private Integer id;
	private String planName;
	private String description;
	private Date startDate;
	private Date endDate;
	
}
