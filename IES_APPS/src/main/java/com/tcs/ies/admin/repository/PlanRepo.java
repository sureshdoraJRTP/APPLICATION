package com.tcs.ies.admin.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.ies.admin.entity.PlanEntity;

public interface PlanRepo extends JpaRepository<PlanEntity, Serializable>{
	
}
