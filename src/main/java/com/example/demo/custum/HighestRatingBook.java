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
public class HighestRatingBook {

	public String book_name;
	public int rating;
	public String author_name;
	public Date publish_date;
	public boolean status;
}
