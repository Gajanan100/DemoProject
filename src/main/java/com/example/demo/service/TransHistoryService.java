package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.custum.FindByUserName;
import com.example.demo.custum.UserBookTransData;
import com.example.demo.entity.TransactionHistory;


@Service 
public interface TransHistoryService {
	
	public TransactionHistory addTransHistoryService(TransactionHistory transactionHistory);
	public List<TransactionHistory>getallTransHistoryService();
	public Optional<TransactionHistory>getByIdTransactionHistory(int id);
	public void deleteByTransactionHistory(int id);
	public TransactionHistory addOrUpdateTransactionHistory(TransactionHistory transactionHistory);

	public List<UserBookTransData> getUserBookTransData();
	
	public List<FindByUserName>getDataByUserName(String user_name);

}
