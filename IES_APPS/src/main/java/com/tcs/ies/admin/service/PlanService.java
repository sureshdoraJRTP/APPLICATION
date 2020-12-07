package com.tcs.ies.admin.service;

import java.util.List;

import com.tcs.ies.admin.domain.Plan;

public interface PlanService {

	public Boolean savePlan(Plan plan);
	public List<Plan> viewPlan();
	public List<String> getPlan();
}
