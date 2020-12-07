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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tcs.ies.admin.domain.Employee;
import com.tcs.ies.admin.service.EmployeeService;

@Controller
public class RegistrationController {

	
	@Autowired
	private EmployeeService service;
	
	@GetMapping(value = "/regForm")
	public String loadRegistrationForm(Model model) {
		model.addAttribute("emp", new Employee());
		return "registration";
	}
	@GetMapping("/uniqueMail")
	public @ResponseBody String isUniqueEmail(@RequestParam("email") String email) {
		
		return service.isUniqueEmail(email) ? "UNIQUE" : "DUPLICATE";
			 
		
		
		}
	@InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
     dateFormat.setLenient(false);
     webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
     }
	@PostMapping(value = "/registration1")
	public String handleRegBtn(@ModelAttribute("emp") Employee employee,RedirectAttributes attr)  {
		
		 Boolean saveEmployee = service.saveEmployee(employee);
		if(saveEmployee==true) {
			if(employee.getEmpId()!=null) {
				attr.addFlashAttribute("success", "SuccessFull Updated.");
				
			}
			else {
				attr.addFlashAttribute("success", "SuccessFull Submited..");
	
			}

		}
		else {
			attr.addFlashAttribute("errorMsg", "Failed Something is wrong..");
			

		}
		return "redirect:regForm";
		
	}
}
