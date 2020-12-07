package com.tcs.ies.dc.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.ies.dc.entity.DCChildEntity;


public interface DCChildRepo extends JpaRepository<DCChildEntity, Serializable> {

}
