package com.example.demo.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.custum.HighestDue;
import com.example.demo.custum.LateReturnBookDto;
import com.example.demo.entity.LateReturnBook;
import com.example.demo.exception.TransHistoryNotFoundException;
import com.example.demo.repository.TransHistoryRepository;

@Repository
public class LateBookServiceImp {

	@Autowired
	private TransHistoryRepository transHistoryRepository;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int insertBook(int trans_id) {
		Optional<LateReturnBookDto> dueData = transHistoryRepository.dueAmounts(trans_id);
		if (dueData.isEmpty()) {
			throw new TransHistoryNotFoundException("No transaction history found for the given ID: " + trans_id);
		}

		LateReturnBookDto bookDto = dueData.get();

		if (bookDto.getDue() <= 0) {
			throw new TransHistoryNotFoundException("You have Time Limit On return the book.");
		} else {
			if (bookDto.getDue() == 0) {
				throw new TransHistoryNotFoundException("Thank you for returning the book.");
			} else {
				String query = "INSERT INTO duedata (trans_id, due, late_date) VALUES (?, ?, CURRENT_DATE)";
				return jdbcTemplate.update(query, trans_id, bookDto.getDue());
			}
		}
	}

	public void updateBook(LateReturnBook lateReturnBook) {
		String query = "update latebook set due=?, late_date=CURRENT_DATE where trans_id=?";
		jdbcTemplate.update(query, lateReturnBook.getDue(), lateReturnBook.getTrans_id());
	}

	public int deleteRecord(LateReturnBook book) {
		String query = "delete from latebook where trans_id=? ";
		int id = jdbcTemplate.update(query, book.getTrans_id());
		return id;
	}

	@SuppressWarnings("deprecation")
	public LateReturnBook getByIDLateBook(LateReturnBook book) {
		String query = "select * from latebook where trans_id=?";
		return jdbcTemplate.queryForObject(query, new Object[] { book.getTrans_id() },
				new BeanPropertyRowMapper<>(LateReturnBook.class));
	}

	public List<LateReturnBook> getAllLateBooks() {
		String query = "select * from latebook";
		return jdbcTemplate.query(query, new BeanPropertyRowMapper<>());
	}

	public List<HighestDue> getHighestDue() {
		String query = " select t.borrow_date,d.late_date, d.due from tranhistory t\r\n"
				+ "    join duedata d on t.trans_id=d.tran_id\r\n" + "     order by d.due desc limit 1;";
		return jdbcTemplate.query(query, (rs, mapper) -> new HighestDue(rs.getDate("borrow_date"),
				rs.getDate("late_date"), rs.getDouble("due")));

	}

}
