package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Author;

@Service
public interface AuthorService {
	
	public Author addAuthor(Author an);
	List<Author> getAllAuthor();
	public void deleteAuthor(int id);
	public Optional<Author> getAuthorById(int id);
	public 	Author AddOrUpdateAuthor(Author author);

	
	//Custom Query
	List<String> getallAuthor();
	

}
