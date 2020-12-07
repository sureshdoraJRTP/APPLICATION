package com.tcs.ies.admin.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.ies.admin.entity.EmployeeEntity;

public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Serializable>{
	public EmployeeEntity findByEmail(String email);

	public List<EmployeeEntity> findByRole(String role);
}
