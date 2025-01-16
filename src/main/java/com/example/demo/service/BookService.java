package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Book;
import com.example.demo.entity.BookAuthorsData;

@Service
public interface BookService {
	
	public Book AddBook(Book bk);
    List<Book>getallBook();
	public void deleteBook(int id);
	public Optional<Book> getByBookId(int id);
	public 	Book AddOrUpdateBook(Book book);

	
	//custom Query 
	List<BookAuthorsData> getBookAutherData();
	List<String>allbook();
	List<String> Book_Author_Name1();

	
	
	
}
