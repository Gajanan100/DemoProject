package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.TransactionHistory;

@Repository
public interface TransHistoryRepository extends JpaRepository<TransactionHistory, Integer> {

}
