package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.BookCopies;

@Service
public interface BookCopiesService {
	public BookCopies AddBookCopies(BookCopies bookCopies);
//     public  List<BookCopies>getallBookCopies(BookCopies bookCopies);
	public List<BookCopies> getallBookCopies();

	public void deleteBookCopies(int id);
	public Optional<BookCopies> getByBookCopiesId(int id);
	public BookCopies AddOrUpdateBookCopies(BookCopies bookCopies);


}
