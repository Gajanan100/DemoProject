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
public class UserBookReviewData {

	public String userName;
	public String book_name;
	public int rating;
	public Date review_date;

}
