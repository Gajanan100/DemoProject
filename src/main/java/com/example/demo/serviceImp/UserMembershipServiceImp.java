package com.example.demo.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.custum.FindBymembershipType;
import com.example.demo.entity.BookCategory;
import com.example.demo.entity.UserMembership;
import com.example.demo.exception.AutherNotFoundException;
import com.example.demo.exception.UserMemberShipNotFoundException;
import com.example.demo.repository.UserMembershipRepository;
import com.example.demo.service.UserMembershipService;

@Service
public class UserMembershipServiceImp implements UserMembershipService {

	@Autowired
	private UserMembershipRepository userMembershipRepository;
	
	@Autowired
	private JdbcTemplate  jdbcTemplate;

	@Override
	public UserMembership addUserMembership(UserMembership userMembership) {
		if (userMembershipRepository.findById(userMembership.getM_id()).isPresent()) {
			throw new UserMemberShipNotFoundException("UserMemberShip All Ready Presents");
		}
		return userMembershipRepository.save(userMembership);
	}

	@Override
	public List<UserMembership> getallUserMembership() {
		List<UserMembership> userMembershipsList = userMembershipRepository.findAll();
		if (userMembershipsList.isEmpty()) {
			throw new UserMemberShipNotFoundException("Usermembership Is empty");
		}
		return userMembershipsList;
	}

	@Override
	public Optional<UserMembership> findByIdUserMembership(int id) {
		if (userMembershipRepository.findById(id).isEmpty()) {
			throw new UserMemberShipNotFoundException("usermerbership id  is not found ");
		}
		return userMembershipRepository.findById(id);
	}

	@Override
	public void deleteByIdUserMembership(int id) {

		if (userMembershipRepository.findById(id).isEmpty()) {
			throw new UserMemberShipNotFoundException("Usermembership Id is Not Presents");
		}
		userMembershipRepository.deleteById(id);

	}

	@Override
	public UserMembership addorUpdateUserMembership(UserMembership userMembership) {

		if (userMembership.getM_id() == 0) {
			return userMembershipRepository.save(userMembership);
		} else {
			Optional<UserMembership> optional = userMembershipRepository.findById(userMembership.getM_id());

			if (optional.isPresent()) {
				return userMembershipRepository.save(userMembership);
			} else {
				throw new UserMemberShipNotFoundException("BookCopies is Not avaliable");

			}
		}
	}

	@Override
	public List<FindBymembershipType> FindByMembershipType(String string) {
		   String query="select membership_type,maxborrow_limit,mixborrow_limit,\r\n"
		   		+ "fees from usermembership\r\n"
		   		+ "where membership_type=?;";
		return jdbcTemplate.query(query,(rs,mapper)->
		   new FindBymembershipType(
				   rs.getString("membership_type"),
				   rs.getInt("maxborrow_limit"),
				   rs.getInt("mixborrow_limit"),
				   rs.getDouble("fees")
				   ),string
		   );
	}
}
