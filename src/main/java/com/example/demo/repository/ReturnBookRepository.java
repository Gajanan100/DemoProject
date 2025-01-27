//package com.example.demo.repository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import com.example.demo.entity.ReturnBook;
//import com.example.demo.entity.ReturnBookId;
//
//@Repository
//public interface ReturnBookRepository extends JpaRepository<ReturnBook, ReturnBookId> {
//
//    @Query("SELECT r FROM ReturnBook r WHERE r.transactionHistory.trans_id = :transId")
//    ReturnBook findByTransactionId(@Param("transId") int transId);
//
//    @Query("DELETE FROM ReturnBook r WHERE r.transactionHistory.trans_id = :transId")
//    void deleteByTransactionId(@Param("transId") int transId);
//}
//
