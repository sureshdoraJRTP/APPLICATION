package com.tcs.ies.ar.service;

import java.util.List;

import com.tcs.ies.ar.domain.Citizen;

public interface CitizenService {
  
	public Boolean checkCitizenState(String ssn);
	public String saveCitizen(Citizen citizen);
	public List<Citizen> getCitizen();
}
