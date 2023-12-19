package com.dcs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.dcs.entity.Response;

@Repository

public interface ResponseDao extends JpaRepository<Response, Integer> {

	

}