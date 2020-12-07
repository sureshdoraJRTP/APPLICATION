package com.tcs.ies.dc.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.ies.dc.domain.DCIncome;
import com.tcs.ies.dc.domain.DCPlan;
import com.tcs.ies.dc.entity.DCIncomeEntity;
import com.tcs.ies.dc.entity.DCPlanEntity;
import com.tcs.ies.dc.repository.DCIncomeRepo;

@Service
public class DCIncomeServiceImpl implements DCIncomeService{

	
	@Autowired
	private DCIncomeRepo dcIncomeRepo;

	@Override
	public DCIncome saveIncome(DCIncome dc) {
		DCIncomeEntity entity=new DCIncomeEntity(); 
		BeanUtils.copyProperties(dc,entity); 
		DCIncomeEntity save=dcIncomeRepo.save(entity);
		if (save!=null) { 
			DCIncome dc1=new DCIncome();
		    BeanUtils.copyProperties(save, dc1); 
		    return dc1; 
		 } 
		return null; 
	}
	
	

	 

}
