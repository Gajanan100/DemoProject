package com.example.demo.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Author;
import com.example.demo.exception.AutherNotFoundException;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.service.AuthorService;

@Service
public class AuthorServiceImp implements AuthorService {

	@Autowired
	private AuthorRepository authorRepository;


	@Override
	public Author addAuthor(Author author) {
		if (authorRepository.findById(author.getAuthor_id()).isPresent()) {
			throw new AutherNotFoundException("Autthor Id Already Present.Please Try Insert Different Author Id");
		}

		return authorRepository.save(author);
	}

	@Override
	public List<Author> getAllAuthor() {

		List<Author> authorList = authorRepository.findAll();
		if (authorList.isEmpty()) {
			throw new AutherNotFoundException("Author List is Empty..");
		}

		return authorList;
	}

	@Override
	public void deleteAuthor(int id) {

		if (authorRepository.findById(id).isEmpty()) {
			throw new AutherNotFoundException(+id + " Id is Not Prsent? Please to insert Valid Id");
		}
		authorRepository.deleteById(id);
	}

	@Override
	public Optional<Author> getAuthorById(int id) {

		if (authorRepository.findById(id).isEmpty()) {
			throw new AutherNotFoundException(+id + " Id is Not Prsent? Please Pass the Valid Id");
		}
		return authorRepository.findById(id);
	}

	@Override
	public List<String> getallAuthor() {
		return authorRepository.getallAuthorName();
	}

	@Override
	public Author AddOrUpdateAuthor(Author author) {

		if (author.getAuthor_id() == 0) {
			return authorRepository.save(author);
		} else {
			Optional<Author> optional = authorRepository.findById(author.getAuthor_id());

			if (optional.isPresent()) {
				return authorRepository.save(author);
			} else {
				throw new AutherNotFoundException("Autthor Id Not Presents.Please Try Insert Different Author Id");
			}
		}
	}

}
