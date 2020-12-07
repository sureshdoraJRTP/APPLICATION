package com.tcs.ies.co.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.ies.co.entity.CoPDFEntity;

public interface CoPDFRepo extends JpaRepository<CoPDFEntity, Serializable>{

}
