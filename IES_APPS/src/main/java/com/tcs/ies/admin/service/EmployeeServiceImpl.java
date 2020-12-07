package com.tcs.ies.admin.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.ies.admin.domain.Employee;
import com.tcs.ies.admin.entity.EmployeeEntity;
import com.tcs.ies.admin.repository.EmployeeRepo;
import com.tcs.ies.util.SendMailUtils;
@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private SendMailUtils send;
	
	@Autowired
	private EmployeeRepo repo;
	@Override
	public Boolean saveEmployee(Employee employee) {
		employee.setStatus("ACTIVE");
		EmployeeEntity entity=new EmployeeEntity();
		BeanUtils.copyProperties(employee, entity);
		EmployeeEntity save= repo.save(entity);
		if (save!=null) {
			String to=employee.getEmail();
			String subject="IES APPLICATION | Please Login";
			String body=getRegSuccMailBody(employee);
			sentRegSuccMail(to, subject, body);
			return true;
		}
		return false ;
	}

	@Override
	public String getRegSuccMailBody(Employee employee) {
		
		String fileName ="UNLOCK-ACC-EMAIL-BODYTEMPLATE.txt";
		List<String> replacedLines = null;
		String mailBody = null;
		try {
		Path path = Paths.get(fileName, "");
		Stream<String> lines = Files.lines(path);
		
		replacedLines = lines.map(line -> line.replace("{FNAME}", employee.getFirstName())
				.replace("{LNAME}", employee.getLastName())
				.replace("{PWD}", employee.getPassword())
				.replace("{WORKER}", employee.getRole()))
				.collect(Collectors.toList());
		mailBody = String.join("", replacedLines);
		} catch (Exception e) {
		e.printStackTrace();
		}
		return mailBody;

	}

	@Override
	public Boolean sentRegSuccMail(String to, String subject, String body) {
		
		return send.sendMail(to, subject, body);
	}

	@Override
	public List<Employee> getEmpByRole(String role) {
		List<Employee> employeeList=new ArrayList<Employee>();
		List<EmployeeEntity> entity = repo.findByRole(role);
		for (EmployeeEntity empEntity : entity) {
			Employee employee=new Employee();
			BeanUtils.copyProperties(empEntity, employee);
			employeeList.add(employee);
		}
		
		

		return employeeList;
	}

	@Override
	public Employee editEmpAcc(Integer empId) {
		Employee employee=new Employee();
		Optional<EmployeeEntity> optional = repo.findById(empId);
		if(optional.isPresent()){
			EmployeeEntity entity = optional.get();
			BeanUtils.copyProperties(entity, employee);
		}
		return employee;
	}

	@Override
	public Boolean isUniqueEmail(String email) {

		EmployeeEntity email2 = repo.findByEmail(email);
		return email2 != null ? false : true;
	}

	@Override
	public Boolean softDelete(Integer id) {
		Boolean flag=false;
		Optional<EmployeeEntity> optional = repo.findById(id);
		if (optional.isPresent()) {
			EmployeeEntity entity = optional.get();
			if (entity.getStatus().equals("ACTIVE")) {
				entity.setStatus("DEACTIVE");
				EmployeeEntity save = repo.save(entity);
				flag=true;
			}
			else {
				entity.setStatus("ACTIVE");
				EmployeeEntity save = repo.save(entity);
				
			}
		}
		
		return flag;
	}

}
