package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.custum.HighestDue;
import com.example.demo.entity.LateReturnBook;
import com.example.demo.serviceImp.LateBookServiceImp;

@RestController
public class LateBookController {
	@Autowired
	private LateBookServiceImp lateBookServiceImp;
	
    @PostMapping("/insert-late-book")
    public String insertLateBook(@RequestBody LateReturnBook lateReturnBook) {
        int result = lateBookServiceImp.insertBook(lateReturnBook.getTrans_id());
        if (result > 0) {
            return "Late book record inserted successfully!";
        } else {
            return "Failed to insert late book record.";
        }
    }
    
    @PutMapping("/update-late-book")
    public String updateLateBook(@RequestBody LateReturnBook lateReturnBook) {
        lateBookServiceImp.updateBook(lateReturnBook);
        return "Late book record updated successfully!";
    }
    @DeleteMapping("/delete-late-book")
    public String deleteLateBook(@RequestBody LateReturnBook lateReturnBook) {
        int result = lateBookServiceImp.deleteRecord(lateReturnBook);
        if (result > 0) {
            return "Late book record deleted successfully!";
        } else {
            return "Failed to delete late book record.";
        }
    }
    
    @GetMapping("/get-by-id-late-book")
    public LateReturnBook getLateBookById(@RequestBody LateReturnBook lateReturnBook) {
        return lateBookServiceImp.getByIDLateBook(lateReturnBook);
    }

    @GetMapping("/get-all-late-books")
    public List<LateReturnBook> getAllLateBooks() {
        return lateBookServiceImp.getAllLateBooks();
    }
    
    @GetMapping("/highest-due")
    public List<HighestDue> getHighestDue(){
		return lateBookServiceImp.getHighestDue();
    	
    }


}
