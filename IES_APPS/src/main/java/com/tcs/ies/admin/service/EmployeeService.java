package com.tcs.ies.admin.service;

import java.util.List;

import com.tcs.ies.admin.domain.Employee;

public interface EmployeeService {

	public Boolean saveEmployee(Employee employee);
	public String getRegSuccMailBody(Employee employee);
	public Boolean sentRegSuccMail(String to,String subject,String body);
	public List<Employee> getEmpByRole(String role);
	public Employee editEmpAcc(Integer empId);
	public Boolean isUniqueEmail(String email);
	public Boolean softDelete(Integer id);
}
