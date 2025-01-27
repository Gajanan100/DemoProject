package com.example.demo.entity;

import com.example.demo.annotations.ToLowerCase;
import com.example.demo.annotations.ToUpperCase;
import com.example.demo.annotations.TrimDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Setter
@Getter
@ToString
@Table(name = "booktables")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int book_id;
	@ToUpperCase
	public String book_name;
	public String publish_date;
	@JsonDeserialize(using = TrimDeserializer.class)
	@ToLowerCase
	public String book_Bio;
	public boolean status;
	@JoinColumn(name = "authur_id")
	public int author_id;
	
 }
