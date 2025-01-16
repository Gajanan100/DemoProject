package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.TransactionHistory;
import com.example.demo.entity.User;
import com.example.demo.service.TransHistoryService;
import com.example.demo.custum.FindByUserName;
import com.example.demo.custum.UserBookTransData;

@RestController
@RequestMapping("/api")
public class TransactionHistoryController {
	
	@Autowired
	private TransHistoryService  transHistoryService;
	
	
	
	@PostMapping("/add-transactionHistory")
	public TransactionHistory addbookTransactionHistory(@RequestBody TransactionHistory transactionHistory) {
		return transHistoryService.addTransHistoryService(transactionHistory);

	}

	@PostMapping("/get-all-transactionHistory")
	public List<TransactionHistory> getAllbookCopiesService() {
		return transHistoryService.getallTransHistoryService();
	}

	@PostMapping("/get-transactionHistory-id")
	public Optional<TransactionHistory> getByBookid(@RequestBody TransactionHistory transactionHistory) {
		return transHistoryService.getByIdTransactionHistory(transactionHistory.getTrans_id());
	}

	@PostMapping("/del-transactionHistory")
	public String deleteEmployee(@RequestBody TransactionHistory bookCategory) {
		transHistoryService.deleteByTransactionHistory(bookCategory.getTrans_id());
		return "BookCopies Delete SuccessFully...";
	}

	@PostMapping("/add-or-update-transactionHistory")
	public TransactionHistory addOrUpdateBook(@RequestBody TransactionHistory transactionHistory) {
		return transHistoryService.addOrUpdateTransactionHistory(transactionHistory);
	}
	
	@PostMapping("/get-UserBookTransData")
	public List<UserBookTransData>UserBookTransData(){
		return transHistoryService.getUserBookTransData();
	}
	
	@GetMapping("/find-by-username")
	public List<FindByUserName> getFindByUserName(@RequestBody User user){
		System.out.println("Hello....");
	    System.out.println("Received username: " + user.getUserName());

		return transHistoryService.getDataByUserName(user.getUserName());
		
	}


}
