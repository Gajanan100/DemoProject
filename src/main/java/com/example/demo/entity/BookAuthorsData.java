package com.example.demo.entity;


public class BookAuthorsData {

	public String author_name;
	public String book_name;
	public String publish_date;
	
	public String getAuthor_name() {
		return author_name;
	}
	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getPublish_date() {
		return publish_date;
	}
	public void setPublish_date(String publish_date) {
		this.publish_date = publish_date;
	}
	public BookAuthorsData(String author_name, String book_name, String publish_date) {
		super();
		this.author_name = author_name;
		this.book_name = book_name;
		this.publish_date = publish_date;
	}
	
	
	public BookAuthorsData() {
		super();
	}
	@Override
	public String toString() {
		return "BookAuthorsData [author_name=" + author_name + ", book_name=" + book_name + ", publish_date="
				+ publish_date + "]";
	}
	
	
	
}
