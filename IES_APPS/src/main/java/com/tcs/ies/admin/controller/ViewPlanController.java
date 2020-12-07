package com.tcs.ies.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tcs.ies.admin.domain.Plan;
import com.tcs.ies.admin.service.PlanService;

@Controller
public class ViewPlanController {

	@Autowired
	private PlanService service;

	
	
	
	  @GetMapping(value = {"/viewPlan"}) 
	  public String viewPlan(Model model){
	 List<Plan> viewPlan = service.viewPlan();
	  model.addAttribute("getPlan",viewPlan);
	  return "viewPlan"; 
	  }
	  
}
