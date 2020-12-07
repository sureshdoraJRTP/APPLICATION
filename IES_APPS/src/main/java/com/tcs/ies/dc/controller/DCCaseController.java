package com.tcs.ies.dc.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tcs.ies.admin.service.PlanService;
import com.tcs.ies.dc.domain.DCCase;
import com.tcs.ies.dc.service.DCCaseService;

@Controller
public class DCCaseController {

	@Autowired
	private DCCaseService service;
	
	
	
	@GetMapping("/dcForm")
	public String dcCaseForm() {

		return "dc-Case";
	}
	
	@GetMapping("/findId")
	public String findApplicationId(@RequestParam("search") String id,Model model) {
		DCCase searchAppId = service.searchAppId(id);
		if(searchAppId!=null) {
			model.addAttribute("Search", searchAppId);
		}
		else {
			model.addAttribute("errorMsg", "Please Provide Valid Application ID");

		}
		
		return "dc-Case";
		
	}
	@InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
     dateFormat.setLenient(false);
     webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
     }
	@PostMapping("/plans")
	public String saveCase(@ModelAttribute("dc")DCCase cases,RedirectAttributes attributes) {
		DCCase saveCase = service.saveCase(cases);
		

		if (saveCase!=null) {
			
			attributes.addFlashAttribute("CaseDtls", saveCase);
		}
		

		return "redirect:/dcplan";
	}
}
