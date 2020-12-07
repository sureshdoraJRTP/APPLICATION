package com.tcs.ies.ed.service;

import com.tcs.ies.ed.binding.IndvInfo;
import com.tcs.ies.ed.binding.PlanInfo;

public interface EligibilityDeterminationService {

	public PlanInfo getElibilityDetermination(IndvInfo indvInfo);
	public Boolean saveEligibility(Integer caseId);
}
