package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.custum.FindEmployeByRole;
import com.example.demo.entity.EmpRole;
import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	 private EmployeeService employeeService;
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@PostMapping("/add-emp")
	public Employee addEmployee(@RequestBody Employee employee) {
	     Employee saved= 	employeeService.addEmployee(employee);
		return saved;
	}

	@GetMapping("/get-all-emp")
	public List<Employee> getAllEmploye() {
		List<Employee> list = employeeService.getallEmployee();
		return list;
	}

	@GetMapping("/get-emp-id")
	public Employee getEmployeeById(@RequestBody Employee employee) {
		return employeeService.getEMployeeById(employee.getEmp_id());
	}
	
//	@GetMapping("/get-emp-id")
//	public ResponseEntity<Employee> getEmployeeById(@RequestBody Employee employee) {
//		Employee emp= employeeService.getEMployeeById(employee.getEmp_id()).
//				orElseThrow(()->new EmployeeException("Id IS Not Present"+employee.getEmp_id()));
//		return ResponseEntity.ok(emp);
//	}


	@DeleteMapping("/del-emp")
	public String deleteEmployee(@RequestBody Employee employee) {
		employeeService.deleteEmployee(employee.getEmp_id());
		return "Employee Delete SuccessFully...";

	}
	@PutMapping("/add-update-employees")
	public Employee addupdateAuthors(@RequestBody Employee employee) {
		Employee SavedEmployee = employeeService.AddOrUpdateEmployee(employee);
		return SavedEmployee;
	}
	
	//custom Query
//	@GetMapping("/count-departments")
//	public Map<String, Integer> getalldepartments( ){
//		int count=employeeService.getByDepartments();
//		Map<String,Integer>map=new HashMap<String, Integer>();
//		map.put("Number of employee", count);
//		return map;	
//	}
//
	
   @GetMapping("/count-departments")
   public Map<String, Integer> countEmployeesByDepartment() {
	    List<Object[]> result = employeeRepository.countByDepartment();
	    Map<String, Integer> departmentCount = new HashMap<>();
	    for (Object[] row : result) {
	        String department = (String) row[0];  
	        Long count = (Long) row[1];           
	        departmentCount.put(department, count.intValue());  
	    }
	    return departmentCount;
 }
   
//	public Map<String, Integer> countEmployeesByDepartment() {
//		return employeeRepository.countByDepartment().stream()
//				.collect(Collectors.toMap(row -> (String) row[0], row -> ((Long) row[1]).intValue()));
//	} 
   
	
	@GetMapping("/get-employees")
	public List<Object>getemployeeByDepartments(@RequestBody Employee employee){
		return employeeService.getemployeeByLibrarys(employee.getEmp_name());
	}
	
	@GetMapping("/find-by-employee-role")
	public List<FindEmployeByRole>getEmployeeByRole(@RequestBody EmpRole empRole){
		return employeeService.FindByemployeerole(empRole.getRole());
		
	}

}
