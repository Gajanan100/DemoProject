package com.example.demo.custum;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;


@Data
@ToString
@AllArgsConstructor
public class NoRatingBook {

	
	public String book_name;
	public int rating;
	public String author_name;
	public Date publish_date;
	public boolean status;

}
