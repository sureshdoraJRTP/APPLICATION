package com.tcs.ies.ed.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tcs.ies.ed.domain.EligibilityDetermination;
import com.tcs.ies.ed.service.EligibilityDeterminationService;

@Controller
public class EligibilityDeterminationController {

	@Autowired
	private EligibilityDeterminationService Service;
	@GetMapping("/elgbltyDetermination")
	public String edform(/* @ModelAttribute("dc")EligibilityDetermination ed,Model model */) {
		
		return "eligibilityDetermination";
	}
	@GetMapping("/ed")
	public String saveCase(@RequestParam("caseId") Integer id,RedirectAttributes attributes) {
	Boolean saveEligibility = Service.saveEligibility(id);
		if (saveEligibility) {
			attributes.addFlashAttribute("SuccessMsg", "SUCCESSFUL SUBMITTED.....");
		}
		else {
			attributes.addFlashAttribute("ErrorMsg", "SOMETHING IS WRONG.....");
		}
		return "redirect:/elgbltyDetermination";
	}
}
