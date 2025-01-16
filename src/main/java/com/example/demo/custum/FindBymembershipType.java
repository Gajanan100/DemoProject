package com.example.demo.custum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class FindBymembershipType {
	
	public String membership_type;
	public int maxborrow_limit;
	public int mixborrow_limit;
	public  double fees;


}
