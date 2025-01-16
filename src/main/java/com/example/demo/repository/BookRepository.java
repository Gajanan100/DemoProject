package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.custum.BookCountList;
import com.example.demo.entity.Book;
import com.example.demo.entity.BookAuthorsData;
import com.example.demo.entity.Book_Author_Name;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

	@Query(value = ("select b.book_name,a.author_bio,a.author_name from booktables b\r\n"
			+ "join authortables a;"), nativeQuery = true)
	List<BookAuthorsData> getBookAuthors();

	@Query(value = "select book_name from booktables;", nativeQuery = true)
	List<String> AllBookList();

	@Query(value = "select concat(book_name,' - ',author_name) FROM booktables "
			+ "JOIN authortables ON booktables.author_id = authortables.author_id", nativeQuery = true)
	List<String> Book_Author_Name1();
	
	@Query(value = "select book_name,count(book_id) as book_count from booktables group by book_name", nativeQuery = true)
	List<Object[]> findBookCountByName();

}
