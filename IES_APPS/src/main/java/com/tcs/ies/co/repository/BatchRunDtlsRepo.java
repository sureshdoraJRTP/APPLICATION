package com.tcs.ies.co.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.ies.co.entity.BatchRunDtlsEntity;

public interface BatchRunDtlsRepo extends JpaRepository<BatchRunDtlsEntity, Serializable> {

}
