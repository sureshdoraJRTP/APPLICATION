package com.tcs.ies.dc.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.ies.dc.entity.DCIncomeEntity;


public interface DCIncomeRepo extends JpaRepository<DCIncomeEntity, Serializable> {

	public DCIncomeEntity findByCaseId(Integer id);
}
