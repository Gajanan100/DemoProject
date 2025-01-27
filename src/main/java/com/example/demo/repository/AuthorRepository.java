package com.example.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {
	
    @Query(value = "SELECT author_name FROM authortables;", nativeQuery = true)
	List<String>getallAuthorName();

}
