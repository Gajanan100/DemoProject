package com.example.demo.entity;

public class Book_Author_Name {

	public String book_name;
	public String author_name;

	public Book_Author_Name(String book_name, String author_name) {
		super();
		this.book_name = book_name;
		this.author_name = author_name;
	}

	public Book_Author_Name() {

	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getAuthor_name() {
		return author_name;
	}

	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}

	@Override
	public String toString() {
		return "Book_Author_Name [book_name=" + book_name + ", author_name=" + author_name + "]";
	}

}
