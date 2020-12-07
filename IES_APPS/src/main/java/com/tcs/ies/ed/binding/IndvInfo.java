package com.tcs.ies.ed.binding;

import java.util.Date;

import lombok.Data;

@Data
public class IndvInfo {
	private String indvFirstName;
	private String indvLastName;
	private Date indvDob;
	private String planName;
	private String isEmployed;
	private PlanInfo planInfo;
}
