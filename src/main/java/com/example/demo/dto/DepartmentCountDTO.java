package com.example.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
public class DepartmentCountDTO {
	private String depeartment;
    private int count;
	
    public DepartmentCountDTO(String string, int count) {
	}


}
