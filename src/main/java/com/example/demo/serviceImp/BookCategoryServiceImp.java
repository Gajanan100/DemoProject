package com.example.demo.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.BookCategory;
import com.example.demo.exception.BookCategoryNotFoundException;
import com.example.demo.repository.BookcategoryRespository;
import com.example.demo.service.BookCategoryService;

@Service
public class BookCategoryServiceImp implements BookCategoryService {

	@Autowired
	private BookcategoryRespository bookcategoryRespository;

	@Override
	public BookCategory addbookcategory(BookCategory bookCategory) {
		if (bookcategoryRespository.findById(bookCategory.getBookcat_id()).isPresent()) {
			throw new BookCategoryNotFoundException("BookCategory Already Presents..");
		}
		
		return bookcategoryRespository.save(bookCategory);
	}

	@Override
	public List<BookCategory> getAllbookcategory() {
		List<BookCategory> ListbookCategories = bookcategoryRespository.findAll();
		if (ListbookCategories.isEmpty()) {
			throw new BookCategoryNotFoundException("BookCategory empty list");
		}
		return ListbookCategories;
	}

	@Override
	public Optional<BookCategory> findByidBookcategory(int id) {
		if (bookcategoryRespository.findById(id).isEmpty()) {
			throw new BookCategoryNotFoundException("BookCategory id is not found");
		}
		return bookcategoryRespository.findById(id);
	}

	@Override
	public void deleteByIDBookcategory(int id) {

		if (bookcategoryRespository.findById(id).isEmpty()) {
			throw new BookCategoryNotFoundException("This id Can not be Deleted");
		}

		bookcategoryRespository.deleteById(id);
	}

	@Override
	public BookCategory addOrUpdateBookcategory(BookCategory bookCategory) {
		if (bookCategory.getBookcat_id() == 0) {
			return bookcategoryRespository.save(bookCategory);
		} else {
			Optional<BookCategory> optional = bookcategoryRespository.findById(bookCategory.getBookcat_id());

			if (optional.isPresent()) {
				return bookcategoryRespository.save(bookCategory);
			} else {
				throw new BookCategoryNotFoundException("BookCopies is Not avaliable");

			}
		}
	}

}
