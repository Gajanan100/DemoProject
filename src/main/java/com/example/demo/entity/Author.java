package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "authortables")
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int author_id;
	public String author_name;
	public String author_Bio;

//    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL )
//	private List<Book> listBook;

	public Author() {
		// TODO Auto-generated constructor stub
	}

	public Author(int author_id, String author_name, String author_Bio) {
		super();
		this.author_id = author_id;
		this.author_name = author_name;
		this.author_Bio = author_Bio;
//		this.listBook = listBook;
	}

	public int getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}

	public String getAuthor_name() {
		return author_name;
	}

	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}

	public String getAuthor_Bio() {
		return author_Bio;
	}

	public void setAuthor_Bio(String author_Bio) {
		this.author_Bio = author_Bio;
	}

	@Override
	public String toString() {
		return "Author [author_id=" + author_id + ", author_name=" + author_name + ", author_Bio=" + author_Bio + "]";
	}

}
