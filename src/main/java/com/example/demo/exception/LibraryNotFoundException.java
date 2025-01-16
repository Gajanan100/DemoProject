package com.example.demo.exception;


public class LibraryNotFoundException extends RuntimeException {

	 public static final  long serialVersionUID = 1L;
	public LibraryNotFoundException(String message) {
		super(message);
	}

	
}
