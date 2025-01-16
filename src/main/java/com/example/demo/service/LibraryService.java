package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Library;

@Service
public interface LibraryService {
	
	public Library addLibrary(Library library);
	public List<Library>getallLibrary();
	public void DeleteLibrary(int id);
	public Library getByidLibrary(int id);
	public 	Library AddOrUpdateLibrary(Library library);

}
