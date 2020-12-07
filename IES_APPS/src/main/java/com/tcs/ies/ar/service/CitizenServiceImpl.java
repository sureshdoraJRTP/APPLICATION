package com.tcs.ies.ar.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tcs.ies.ar.binds.CitizenResponse;
import com.tcs.ies.ar.domain.Citizen;
import com.tcs.ies.ar.entity.CitizenEntity;
import com.tcs.ies.ar.repository.CitizenRepository;
@Service
public class CitizenServiceImpl implements CitizenService{

	@Autowired
	private CitizenRepository repo;
	@Override
	public Boolean checkCitizenState(String ssn) {

		Boolean flag=false;
		String endPointUrl="http://localhost:2525/getUserDtls/"+ssn;
		RestTemplate rt=new RestTemplate();
		ResponseEntity<CitizenResponse> responseEntity = rt.getForEntity(endPointUrl, CitizenResponse.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if(statusCode==200) {
			CitizenResponse response = responseEntity.getBody();
			if(response.getStateName().equals("KENTUCKY")) {
				flag=true;
				System.out.println(response);
			}
		}
		if(statusCode==400) {
			flag=false;
		}
		return flag;
	}

	@Override
	public String saveCitizen(Citizen citizen) {
		String status=null;
		CitizenEntity entity=new CitizenEntity();
		Boolean citizenState = checkCitizenState(citizen.getSsn());
		if (citizenState) {
			BeanUtils.copyProperties(citizen, entity);
			CitizenEntity save = repo.save(entity);
			status=save.getCitizenId();
		
		}
		return status;
	}

	@Override
	public List<Citizen> getCitizen() {
		
		List<CitizenEntity> entity = repo.findAll();
		List<Citizen> list=new ArrayList<Citizen>();
		Citizen ct=new Citizen();
		entity.forEach(ctzEnt->{
			BeanUtils.copyProperties(ctzEnt, ct);
			list.add(ct);
		});
		
		return list;
	}

}
