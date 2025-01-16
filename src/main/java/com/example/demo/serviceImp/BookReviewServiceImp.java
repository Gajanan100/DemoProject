package com.example.demo.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Book;
import com.example.demo.entity.BookReview;
import com.example.demo.exception.AutherNotFoundException;
import com.example.demo.exception.BookReviewNotFoundException;
import com.example.demo.repository.BookReviewRepository;
import com.example.demo.service.BookReviewService;
import com.example.demo.custum.HighestRatingBook;
import com.example.demo.custum.NoRatingBook;
import com.example.demo.custum.UserBookReviewData;

@Service
public class BookReviewServiceImp implements BookReviewService {

	@Autowired
	private BookReviewRepository bookReviewRepository;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public BookReview addBookReview(BookReview bookReview) {

		if (bookReview.getRating() > 5) {
			throw new BookReviewNotFoundException("You can not insert Rating Above 5");
		}

		if (bookReviewRepository.findById(bookReview.getReview_id()).isPresent()) {
			throw new BookReviewNotFoundException("BookReview Id already presents");
		}
		return bookReviewRepository.save(bookReview);
	}

	@Override
	public List<BookReview> getallBookReview() {
		List<BookReview> listbookReview = bookReviewRepository.findAll();
		if (listbookReview.isEmpty()) {
			throw new BookReviewNotFoundException("listbookReview is empty");
		}
		return listbookReview;
	}

	@Override
	public Optional<BookReview> getByIdBookReview(int id) {
		if (bookReviewRepository.findById(id).isEmpty()) {
			throw new BookReviewNotFoundException("bookReview Id is not presents");
		}
		return bookReviewRepository.findById(id);
	}

	@Override
	public void deleteByBookReview(int id) {
		if (bookReviewRepository.findById(id).isEmpty()) {
			throw new BookReviewNotFoundException("bookReview Id is not presents");
		}

		bookReviewRepository.deleteById(id);

	}

	@Override
	public BookReview addOrUpdateBookReview(BookReview bookReview) {

		if (bookReview.getRating() > 5) {
			throw new BookReviewNotFoundException("You can not insert Rating Above 5");
		}

		if (bookReview.getReview_id() == 0) {
			return bookReviewRepository.save(bookReview);
		} else {
			Optional<BookReview> optional = bookReviewRepository.findById(bookReview.getReview_id());
			if (optional.isPresent()) {
				return bookReviewRepository.save(bookReview);
			} else {
				throw new BookReviewNotFoundException(+bookReview.getBook_id() + " Id is Not Prsent? Please insert the Valid Id");

			}
		}
	}

	@Override
	public List<UserBookReviewData> getUserBookReviewData() {

		String query = "select users.user_name,booktables.book_name,bookreview.rating,\r\n"
				+ "     bookreview.review_date\r\n" + "    from bookreview join users on \r\n"
				+ "bookreview.user_id= users.user_id\r\n" + "    join booktables on \r\n"
				+ "bookreview.book_id=booktables.book_id;";

		return jdbcTemplate.query(query, (rs, mapper) -> new UserBookReviewData(rs.getString("user_name"),
				rs.getString("book_name"), rs.getInt("rating"), rs.getDate("review_date")));
	}

	@Override
	public List<HighestRatingBook> HighestBookRating() {

		String query = "SELECT r.rating, b.book_name, a.author_name, \r\n" + "b.publish_date, b.status\r\n"
				+ "FROM bookreview r \r\n" + "JOIN booktables b \r\n" + "ON r.book_id = b.book_id\r\n"
				+ "JOIN authortables a \r\n" + "ON b.author_id = a.author_id\r\n" + "WHERE r.rating = 5;\r\n" + "";
		return jdbcTemplate.query(query, (rs, mapper) -> new HighestRatingBook(rs.getString("book_name"),
				rs.getInt("rating"), rs.getString("book_name"), rs.getDate("publish_date"), rs.getBoolean("status")));
	}

	@Override
	public List<NoRatingBook> LowBookRating() {

		String query = "SELECT r.rating, b.book_name, a.author_name, \r\n" + "b.publish_date, b.status\r\n"
				+ "FROM bookreview r \r\n" + "JOIN booktables b \r\n" + "ON r.book_id = b.book_id\r\n"
				+ "JOIN authortables a \r\n" + "ON b.author_id = a.author_id\r\n" + "WHERE r.rating = 0;\r\n" + "\r\n"
				+ "";

		return jdbcTemplate.query(query, (rs, mapper) -> new NoRatingBook(rs.getString("book_name"),
				rs.getInt("rating"), rs.getString("book_name"), rs.getDate("publish_date"), rs.getBoolean("status")));
	}

}
