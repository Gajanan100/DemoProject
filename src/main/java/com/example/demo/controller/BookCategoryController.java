package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Author;
import com.example.demo.entity.BookCategory;
import com.example.demo.service.BookCategoryService;

@RestController
@RequestMapping("/api")
public class BookCategoryController {
	@Autowired
	private BookCategoryService bookCategoryService;

	@PostMapping("/add-bookCategory")
	public BookCategory addbookCopies(@RequestBody BookCategory bookCategory) {
		BookCategory saved = bookCategoryService.addbookcategory(bookCategory);
		return saved;

	}

	@PostMapping("/get-all-bookCategory")
	public List<BookCategory> getAllbookCopiesService() {
		return bookCategoryService.getAllbookcategory();
	}

	@PostMapping("/get-bookCategory-id")
	public Optional<BookCategory> getByBookid(@RequestBody BookCategory bookCategory) {
		return bookCategoryService.findByidBookcategory(bookCategory.getBookcat_id());
	}

	@PostMapping("/del-bookCategory")
	public String deleteEmployee(@RequestBody BookCategory bookCategory) {
		bookCategoryService.deleteByIDBookcategory(bookCategory.getBookcat_id());
		return "BookCopies Delete SuccessFully...";
	}

	@PostMapping("/add-or-update-bookCategory")
	public BookCategory addOrUpdateBook(@RequestBody BookCategory bookCategory) {
		BookCategory saved = bookCategoryService.addOrUpdateBookcategory(bookCategory);
		return saved;	
	}

}
