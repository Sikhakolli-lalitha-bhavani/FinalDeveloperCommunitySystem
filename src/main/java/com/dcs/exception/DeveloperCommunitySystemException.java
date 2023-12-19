package com.dcs.exception;

import org.springframework.http.HttpStatus;

public class DeveloperCommunitySystemException extends Exception{


	public DeveloperCommunitySystemException(String str) {
		super(str);
	}

	public DeveloperCommunitySystemException(HttpStatus internalServerError) {
		// TODO Auto-generated constructor stub
		super();
	}
  
	
}
