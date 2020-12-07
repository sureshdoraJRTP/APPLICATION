package com.tcs.ies.dc.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.ies.dc.entity.DCPlanEntity;


public interface DCPlanRepo extends JpaRepository<DCPlanEntity, Serializable> {
	public DCPlanEntity findByCaseId(Integer id);

}
