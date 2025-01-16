package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "usermembership")
public class UserMembership {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int m_id;
	public String membership_type;
	public int maxborrow_limit;
	public int mixborrow_limit;
	public  double fees;
	
}
