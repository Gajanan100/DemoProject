package com.example.demo.exception;

public class UserAllRedyPresent extends RuntimeException {

	public static final long serialVersionUID = 1l;

	public UserAllRedyPresent(String message) {
		super(message);
	}

}
