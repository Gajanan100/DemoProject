package com.example.demo.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.custum.DueChargeDTO;
import com.example.demo.custum.FindByUserName;
import com.example.demo.custum.ListNoNReturnBook;
import com.example.demo.custum.UserBookTransData;
import com.example.demo.entity.TransactionHistory;
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

//		String queryString="select b.book_id, b.book_name, t.trans_id\r\n"
//				+ "from booktables b join tranhistory t\r\n"
//				+ "on b.book_id=t.book_id where b.status=1;\r\n"
//				+ "";
//		int bookAvalible=transHistoryRepository.countAvailableBooks(transactionHistory.getBook_id());

		int bookavaliability = transHistoryRepository.countBookCopies(transactionHistory.getBook_id());

		if (transHistoryRepository.findById(transactionHistory.getTrans_id()).isPresent()) {
			throw new TransHistoryNotFoundException("TransactionHistory Id already presents");
		}
//		if(transactionHistory.getLate_date().compareTo(transactionHistory.getReturn_date())<=0) {
//			throw new TransHistoryNotFoundException("TransactionHistory Date ALways Be Return_date ");
//
//		}
		if (bookavaliability <= 0) {
			throw new TransHistoryNotFoundException("Book Copies is not avalible");
		} else {
			return transHistoryRepository.save(transactionHistory);

		}

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
				+ "FROM tranhistory " + "JOIN users ON tranhistory.user_id = users.user_id "
				+ "JOIN booktables ON tranhistory.book_id = booktables.book_id";

		return jdbcTemplate.query(query, (rs, mapper) -> new UserBookTransData(rs.getString("user_name"),
				rs.getString("book_name"), rs.getDate("borrow_date")));
	}

	@Override
	public List<FindByUserName> getDataByUserName(String user_name) {
		String query = "SELECT t.borrow_date, t.return_date, \r\n" + "u.user_name, u.password, \r\n"
				+ " b.book_name FROM \r\n" + "tranhistory t JOIN users u \r\n" + "ON t.user_id = u.user_id \r\n"
				+ "JOIN booktables b \r\n" + "ON t.book_id = b.book_id\r\n" + "where u.user_name=?;\r\n" + "";

		return jdbcTemplate
				.query(query,
						(rs, mapper) -> new FindByUserName(rs.getString("book_name"), rs.getString("user_name"),
								rs.getString("password"), rs.getDate("borrow_date"), rs.getDate("return_date")),
						user_name);
	}

	@Override
	public List<DueChargeDTO> getDueChargeByID(int trans_id) {

		String query = "SELECT  borrow_date, return_date,\r\n" + "DATEDIFF(return_date,late_date) AS extra_days,\r\n"
				+ "CASE WHEN DATEDIFF(return_date,late_date) > 0 THEN DATEDIFF(return_date,late_date) * 50 \r\n"
				+ "ELSE 0 END AS due_charge FROM tranhistory where trans_id=? ;";
		if (transHistoryRepository.findById(trans_id).isEmpty()) {
			throw new TransHistoryNotFoundException("Id is Not avaliable");
		}

		return jdbcTemplate.query(query, (rs, mapper) -> new DueChargeDTO(rs.getDate("borrow_date"),
				rs.getDate("return_date"), rs.getInt("extra_days"), rs.getInt("due_charge")), trans_id);
	}

	@Override
	public List<ListNoNReturnBook> BookisReturnOrnot(boolean status) {
		
		String query="select trans_id, status from tranhistory where status= ?";	
		return jdbcTemplate.query(query,(rs,mapper)->new ListNoNReturnBook(
				rs.getInt("trans_id"),
				rs.getBoolean("status")),status);
	}

}

//List<Object[]> result = transHistoryRepository.findDueChargeById(trans_id);
//
//if (transHistoryRepository.findById(trans_id).isEmpty()) {
//	throw new TransHistoryNotFoundException("TransactionHistory Id is not presents");
//}
//Object[] row = result.get(0); 
//DueChargeDTO dto = new DueChargeDTO();
//dto.setBorrow_date((Date) row[0]);
//dto.setReturn_date((Date) row[1]);
//dto.setLate_date((Date) row[2]);
//dto.setExtraDays(((Number) row[3]).intValue());
//dto.setDueCharge(((Number) row[4]).intValue());
//
//return dto;
