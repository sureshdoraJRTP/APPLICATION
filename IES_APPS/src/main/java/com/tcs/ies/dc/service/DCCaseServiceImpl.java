package com.tcs.ies.dc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.ies.admin.repository.PlanRepo;
import com.tcs.ies.ar.entity.CitizenEntity;
import com.tcs.ies.ar.repository.CitizenRepository;
import com.tcs.ies.dc.domain.DCCase;
import com.tcs.ies.dc.entity.DCCaseEntity;
import com.tcs.ies.dc.repository.DCCaseRepo;

@Service
public class DCCaseServiceImpl implements DCCaseService{

	@Autowired
	private DCCaseRepo dCCaserepo;
	@Autowired
	private CitizenRepository citizenRepository;
	@Autowired
	private PlanRepo planRepo;
	@Override
	public DCCase searchAppId(String id) {
		Optional<CitizenEntity> optional = citizenRepository.findById(id);
		if (optional.isPresent()) {
			CitizenEntity citizenEntity = optional.get();
			DCCase dc=new DCCase();
			BeanUtils.copyProperties(citizenEntity, dc);
			return dc;
		}
		
		return null;
	}
	@Override
	public DCCase saveCase(DCCase dc) {
		DCCaseEntity entity=new DCCaseEntity();
		BeanUtils.copyProperties(dc,entity);
		DCCaseEntity save = dCCaserepo.save(entity);
		if (save!=null) {
			DCCase dc1=new DCCase();
			BeanUtils.copyProperties(save, dc1);
			return dc1;
		}
		return null;
	}


}
