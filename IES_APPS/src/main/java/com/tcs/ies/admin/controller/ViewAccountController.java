package com.tcs.ies.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tcs.ies.admin.domain.Employee;
import com.tcs.ies.admin.service.EmployeeService;

@Controller
public class ViewAccountController {

	@Autowired
	private EmployeeService service;

	
	
	
	  @GetMapping(value = {"/viewAcc"}) public String viewAccount(Model model){
	  List<Employee> emp = service.getEmpByRole("admin");
	  model.addAttribute("getEmployee",emp);
	  return "viewAccount"; 
	  }
	 
	 
	@GetMapping(value = "/workerviewAcc")
	public String viewAccount(@RequestParam("role")String role,Model model){
		
			List<Employee> emp = service.getEmpByRole(role);
			model.addAttribute("getEmployee",emp);
		
		
		return "viewAccount";
	}
	@GetMapping(value = "/editEmpAcc")
	  public String editAccount(@RequestParam("empId") Integer empId,Model model){
	  Employee employee=service.editEmpAcc(empId);
		model.addAttribute("emp",employee);
	  return "registration"; 
	  }
	
	@GetMapping(value = "/softDelete")
	public String softDtl(@RequestParam("empId") Integer id,Model model) {
		Boolean softDelete = service.softDelete(id);
		if (softDelete) {
			model.addAttribute("status", "Employee is DEActivated "+id);
			
		}
		else {
			model.addAttribute("status","Employee is Activated "+id);
		}
		return "viewAccount";
	}
	
}
