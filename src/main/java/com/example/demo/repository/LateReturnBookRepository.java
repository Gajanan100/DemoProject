//package com.example.demo.repository;
//
//import com.example.demo.entity.LateReturnBook;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.Repository;
//
//import java.util.List;
//
//@org.springframework.stereotype.Repository
//public interface LateReturnBookRepository extends Repository<LateReturnBook, Integer> {
//
//    @Query(value = "SELECT * FROM latebook", nativeQuery = true)
//    List<LateReturnBook> findAllLateBooks();
//}
