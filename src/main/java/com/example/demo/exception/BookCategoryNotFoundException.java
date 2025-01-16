package com.example.demo.exception;


public class BookCategoryNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public BookCategoryNotFoundException(String message) {
		super(message);
	}
	
	

}
