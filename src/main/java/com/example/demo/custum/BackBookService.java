package com.example.demo.custum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class BackBookService {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public int returnBackBook(int  Trans_id, boolean status) {
	    //    String queryTranhistory = "update tranhistory set status = 1 where trans_id = ? and status = 0";
	 //       String queryReturnbook = "update returnbook set status = 0 where trans_id = ? and status = 1";
	      //  jdbcTemplate.update(queryTranhistory, Trans_id);
	    //    jdbcTemplate.update(queryReturnbook, Trans_id);
		  String query="insert into returnbook(trans_id,back_date,status)values(?,CURRENT_DATE,?)";
		return jdbcTemplate.update(query,Trans_id,status);
	}

}
