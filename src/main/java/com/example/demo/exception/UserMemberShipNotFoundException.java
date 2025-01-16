package com.example.demo.exception;

public class UserMemberShipNotFoundException extends RuntimeException  {

	public static final long serialVersionUID = 1L;
	
	public UserMemberShipNotFoundException(String message) {
		super(message);
	}
	


}
