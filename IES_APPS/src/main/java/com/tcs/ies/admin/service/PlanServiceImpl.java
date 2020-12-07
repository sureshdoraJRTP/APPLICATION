package com.tcs.ies.admin.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.ies.admin.domain.Plan;
import com.tcs.ies.admin.entity.PlanEntity;
import com.tcs.ies.admin.repository.PlanRepo;

@Service
public class PlanServiceImpl implements PlanService {

	@Autowired
	private PlanRepo repo;
	
	
	@Override
	public Boolean savePlan(Plan plan) {
		PlanEntity entity=new PlanEntity();
		BeanUtils.copyProperties(plan, entity);
		
		return repo.save(entity)!=null?true : false;
	}

	@Override
	public List<Plan> viewPlan() {
		List<PlanEntity> entities = repo.findAll();
		List<Plan> listPlan=new ArrayList<Plan>();
		entities.forEach(entity->{
			Plan plan=new Plan();
			BeanUtils.copyProperties(entity, plan);
			listPlan.add(plan);
		});
		return listPlan;
	}

	@Override
	public List<String> getPlan() {
		 
		List<PlanEntity> entities = repo.findAll();
		List<String> listPlan=new ArrayList<String>();
		entities.forEach(entity->{
			Plan plan=new Plan();
			BeanUtils.copyProperties(entity, plan);
			String planName=plan.getPlanName();
			listPlan.add(planName);
		});
		return listPlan;
	}

}
