package com.example.demo.exception;

public class BranchNotFoundException extends RuntimeException {
	
	public static final long serialVersionUID=1l;

	public BranchNotFoundException(String message) {
		super(message);
	}
	
	

}
