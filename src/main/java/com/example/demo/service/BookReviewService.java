package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.custum.HighestRatingBook;
import com.example.demo.custum.NoRatingBook;
import com.example.demo.custum.UserBookReviewData;
import com.example.demo.entity.BookReview;

@Service
public interface BookReviewService {
	
	public BookReview addBookReview(BookReview bookReview);
	public List<BookReview>getallBookReview();
	public Optional<BookReview>getByIdBookReview(int id);
	public void deleteByBookReview(int id);
	public BookReview addOrUpdateBookReview(BookReview bookReview);
	public List<UserBookReviewData>getUserBookReviewData();
	
	public List<HighestRatingBook>HighestBookRating();
	public List<NoRatingBook>LowBookRating();


}
