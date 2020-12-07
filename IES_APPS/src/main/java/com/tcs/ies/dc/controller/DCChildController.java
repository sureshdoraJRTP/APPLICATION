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

import com.tcs.ies.dc.domain.DCChild;
import com.tcs.ies.dc.service.DCChildService;

@Controller
public class DCChildController {
	@Autowired
	private DCChildService childService;
	
	@GetMapping("/dcchild")
	public String dcPlanSelect(@ModelAttribute("dc")DCChild child,Model model) {
		model.addAttribute("child", new DCChild());
		return "dc_Child";
	}
	@InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
     dateFormat.setLenient(false);
     webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
     }
	@PostMapping("/Savechild")
	public String saveCase(@ModelAttribute("dc")DCChild child,Model model) {
		DCChild saveChild = childService.saveChild(child);
		if (saveChild!=null) {
			model.addAttribute("infoDts", saveChild);
		}
		
		return "EligibilityDetermination";
	}
}
