package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.BookReview;

@Repository
public interface BookReviewRepository extends JpaRepository<BookReview, Integer> {

}
