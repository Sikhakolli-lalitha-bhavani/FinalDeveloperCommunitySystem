package com.dcs.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcs.dao.UserDao;
import com.dcs.dto.UserDTO;
import com.dcs.entity.User;
import com.dcs.exception.UserAlreadyExists;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserDao userDao;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDTO registerUser(UserDTO user) {
		User entity1 = modelMapper.map(user, User.class);
		for( User u1 : userDao.findAll()) {
			if(u1.getUserName().equals(user.getUserName())) {
				throw new UserAlreadyExists("User is already exists");
			}
		}
		User savedUser = userDao.save(entity1);
	
		return modelMapper.map(savedUser, UserDTO.class);
	}

	@Override
	public UserDTO signIn(String userName, String password) {
		User userEntity = userDao.findByUserName(userName);
		if (userEntity != null && userEntity.getUserPassword().equals(password)) {
			return modelMapper.map(userEntity, UserDTO.class);
		} else {
			throw new  UserAlreadyExists("Invalid User or password");
		}

	}

	@Override
	public String signOut() {
		return "User signed out";
	}

}
