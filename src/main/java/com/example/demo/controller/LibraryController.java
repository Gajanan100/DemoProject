package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Library;
import com.example.demo.service.LibraryService;

@RestController
@RequestMapping("/api")
public class LibraryController {

	@Autowired
	private LibraryService libraryService;

	@PostMapping("/add-lab")
	public Library addLibrary(@RequestBody Library library) {
		Library saved = libraryService.addLibrary(library);
		return saved;

	}

	@GetMapping("/getall-lab")
	public List<Library> getAllLibrary() {
		List<Library> list = libraryService.getallLibrary();
		return list;

	}

	@GetMapping("/getlab-id")
	public Library getLibrary(@RequestBody Library library) {
		return libraryService.getByidLibrary(library.getLibrary_id());
	}

	@DeleteMapping("/del-lab")
	public String DeleteLibrary(@RequestBody Library library) {
		libraryService.DeleteLibrary(library.getLibrary_id());
		return "DeleteLibrary SuccessFully";

	}

	@PutMapping("/add-update-library")
	public Library add_updateLibrary(@RequestBody Library library) {

		Library savedLabrary = libraryService.AddOrUpdateLibrary(library);
		return savedLabrary;
	}

}
