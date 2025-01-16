package com.example.demo.exception;

public class BookNotExistException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public BookNotExistException(String message) {
		super(message);
	}


}
