package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.BookCategory;

@Service
public interface BookCategoryService  {
	
	public BookCategory addbookcategory(BookCategory  bookCategory);
	public List<BookCategory> getAllbookcategory();
	public Optional<BookCategory>findByidBookcategory(int id);
	public void deleteByIDBookcategory(int id);
	public BookCategory addOrUpdateBookcategory(BookCategory bookCategory);

}
