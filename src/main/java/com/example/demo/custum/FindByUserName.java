package com.example.demo.custum;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@ToString
@Setter
@AllArgsConstructor
public class FindByUserName {
	public String book_name;
	public String userName;
	public String password;
	public Date borrow_date;
	public Date return_date;




}
