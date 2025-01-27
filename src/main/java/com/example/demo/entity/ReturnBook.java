//package com.example.demo.entity;
//
//import org.springframework.data.annotation.Immutable;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Table;
//import lombok.Data;
//
//@Entity
//@Table(name = "retBooks")
//@Immutable
//@Data
//public class ReturnBook {
//
//    // Foreign key to the TransactionHistory table
//    @ManyToOne
//    @JoinColumn(name = "trans_id", referencedColumnName = "trans_id")
//    private TransactionHistory transactionHistory;
//
//    @Column(name = "fine_amount")
//    private Double fineAmount;
//}
