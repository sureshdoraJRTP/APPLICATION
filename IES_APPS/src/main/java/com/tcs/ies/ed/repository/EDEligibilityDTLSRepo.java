package com.tcs.ies.ed.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.ies.ed.domain.EDEligibilityDTLS;
import com.tcs.ies.ed.entity.EDEligibilityDTLSEntity;

public interface EDEligibilityDTLSRepo extends JpaRepository<EDEligibilityDTLSEntity, Serializable>{

}
