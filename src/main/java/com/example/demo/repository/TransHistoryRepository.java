package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.custum.LateReturnBookDto;
import com.example.demo.entity.TransactionHistory;

@Repository
public interface TransHistoryRepository extends JpaRepository<TransactionHistory, Integer> {

	@Query(value = "select  borrow_date, return_date, late_date,\r\n"
			+ "DATEDIFF(return_date,late_date) AS extra_days,\r\n"
			+ "CASE WHEN DATEDIFF(return_date,late_date) > 0 THEN DATEDIFF(return_date,late_date) * 50 \r\n"
			+ "ELSE 0 END AS due_charge FROM tranhistory ;",nativeQuery = true)
	List<Object[]> findDueChargeById( int trans_id);
	
	@Query(value = "select count(*) from booktables where book_id = :book_id and status = 1",nativeQuery = true)
	int countAvailableBooks(@Param("book_id") int book_id);
	
	@Query(value = "select((select count(book_id)\r\n"
			+ " from book_copies WHERE book_id = :book_id) -\r\n"
			+ "(select count(book_id)\r\n"
			+ "from tranhistory where book_id = :book_id)) as diff;\r\n"
			+ "",nativeQuery =  true)
	int countBookCopies(@Param("book_id") int book_id);
	
	@Query(value = "SELECT \r\n"
			+ "  t.borrow_date, t.return_date,\r\n"
			+ "  DATEDIFF(CURRENT_DATE, t.return_date) AS extra_days,\r\n"
			+ "  CASE \r\n"
			+ "    WHEN DATEDIFF(CURRENT_DATE, t.return_date) > 0 THEN DATEDIFF(CURRENT_DATE, t.return_date) * 50\r\n"
			+ "    ELSE 0 \r\n"
			+ "  END AS due\r\n"
			+ "FROM tranhistory t\r\n"
			+ "WHERE t.trans_id = :trans_id;\r\n"
			+ "",nativeQuery = true)
	Optional<LateReturnBookDto> dueAmounts(@Param("trans_id") int trans_id);


//	@Query(value = "select trans_id, status from tranhistory where status= :status;\r\n"
//			+ "",nativeQuery = true)
//	List<ListNoNReturnBook> BookisReturnOrnot(@Param("status") boolean status);
	

}
