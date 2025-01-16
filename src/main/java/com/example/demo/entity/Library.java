package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "library")
public class Library {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int library_id;
	public String L_name;
	public String d_partements;
	public Library() {
	}
	public Library(int library_id, String l_name, String d_partements) {
		super();
		this.library_id = library_id;
		L_name = l_name;
		this.d_partements = d_partements;
	}
	public int getLibrary_id() {
		return library_id;
	}
	public void setLibrary_id(int library_id) {
		this.library_id = library_id;
	}
	public String getL_name() {
		return L_name;
	}
	public void setL_name(String l_name) {
		L_name = l_name;
	}
	public String getD_partements() {
		return d_partements;
	}
	public void setD_partements(String d_partements) {
		this.d_partements = d_partements;
	}
	@Override
	public String toString() {
		return "Library [library_id=" + library_id + ", L_name=" + L_name + ", d_partements=" + d_partements + "]";
	}
	
}
