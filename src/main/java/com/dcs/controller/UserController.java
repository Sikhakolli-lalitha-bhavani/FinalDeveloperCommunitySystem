package com.dcs.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dcs.dao.UserDao;
import com.dcs.dto.UserDTO;
import com.dcs.service.IUserService;
 
 
@RestController
@RequestMapping("/user")
public class UserController {
@Autowired
IUserService userService;

@Autowired 
UserDao userDao;
@PostMapping(path="register/",consumes=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO user){
	
	UserDTO newUser=userService. registerUser(user);
	return new ResponseEntity<UserDTO>(newUser,HttpStatus.OK);
}
@GetMapping(path="signin/{userName}")
public ResponseEntity<UserDTO> signIn(@PathVariable String userName, String password){
	UserDTO newUser=userService.signIn(userName,password);
	return new ResponseEntity<UserDTO>(newUser,HttpStatus.OK);
}
@GetMapping(path="signout")
public ResponseEntity<String> signOut(){
	String newUser=userService. signOut();
	return new ResponseEntity<String>(newUser,HttpStatus.OK);
}
}