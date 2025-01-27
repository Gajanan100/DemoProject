package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.custum.AvaliableBook;
import com.example.demo.custum.FindEmployeByRole;
import com.example.demo.entity.Employee;

@Service
public interface EmployeeService {

	public Employee addEmployee(Employee employee);

	public List<Employee> getallEmployee();

	public void deleteEmployee(int id);

	public Employee getEMployeeById(int id);

	public Employee AddOrUpdateEmployee(Employee employee);

	// Native Query
//	public Integer getByDepartments();

	public List<Object> getemployeeByLibrarys(String string);
	public List<FindEmployeByRole> FindByemployeerole(String role);
	
	public List<AvaliableBook>findBylibrarian();
	
}
