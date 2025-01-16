package com.example.demo.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int emp_id;
	public String emp_name;
	public String contact;
	public String depeartment;
	public String address;
	public Date DOB;
	public String position;
//	@JoinColumn(name = "library_id")
	@JoinColumn(name = "library_id", nullable = false, foreignKey = @ForeignKey())
	public int library_id;
	@JoinColumn(name = "role_id",nullable = false)
	public int role_id;


	public Employee(int emp_id, String emp_name, String contact, String depeartment, String address,
			Date dOB, String position, int library_id) {
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.contact = contact;
		this.depeartment = depeartment;
		this.address = address;
		this.DOB = dOB;
		this.position = position;
		this.library_id = library_id;
	}

	public Employee() {
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getDepeartment() {
		return depeartment;
	}

	public void setDepeartment(String depeartment) {
		this.depeartment = depeartment;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getLid() {
		return library_id;
	}

	public void setLid(int lid) {
		this.library_id = library_id;
	}

	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", emp_name=" + emp_name + ", contact=" + contact
				+ ", depeartment=" + depeartment + ", address=" + address + ", DOB=" + DOB + ", position=" + position
				+ ", lid=" + library_id + "]";
	}

}
