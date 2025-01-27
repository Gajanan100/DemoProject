package com.example.demo.custum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AvaliableBook {
	private String position;
	private String depeartment;
	private int library_id;
	private String book_name;
	private Boolean status;

}
