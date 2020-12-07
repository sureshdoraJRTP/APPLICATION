package com.tcs.ies.dc.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.ies.dc.domain.DCChild;
import com.tcs.ies.dc.domain.DCIncome;
import com.tcs.ies.dc.entity.DCChildEntity;
import com.tcs.ies.dc.repository.DCChildRepo;

@Service
public class DCChildServiceImpl implements DCChildService{

	
	@Autowired
	private DCChildRepo dcChildRepo;

	@Override
	public DCChild saveChild(DCChild dc) {
		DCChildEntity entity=new DCChildEntity(); 
		BeanUtils.copyProperties(dc,entity); 
		DCChildEntity save=dcChildRepo.save(entity);
		if (save!=null) { 
			DCChild dc1=new DCChild();
		    BeanUtils.copyProperties(save, dc1); 
		    return dc1; 
		 } 
		return null; 
	}


	
	

	 

}
