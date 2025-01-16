package com.example.demo.exception;


public class EmpRoleNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public EmpRoleNotFoundException(String message) {
		super(message);
	}

	
}
