package com.example.demo.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.custum.FindByUserName;
import com.example.demo.custum.UserBookTransData;
import com.example.demo.entity.TransactionHistory;
import com.example.demo.entity.UserMembership;
import com.example.demo.exception.AutherNotFoundException;
import com.example.demo.exception.TransHistoryNotFoundException;
import com.example.demo.repository.TransHistoryRepository;
import com.example.demo.service.TransHistoryService;

@Service
public class TransHistoryServiceImp implements TransHistoryService {

	@Autowired
	private TransHistoryRepository transHistoryRepository;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public TransactionHistory addTransHistoryService(TransactionHistory transactionHistory) {
		if (transHistoryRepository.findById(transactionHistory.getTrans_id()).isPresent()) {
			throw new TransHistoryNotFoundException("TransactionHistory Id already presents");
		}
		return transHistoryRepository.save(transactionHistory);
	}

	@Override
	public List<TransactionHistory> getallTransHistoryService() {

		List<TransactionHistory> listytransHistroy = transHistoryRepository.findAll();
		if (listytransHistroy.isEmpty()) {
			throw new TransHistoryNotFoundException("TransactionHistory is empty");
		}
		return listytransHistroy;
	}

	@Override
	public Optional<TransactionHistory> getByIdTransactionHistory(int id) {
		if (transHistoryRepository.findById(id).isEmpty()) {
			throw new TransHistoryNotFoundException("TransactionHistory Id is not presents");
		}
		return transHistoryRepository.findById(id);
	}

	@Override
	public void deleteByTransactionHistory(int id) {

		if (transHistoryRepository.findById(id).isEmpty()) {
			throw new TransHistoryNotFoundException("TransactionHistory Id is not presents");
		}

		transHistoryRepository.deleteById(id);

	}

	@Override
	public TransactionHistory addOrUpdateTransactionHistory(TransactionHistory transactionHistory) {
		if (transactionHistory.getTrans_id() == 0) {
			return transHistoryRepository.save(transactionHistory);
		} else {
			Optional<TransactionHistory> optional = transHistoryRepository.findById(transactionHistory.getTrans_id());

			if (optional.isPresent()) {
				return transHistoryRepository.save(transactionHistory);
			} else {
				throw new TransHistoryNotFoundException("transactionHistory id is Not avaliable");

			}
		}
	}

	@Override
	public List<UserBookTransData> getUserBookTransData() {

		String query = "SELECT " + "users.user_name, " + "booktables.book_name, " + "tranhistory.borrow_date, "
				+ "tranhistory.late_date, " + "tranhistory.fineamount " + "FROM tranhistory "
				+ "JOIN users ON tranhistory.user_id = users.user_id "
				+ "JOIN booktables ON tranhistory.book_id = booktables.book_id";

		return jdbcTemplate.query(query,
				(rs, mapper) -> new UserBookTransData(rs.getString("user_name"), rs.getString("book_name"),
						rs.getDate("borrow_date"), rs.getDate("late_date"), rs.getDouble("fineamount")));
	}

	@Override
	public List<FindByUserName> getDataByUserName(String user_name) {
		String query = "SELECT t.borrow_date, t.late_date, \r\n" + "t.return_date, t.fineamount, \r\n"
				+ "u.user_name, u.password, \r\n" + " b.book_name FROM \r\n" + "tranhistory t JOIN users u \r\n"
				+ "ON t.user_id = u.user_id \r\n" + "JOIN booktables b \r\n" + "ON t.book_id = b.book_id\r\n"
				+ "where u.user_name=?;\r\n" + "";

		return jdbcTemplate.query(query,
				(rs, mapper) -> new FindByUserName(rs.getString("book_name"), rs.getString("user_name"),
						rs.getString("password"), rs.getDate("borrow_date"), rs.getDate("late_date"),
						rs.getDate("return_date"), rs.getDouble("fineamount")),
				user_name);

	}

}
