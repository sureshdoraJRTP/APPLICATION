package com.tcs.ies.ar.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.ies.ar.entity.CitizenEntity;

public interface CitizenRepository extends JpaRepository<CitizenEntity, Serializable>{

}
