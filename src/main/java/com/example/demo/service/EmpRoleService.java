package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.EmpRole;
import com.example.demo.custum.EmployeeRoleData;

@Service
public interface EmpRoleService {
	
	public EmpRole addEmpRole(EmpRole  empRole);
	public List<EmpRole>getallEmpRole();
	public Optional<EmpRole>getByIdEmpRole(int id);
	public void deleteByEmpRole(int id);
	public EmpRole addOrUpdateEmpRole(EmpRole empRole);
	public List<EmployeeRoleData> EmployeeRoleData();


}
