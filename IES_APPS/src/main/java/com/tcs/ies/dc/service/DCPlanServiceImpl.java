package com.tcs.ies.dc.service;



import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.tcs.ies.dc.domain.DCPlan;
import com.tcs.ies.dc.entity.DCPlanEntity;
import com.tcs.ies.dc.repository.DCPlanRepo;

@Service
public class DCPlanServiceImpl implements DCPlanService{

	
	@Autowired
	private DCPlanRepo dcPlanRepo;


	@Override
	public DCPlan saveCase(DCPlan dc) {
		DCPlanEntity entity=new DCPlanEntity(); 
		BeanUtils.copyProperties(dc,entity); 
		DCPlanEntity save=dcPlanRepo.save(entity);
		if (save!=null) { 
			DCPlan dc1=new DCPlan();
		    BeanUtils.copyProperties(save, dc1); 
		    return dc1; 
		 } 
		return null; 
	}
	
	

	 

}
