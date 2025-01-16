package com.example.demo.exception;

public class AutherNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AutherNotFoundException(String message) {
		super(message);
	}

}
