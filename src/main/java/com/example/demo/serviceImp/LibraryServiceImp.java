package com.example.demo.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Library;
import com.example.demo.exception.LibraryNotFoundException;
import com.example.demo.repository.LibraryRepository;
import com.example.demo.service.LibraryService;

@Service
public class LibraryServiceImp implements LibraryService {

	@Autowired
	private LibraryRepository libraryRepository;

	@Override
	public Library addLibrary(Library library) {
		if (libraryRepository.findById(library.getLibrary_id()).isPresent()) {
			throw new LibraryNotFoundException(+library.getLibrary_id() + " Id Already Prsent? Please Pass the Different Id");
		}
		return libraryRepository.save(library);
	}

	@Override
	public List<Library> getallLibrary() {

		List<Library> libraryList = libraryRepository.findAll();
		if (libraryList.isEmpty()) {
			throw new LibraryNotFoundException("Library Is Empty");
		}
		return libraryList;
	}

	@Override
	public void DeleteLibrary(int id) {
		if (libraryRepository.findById(id).isEmpty()) {
			throw new LibraryNotFoundException(+id + " Id is not Prsent? Please insert valid Id");
		}
		libraryRepository.deleteById(id);

	}

	@Override
	public Library getByidLibrary(int id) {
		Optional<Library> optional = libraryRepository.findById(id);
		if (optional.isEmpty()) {
			throw new LibraryNotFoundException(+id + " Id is not found");
		}
		return optional.get();
	}

	@Override
	public Library AddOrUpdateLibrary(Library library) {

		if (library.getLibrary_id() == 0) {
			return libraryRepository.save(library);
		} else {

			Optional<Library> optional = libraryRepository.findById(library.getLibrary_id());
			if (optional.isPresent()) {
				return libraryRepository.save(library);
			} else {
				throw new LibraryNotFoundException(+library.getLibrary_id() + " Id is Not Prsent? Please Pass the valid Id");

			}
		}

	}

}
