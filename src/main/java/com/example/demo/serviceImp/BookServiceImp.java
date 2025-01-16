package com.example.demo.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Book;
import com.example.demo.entity.BookAuthorsData;
import com.example.demo.exception.AutherNotFoundException;
import com.example.demo.exception.BookNotExistException;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.BookService;

@Service
public class BookServiceImp implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Book AddBook(Book book) {
		if (bookRepository.findById(book.getBook_id()).isPresent()) {
			throw new BookNotExistException(book.getBook_id() + " is already present please try insert different id");
		}
		return bookRepository.save(book);
	}

	@Override
	public List<Book> getallBook() {
		List<Book> booklist = bookRepository.findAll();
		if (booklist.isEmpty()) {
			throw new BookNotExistException("empty Boook list");
		}
		return booklist;
	}

	@Override
	public void deleteBook(int id) {
		if (bookRepository.findById(id).isEmpty()) {
			throw new BookNotExistException(id + " id is not present please try to insert valid id ");
		}
		bookRepository.deleteById(id);

	}

	@Override
	public Optional<Book> getByBookId(int id) {
		if (bookRepository.findById(id).isEmpty()) {
			throw new BookNotExistException(+id + " Id is Not Prsent? Please Pass the Valid Id");
		}
		return bookRepository.findById(id);
	}

	@Override
	public List<BookAuthorsData> getBookAutherData() {
		// TODO Auto-generated method stub
		String query = "select b.book_name,a.author_bio,a.author_name from booktables b\r\n" + "join authortables a;";
		return jdbcTemplate.query(query,
				(rs, mapper) -> new BookAuthorsData(rs.getString(1), rs.getString(2), rs.getString(3)));
	}

	@Override
	public List<String> allbook() {
		// TODO Auto-generated method stub
		return bookRepository.AllBookList();
	}

	@Override
	public Book AddOrUpdateBook(Book book) {

		if (book.getBook_id() == 0) {
			return bookRepository.save(book);
		} else {
			Optional<Book> optional = bookRepository.findById(book.getBook_id());
			if (optional.isPresent()) {
				return bookRepository.save(book);
			} else {
				throw new BookNotExistException(+book.getBook_id() + " Id is Not Prsent? Please insert the Valid Id");

			}
		}
	}

	@Override
	public List<String> Book_Author_Name1() {
		return bookRepository.Book_Author_Name1();
	}

}