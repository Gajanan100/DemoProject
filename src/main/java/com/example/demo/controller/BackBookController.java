package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.custum.BackBook;
import com.example.demo.custum.BackBookService;

@RestController
public class BackBookController {
	
	@Autowired
	private BackBookService backBookService;
	
    @PostMapping("/return-book")
    public String insertLateBook(@RequestBody BackBook backBook) {
        int result = backBookService.returnBackBook(backBook.getTrans_id(),backBook.isStatus());
        if (result > 0) {
            return "Book Return successfully!";
        } else {
            return "Book not Return";
        }
    }


}
