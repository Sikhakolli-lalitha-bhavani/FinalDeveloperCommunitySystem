package com.dcs.service;


import org.springframework.stereotype.Service;

import com.dcs.dto.UserDTO;
@Service
public interface IUserService {
	UserDTO registerUser(UserDTO user);

	UserDTO signIn(String userName, String password);
	public String signOut();
}