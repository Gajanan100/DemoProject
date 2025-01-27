package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.custum.HighestRatingBook;
import com.example.demo.custum.NoRatingBook;
import com.example.demo.custum.UserBookReviewData;
import com.example.demo.entity.BookReview;
import com.example.demo.service.BookReviewService;

@RestController
@RequestMapping("/api")
public class BookReviewController {

	@Autowired
	private BookReviewService bookReviewService;

	@PostMapping("/add-bookReview")
	public BookReview addbookTransactionHistory(@RequestBody BookReview bookReview) {
		return bookReviewService.addBookReview(bookReview);

	}

	@GetMapping("/get-all-bookReview")
	public List<BookReview> getAllbookCopiesService() {
		return bookReviewService.getallBookReview();
	}

	@PostMapping("/get-bookReview-id")
	public Optional<BookReview> getByBookid(@RequestBody BookReview bookReview) {
		return bookReviewService.getByIdBookReview(bookReview.getReview_id());
	}

	@PostMapping("/del-bookReview")
	public String deleteEmployee(@RequestBody BookReview bookReview) {
		bookReviewService.deleteByBookReview(bookReview.getReview_id());
		return "BookCopies Delete SuccessFully...";
	}

	@PostMapping("/add-or-update-bookReview")
	public BookReview addOrUpdateBook(@RequestBody BookReview bookReview) {
		return bookReviewService.addOrUpdateBookReview(bookReview);
	}
	
	@GetMapping("/get-userbookreviewData")
	public List<UserBookReviewData>getUserBookReviewData(){
		return bookReviewService.getUserBookReviewData();	
	}
	
	@GetMapping("/highest-book-rating")
	public List<HighestRatingBook>getBookRatingData(){
		return bookReviewService.HighestBookRating();
	}
	
	@GetMapping("/low-book-rating")
	public List<NoRatingBook>getLowBookRating(){
		return bookReviewService.LowBookRating();
	}


}
