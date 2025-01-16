package com.example.demo.serviceImp;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.custum.FindEmployeByRole;
import com.example.demo.dto.employeeData;
import com.example.demo.entity.Employee;
import com.example.demo.exception.AutherNotFoundException;
import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

@Service
public class EmployeeServiceImp implements EmployeeService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(Employee employee) {
		int id = employee.getEmp_id();
		if (employeeRepository.findById(id).isPresent()) {
			throw new EmployeeNotFoundException("Employee Id is Exit ! please Incert new Id...");
		}
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getallEmployee() {

		List<Employee> employee = employeeRepository.findAll();
		if (employee.isEmpty()) {
			throw new EmployeeNotFoundException("Employee List is Empty");
		}
		return employee;
	}

	@Override
	public void deleteEmployee(int id) {

		if (employeeRepository.findById(id).isEmpty()) {
			throw new EmployeeNotFoundException("Employee Id Doesn't exit. Please Enter valid Employee");
		}
		employeeRepository.deleteById(id);
	}

	@Override
	public Employee getEMployeeById(int id) {
//		Optional<Employee> optional = employeeRepository.findById(id);
		if (employeeRepository.findById(id).isEmpty()) {
			throw new EmployeeNotFoundException("Employee Id Does Not Exit ! please enter valid Id...");
		}
		return employeeRepository.findById(id).get();
	}

	@Override
	public Employee AddOrUpdateEmployee(Employee employee) {
		if (employee.getEmp_id() == 0) {
			return employeeRepository.save(employee);
		} else {
			Optional<Employee> optional = employeeRepository.findById(employee.getEmp_id());
			if (optional.isPresent()) {
				return employeeRepository.save(employee);
			} else {
				throw new EmployeeNotFoundException("Employee is Not Present.... ");

			}
		}

	}

//	@Override
//	public Integer getByDepartments() {
//		return employeeRepository.countByDepartment();
//	}

	@Override
	public List<Object> getemployeeByLibrarys(String empName) {
		String query = "SELECT l_name, emp_name,position, contact, depeartment FROM employee \r\n"
				+ "JOIN library ON employee.library_id = library.library_id \r\n" + "WHERE emp_name = ?;";

		return jdbcTemplate
				.query(query,
						(rs, rowNum) -> new employeeData(rs.getString("l_name"), rs.getString("emp_name"),
								rs.getString("position"), rs.getString("contact"), rs.getString("depeartment")),
						empName);
	}

	@Override
	public List<FindEmployeByRole> FindByemployeerole(String role) {
		String query=" select r.role,e.emp_name,e.address,\r\n"
				+ " e.depeartment,e.contact,r.permission\r\n"
				+ " from emprole r join employee e\r\n"
				+ " on e.role_id=r.role_id \r\n"
				+ " where r.role=?;";
		
		return jdbcTemplate.query(query,(rs,mapper)->
		  new  FindEmployeByRole(
				  rs.getString("role"),
				  rs.getString("emp_name"),
				  rs.getString("address"),
				  rs.getString("depeartment"),
				  rs.getString("contact"),
				  rs.getString("permission")
				  ),role );
	}

}
