package com.example.demo.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;

import com.example.demo.entity.BookReview;
import com.example.demo.entity.EmpRole;
import com.example.demo.exception.AutherNotFoundException;
import com.example.demo.exception.EmpRoleNotFoundException;
import com.example.demo.repository.BookReviewRepository;
import com.example.demo.repository.EmpRoleRepository;
import com.example.demo.service.EmpRoleService;
import com.example.demo.custum.EmployeeRoleData;

@Service
public class EmpRoleServiceImp implements EmpRoleService {

	@Autowired
	private EmpRoleRepository empRoleRepository;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public EmpRole addEmpRole(EmpRole empRole) {
		if (empRoleRepository.findById(empRole.getRole_id()).isPresent()) {
			throw new EmpRoleNotFoundException("empRole Id already presents");
		}
		return empRoleRepository.save(empRole);
	}

	@Override
	public List<EmpRole> getallEmpRole() {
		List<EmpRole> listempRole = empRoleRepository.findAll();
		if (listempRole.isEmpty()) {
			throw new EmpRoleNotFoundException("empRole is empty");
		}
		return listempRole;
	}

	@Override
	public Optional<EmpRole> getByIdEmpRole(int id) {
		if (empRoleRepository.findById(id).isEmpty()) {
			throw new EmpRoleNotFoundException("empRole Id is not presents");
		}
		return empRoleRepository.findById(id);
	}

	@Override
	public void deleteByEmpRole(int id) {
		if (empRoleRepository.findById(id).isEmpty()) {
			throw new EmpRoleNotFoundException("empRole Id is not presents");
		}

		empRoleRepository.deleteById(id);

	}

	@Override
	public EmpRole addOrUpdateEmpRole(EmpRole empRole) {

		if (empRole.getRole_id() == 0) {
			return empRoleRepository.save(empRole);
		} else {
			Optional<EmpRole> optional = empRoleRepository.findById(empRole.getRole_id());

			if (optional.isPresent()) {
				return empRoleRepository.save(empRole);
			} else {
				throw new EmpRoleNotFoundException("empRole Id is not presents");

			}
		}

	}

	@Override
	public List<EmployeeRoleData> EmployeeRoleData() {
		String query = "select employee.emp_name, emprole.role,\r\n" + "    emprole.permission from emprole\r\n"
				+ "  join employee on employee.role_id=emprole.role_id;\r\n" + "";

		return jdbcTemplate.query(query, (rs, mapper) -> new EmployeeRoleData(rs.getString("emp_name"),
				rs.getString("role"), rs.getString("permission")));
	}

}
