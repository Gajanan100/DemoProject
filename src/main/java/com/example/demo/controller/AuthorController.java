package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Author;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.service.AuthorService;

@RestController
@RequestMapping("/api")
public class AuthorController {

	@Autowired
	private AuthorService authorService;

	@Autowired
	private AuthorRepository authorRepository;

	@PostMapping("/add-auther")
	public Author addAuthor(@RequestBody Author author) {
		Author saved = authorService.addAuthor(author);
		return saved;
	}

	@GetMapping("/get-author")
	public List<Author> getAllAuthor() {

		return authorService.getAllAuthor();
	}

	@GetMapping("/getauthors")
	public Optional<Author> getAuthorByID(@RequestBody Author author) {
		return authorService.getAuthorById(author.getAuthor_id());
	}

	@DeleteMapping("/del-author")
	public String deleteAuthors(@RequestBody Author author) {
		authorService.deleteAuthor(author.getAuthor_id());
		return "Author Deleted SuccessFully...";
	}

	@PutMapping("/add-update-author")
	public Author addupdateAuthors(@RequestBody Author author) {
		Author SavedAuthor = authorService.AddOrUpdateAuthor(author);
		return SavedAuthor;
	}

	// Custom Query
	@GetMapping("/all-authors")
	public List<String> getauthor() {
		return authorService.getallAuthor();

	}

}
