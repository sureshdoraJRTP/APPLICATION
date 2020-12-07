package com.tcs.ies.ar.controller;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tcs.ies.ar.domain.Citizen;

import com.tcs.ies.ar.service.CitizenService;

@Controller
public class ApplicationRegistrationController {

	@Autowired
	private CitizenService service;
	
	@GetMapping(value = "/appRegForm")
	public String loadAppRegistrationForm(Model model) {
		model.addAttribute("cum", new Citizen());
		return "applicationRegistration";
	}
	
	
	  @InitBinder public void initBinder(WebDataBinder webDataBinder) {
	  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	  dateFormat.setLenient(false); webDataBinder.registerCustomEditor(Date.class,
	  new CustomDateEditor(dateFormat, true)); }
	  
	  @PostMapping(value = "/register") 
	  public String handleRegBtn(@ModelAttribute("cum") Citizen citizen,RedirectAttributes attr) {
	  
	  String citizenId = service.saveCitizen(citizen); 
		if (citizenId != null) {
			
			
				attr.addFlashAttribute("success", "SuccessFull Submited..Your ID is :: "+citizenId);

			

		} else {
			attr.addFlashAttribute("errorMsg", "Failed Your are not Belong to KENTUCKY");

		}
		return "redirect:appRegForm";

	}}
