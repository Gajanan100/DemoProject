package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Authorbook")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorBook {
	
//	@Id
//	private int authorbook_id;
	@Id
	@Column(name = "book_id")
	private int book_id;
	@Column(name = "author_id")
	private int author_id;
	private String bookname;
	private String authorname;
	

}
