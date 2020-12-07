package com.tcs.ies.dc.domain;


import java.util.Date;

import lombok.Data;

@Data

public class DCChild {

	private Integer childId;
	private Integer caseId;
	private String citizanName;
	private String childName;
	private String childGender;
	private Date cdob;
	private Long ssn;
}
