package com.tcs.ies.co.entity;

import java.sql.Blob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "CO_PDFS")
public class CoPDFEntity {
	
	@Id
	@GeneratedValue
	@Column(name="CO_PDF_ID")
	private Integer coPdfId; 
	@Column(name="PLAN_STATUS")
	private String planStatus;
	@Column(name="CASE_NUMBER")
	private String caseNum;
	@Column(name="PDF_DOCUMENT")
	private Blob pdfDoc;
	@Column(name="PLAN_NAME")
	private String planName;             
	
}
