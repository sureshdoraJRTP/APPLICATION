package com.tcs.ies.ed.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tcs.ies.co.entity.CoTRGRSEntity;
import com.tcs.ies.co.repository.CoTRGRSRepo;
import com.tcs.ies.dc.entity.DCCaseEntity;
import com.tcs.ies.dc.entity.DCIncomeEntity;
import com.tcs.ies.dc.entity.DCPlanEntity;
import com.tcs.ies.dc.repository.DCCaseRepo;
import com.tcs.ies.dc.repository.DCIncomeRepo;
import com.tcs.ies.dc.repository.DCPlanRepo;
import com.tcs.ies.ed.binding.IndvInfo;
import com.tcs.ies.ed.binding.PlanInfo;
import com.tcs.ies.ed.entity.EDEligibilityDTLSEntity;
import com.tcs.ies.ed.repository.EDEligibilityDTLSRepo;
@Service
public class EligibilityDeterminationServiceImpl implements EligibilityDeterminationService {

	@Autowired
	private DCCaseRepo dcCaseRepo;
	@Autowired
	private DCIncomeRepo dcIncomeRepo;
	@Autowired
	private DCPlanRepo dcPlanRepo;
	@Autowired
	private EDEligibilityDTLSRepo eDEligibilityDTLSRepo;
	@Autowired
	private CoTRGRSRepo coTRGRSRepo;
	
	  @Override public PlanInfo getElibilityDetermination(IndvInfo indvInfo) {
		  PlanInfo planInfo=null;
		/*
		 * String endPointUrl="http://localhost:5000/determineElig"; WebClient
		 * webClient= WebClient.create(); try { planInfo = webClient.post() .uri(new
		 * URI(endPointUrl)) .bodyValue(indvInfo) .retrieve()
		 * .bodyToMono(PlanInfo.class) .block(); } catch (Exception e) {
		 * e.printStackTrace(); }
		 */
			
			String endPointUrl="http://localhost:5000/determineElig";
			RestTemplate rt=new RestTemplate();
			 ResponseEntity<PlanInfo> responseEntity = rt.postForEntity(endPointUrl, indvInfo, PlanInfo.class);
					 
			int statusCode = responseEntity.getStatusCodeValue();
			if(statusCode==200) {
				planInfo = responseEntity.getBody();
				 return planInfo; 
			}
			return planInfo;
	 
	  }
	 
	

	
	  public IndvInfo getCitizenInfo(Integer caseId) {
	  
	  
	  
	  Optional<DCCaseEntity> findById1 = dcCaseRepo.findById(caseId);
	DCIncomeEntity findById2=dcIncomeRepo.findByCaseId(caseId);
	DCPlanEntity findById3=  dcPlanRepo.findByCaseId(caseId);
	  
	  
	  IndvInfo indvInfo=new IndvInfo();
	  indvInfo.setIndvFirstName(findById1.get().getFirstName());
	  indvInfo.setIndvLastName(findById1.get().getLastName());
	  indvInfo.setIndvDob(findById1.get().getDob());
	  indvInfo.setIsEmployed(findById2.getIsEmployee());
	  indvInfo.setPlanName(findById3.getPlns());
	  
	  return indvInfo;
	  
	  }
	  
	  @Override public Boolean saveEligibility(Integer caseId){ 
		  IndvInfo iddv=getCitizenInfo(caseId);
		  PlanInfo planInfo=getElibilityDetermination(iddv);
		  EDEligibilityDTLSEntity edElig=new EDEligibilityDTLSEntity();
		  BeanUtils.copyProperties(planInfo, edElig);
		  edElig.setCaseId(caseId.toString());
		  edElig.setCreatedDate(new Date());
		  EDEligibilityDTLSEntity ed = eDEligibilityDTLSRepo.save(edElig);
		  CoTRGRSEntity cotrgrs=new CoTRGRSEntity();
		  
		  cotrgrs.setCaseId(caseId.toString());
		  try {
			  Date startDate=new SimpleDateFormat("dd-mm-yyyy").parse(planInfo.getPlanStartDate());
			  cotrgrs.setCreatedDate(startDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		  
		  cotrgrs.setPlanStatus("P");
		  cotrgrs.setUpdateDate(planInfo.getPlanEndDate());
		  
		  CoTRGRSEntity co = coTRGRSRepo.save(cotrgrs);
	 
		  return ed!=null&&co!=null?true:false; 
	  }

	
	 
}
