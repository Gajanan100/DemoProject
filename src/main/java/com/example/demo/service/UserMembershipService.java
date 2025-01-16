package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.custum.FindBymembershipType;
import com.example.demo.entity.UserMembership;

@Service
public interface UserMembershipService {
	
	public UserMembership addUserMembership(UserMembership userMembership);
	public List<UserMembership> getallUserMembership();
	public Optional<UserMembership>findByIdUserMembership(int id);
	public void deleteByIdUserMembership(int id);
	public  UserMembership addorUpdateUserMembership(UserMembership userMembership);	
	public List<FindBymembershipType> FindByMembershipType(String string);

}
