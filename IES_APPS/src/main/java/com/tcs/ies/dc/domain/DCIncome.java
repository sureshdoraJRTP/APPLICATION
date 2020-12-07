package com.tcs.ies.dc.domain;


import lombok.Data;

@Data

public class DCIncome {

	private Integer incomeId;
	private Integer caseId;
	private String name;
	private String isEmployee;
	private Double income;
}
