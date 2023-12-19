package com.dcs.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;
 
import com.dcs.entity.User;

@Repository

public interface UserDao extends JpaRepository<User, Integer>{

@Query("Select user from User user where user.userName=:userName")

	User findByUserName(String userName);

}