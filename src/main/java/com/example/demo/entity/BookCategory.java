package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name="bookcategory")
public class BookCategory {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
	public int bookcat_id;
	public String bookcat_name;
	public  String bookcat_des;
	
	
}
