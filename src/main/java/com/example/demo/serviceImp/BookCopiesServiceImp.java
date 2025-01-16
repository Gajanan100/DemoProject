package com.example.demo.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.BookCopies;
import com.example.demo.exception.AutherNotFoundException;
import com.example.demo.exception.BookCopiesNotFoundException;
import com.example.demo.repository.BookCopiesRepository;
import com.example.demo.service.BookCopiesService;

@Service
public class BookCopiesServiceImp implements BookCopiesService {

	@Autowired
	private BookCopiesRepository bookCopiesRepository;

	@Override
	public BookCopies AddBookCopies(BookCopies bookCopies) {
		if (bookCopiesRepository.findById(bookCopies.getCopy_id()).isPresent()) {
			throw new BookCopiesNotFoundException("bookCopies Already presents");
		}
		return bookCopiesRepository.save(bookCopies);
	}

	@Override
	public List<BookCopies> getallBookCopies() {
		List<BookCopies> bookCopiesList = bookCopiesRepository.findAll();
		if (bookCopiesList.isEmpty()) {
			throw new BookCopiesNotFoundException("bookCopies is not avaliable...");
		}
		return bookCopiesList;
	}

	@Override
	public void deleteBookCopies(int id) {
		if (bookCopiesRepository.findById(id).isEmpty()) {
			throw new BookCopiesNotFoundException("bookCopies is not avaliable");
		}
		bookCopiesRepository.deleteById(id);
	}

	@Override
	public Optional<BookCopies> getByBookCopiesId(int id) {

		if (bookCopiesRepository.findById(id).isEmpty()) {
			throw new BookCopiesNotFoundException("BookCopies is not Presents");
		}

		return bookCopiesRepository.findById(id);
	}

	@Override
	public BookCopies AddOrUpdateBookCopies(BookCopies bookCopies) {

		if (bookCopies.getCopy_id() == 0) {
			return bookCopiesRepository.save(bookCopies);
		} else {
			Optional<BookCopies> optional = bookCopiesRepository.findById(bookCopies.getCopy_id());

			if (optional.isPresent()) {
				return bookCopiesRepository.save(bookCopies);
			} else {
				throw new BookCopiesNotFoundException("BookCopies is Not avaliable");

			}
		}
	}
}
