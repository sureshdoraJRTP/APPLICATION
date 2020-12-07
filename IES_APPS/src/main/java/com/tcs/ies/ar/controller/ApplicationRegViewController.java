package com.tcs.ies.ar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tcs.ies.admin.domain.Employee;
import com.tcs.ies.admin.service.EmployeeService;
import com.tcs.ies.ar.domain.Citizen;
import com.tcs.ies.ar.service.CitizenService;

@Controller
public class ApplicationRegViewController {

	@Autowired
	private CitizenService service;

	
	
	
	@GetMapping(value = { "/ARviewAcc" })
	public String viewAccount(Model model) {
		List<Citizen> cit = service.getCitizen();
		model.addAttribute("getCitizen", cit);
		return "ARviewAccount";
	}
	 
	 
	
	/*
	 * @GetMapping(value = "/editEmpAcc") public String
	 * editAccount(@RequestParam("empId") Integer empId,Model model){ Employee
	 * employee=service.editEmpAcc(empId); model.addAttribute("emp",employee);
	 * return "registration"; }
	 */
}
