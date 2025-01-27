package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ListBookStatus;
import com.example.demo.entity.Book;
import com.example.demo.entity.BookAuthorsData;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.BookService;

@RestController
@RequestMapping("/api")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	 private BookRepository  bookRepository;

	@PostMapping("/add-book")
	public Book addBooks(@RequestBody Book book) {
		Book saved= bookService.AddBook(book);
		return saved;
	}

	@GetMapping("/getBooks-all")
	public List<Book> getallBook() {
		return bookService.getallBook();
	}

	@GetMapping("/get-book-id")
	public Optional<Book> getByBookid(@RequestBody Book book) {
		return bookService.getByBookId(book.getBook_id());
	}

	@DeleteMapping("/delete-book")
	public String DeleteEmployee(@RequestBody Book book) {
		bookService.deleteBook(book.getBook_id());
		return "Book Delete SucessFully....";

	}
	@PutMapping("/add-or-update-book")
	public Book addOrUpdateBook(@RequestBody Book book) {
		Book savedBook = bookService.AddOrUpdateBook(book);
		return savedBook;
	}

//	@GetMapping("/get-all")
//	public List<BookAuthorsData> getAllData(){
//		return bookService.getBookAutherData();
//	}
	@GetMapping("/get-all")
	public List<BookAuthorsData> getAllData() {
		return bookService.getBookAutherData();
	}

	@GetMapping("/get-all-book")
	public List<String> getallBooks() {
		return bookService.allbook();

	}

	@GetMapping("/all-book-author-name")
	public List<String> getBook_author() {
		return bookService.Book_Author_Name1();
	}
	
	
	@PostMapping("/count-by-name")
	public Map<String, Integer> countBooksByName() {
	    List<Object[]> result = bookRepository.findBookCountByName(); 
	    Map<String, Integer> countBook = new HashMap<>();
	    for (Object[] row : result) {
	        String book = (String) row[0];  
	        Long count = (Long) row[1]; 
	        countBook.put(book, count.intValue());
	    }
	    return countBook;
	}  
	@GetMapping("/list-of-book")
	public List<ListBookStatus>  getAllBook(@RequestBody Book book ) {
		return bookService.ListofBook(book.status);	
	}
}
