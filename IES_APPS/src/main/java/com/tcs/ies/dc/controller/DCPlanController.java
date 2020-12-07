package com.tcs.ies.dc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tcs.ies.admin.service.PlanService;
import com.tcs.ies.dc.domain.DCPlan;
import com.tcs.ies.dc.service.DCPlanService;

@Controller
public class DCPlanController {
	@Autowired
	private PlanService planService;
	@Autowired
	private DCPlanService service;
	@GetMapping("/dcplan")
	public String dcPlanSelect(@ModelAttribute("dc")DCPlan plans,Model model) {
		model.addAttribute("listplans",planService.getPlan());
		return "dc_Plans";
	}
	
	@PostMapping("/Saveplans")
	public String saveCase(@ModelAttribute("dc")DCPlan plans,RedirectAttributes attributes) {
		DCPlan saveCase = service.saveCase(plans);
		if (saveCase!=null) {
			attributes.addFlashAttribute("planDtls", saveCase);
		}
		if (saveCase.getPlns().equals("SNAP")) {
			return "redirect:/dcincome";
		}
		else if (saveCase.getPlns().equals("CCAP")) {
			return "redirect:/dcchild";
		}
		return "redirect:/dceducation";
	}
}
