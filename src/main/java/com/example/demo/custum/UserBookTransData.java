package com.example.demo.custum;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class UserBookTransData {
	public String userName;
	public String book_name;
	public Date borrow_date;
	public Date late_date;
	public double fineamount;




}
