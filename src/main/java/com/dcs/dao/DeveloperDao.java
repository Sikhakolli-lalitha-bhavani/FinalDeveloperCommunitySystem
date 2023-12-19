package com.dcs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dcs.entity.Developer;
@Repository

public interface DeveloperDao extends JpaRepository<Developer, Integer> {

	
		List<Developer> findByStatus(String status);


	List<Developer> findByReputation(Integer reputation);
	

}