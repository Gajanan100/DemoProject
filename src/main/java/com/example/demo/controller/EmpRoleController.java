package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.custum.EmployeeRoleData;
import com.example.demo.entity.EmpRole;
import com.example.demo.service.EmpRoleService;

@RestController
@RequestMapping("/api")
public class EmpRoleController {

	@Autowired
	private EmpRoleService empRoleService;


	@PostMapping("/add-empRole")
	public EmpRole addbookTransactionHistory(@RequestBody EmpRole empRole) {
		EmpRole saved= empRoleService.addEmpRole(empRole);
		return saved;

	}

	@GetMapping("/get-all-empRole")
	public List<EmpRole> getAllbookCopiesService() {
		return empRoleService.getallEmpRole();
	}

	@PostMapping("/get-empRole-id")
	public Optional<EmpRole> getByBookid(@RequestBody EmpRole empRole) {
		return empRoleService.getByIdEmpRole(empRole.getRole_id());
	}

	@PostMapping("/del-empRole")
	public String deleteEmployee(@RequestBody EmpRole bookReview) {
		empRoleService.deleteByEmpRole(bookReview.getRole_id());
		return "empRole Delete SuccessFully...";
	}

	@PostMapping("/add-or-update-empRole")
	public EmpRole addOrUpdateBook(@RequestBody EmpRole bookReview) {
		EmpRole saved = empRoleService.addOrUpdateEmpRole(bookReview);
		return saved;
	}

	@PostMapping("/get-employee-role-data")
	public List<EmployeeRoleData> getEmployeeRoleData(){
		return empRoleService.EmployeeRoleData();
		
	}
}
