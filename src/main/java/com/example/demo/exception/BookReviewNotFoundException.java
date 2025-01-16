package com.example.demo.exception;

public class BookReviewNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public BookReviewNotFoundException(String message) {
		super(message);
	}
	
	

}
