package com.tcs.ies.dc.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.ies.dc.entity.DCCaseEntity;

public interface DCCaseRepo extends JpaRepository<DCCaseEntity, Serializable> {

	
}
