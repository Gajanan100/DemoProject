package com.example.demo.exception;

public class BookCopiesNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public BookCopiesNotFoundException(String message) {
		super(message);
	}
	
	

}
