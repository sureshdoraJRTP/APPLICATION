package com.tcs.ies.dc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tcs.ies.dc.domain.DCIncome;
import com.tcs.ies.dc.service.DCIncomeService;

@Controller
public class DCIncomeController {
	@Autowired
	private DCIncomeService incomeService;
	
	@GetMapping("/dcincome")
	public String dcPlanSelect(@ModelAttribute("dc")DCIncome income,Model model) {
		return "dc_Income";
	}
	
	@PostMapping("/Saveincome")
	public String saveCase(@ModelAttribute("dc")DCIncome income,RedirectAttributes attributes) {
		DCIncome saveIncome = incomeService.saveIncome(income);
		
		if (saveIncome!=null) {
			attributes.addFlashAttribute("infoDts", saveIncome);
		}
		
		return "redirect:/elgbltyDetermination";
	}
}
