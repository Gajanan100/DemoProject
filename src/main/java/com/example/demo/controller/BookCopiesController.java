package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Book;
import com.example.demo.entity.BookCopies;
import com.example.demo.service.BookCopiesService;

@RestController
@RequestMapping("/api")
public class BookCopiesController {

	@Autowired
	private BookCopiesService bookCopiesService;

	@PostMapping("/add-bookCopies")
	public BookCopies addbookCopies(@RequestBody BookCopies bookCopies) {
		return bookCopiesService.AddBookCopies(bookCopies);

	}

	@PostMapping("/get-bookCopies")
	public List<BookCopies> getAllbookCopiesService() {
		return bookCopiesService.getallBookCopies();
	}

	@PostMapping("/get-BookCopies-id")
	public Optional<BookCopies> getByBookid(@RequestBody BookCopies bookCopies) {
		return bookCopiesService.getByBookCopiesId(bookCopies.getCopy_id());
	}

	@PostMapping("/del-BookCopies")
	public String deleteEmployee(@RequestBody BookCopies bookCopies) {
		bookCopiesService.deleteBookCopies(bookCopies.getCopy_id());
		return "BookCopies Delete SuccessFully...";
	}

	@PostMapping("/add-or-update-BookCopies")
	public BookCopies addOrUpdateBook(@RequestBody BookCopies bookCopies) {
		return bookCopiesService.AddOrUpdateBookCopies(bookCopies);
	}

}
