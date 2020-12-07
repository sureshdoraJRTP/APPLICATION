package com.tcs.ies.admin.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tcs.ies.admin.domain.Plan;
import com.tcs.ies.admin.service.PlanService;

@Controller
public class PlanRegController {

	@Autowired
	private PlanService service;
	@GetMapping("/planReg")
	public String planRegPage(Model model) {
		model.addAttribute("plan", new Plan());
		return "plan";
	}
	@InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
     dateFormat.setLenient(false);
     webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
     }
	
	@PostMapping("/planSbmt")
	public String handleSbmtBtn(@ModelAttribute("plan")Plan plan,Model model) {
	
		Boolean isSave = service.savePlan(plan);
		if(isSave) {
			model.addAttribute("success", "Plan Submited Successful....");
		}else {
			model.addAttribute("errorMsg", "Something is Wrong....");
		}
		return "plan";
	}
}
