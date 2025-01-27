package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.custum.FindBymembershipType;
import com.example.demo.entity.UserMembership;
import com.example.demo.service.UserMembershipService;

@RestController
@RequestMapping("/api")
public class UserMembershipController {
	
	@Autowired
	private UserMembershipService userMembershipService;
	

	@PostMapping("/add-usermembership")
	public UserMembership addUserMembership(@RequestBody UserMembership usermembership) {
		return userMembershipService.addUserMembership(usermembership);

	}

	@GetMapping("/get-all-usermembership")
	public List<UserMembership> getAllbookCopiesService() {
		return userMembershipService.getallUserMembership();
	}

	@PostMapping("/get-usermembership-id")
	public Optional<UserMembership> getByBookid(@RequestBody UserMembership usermembership) {
		return userMembershipService.findByIdUserMembership(usermembership.getM_id());
	}

	@PostMapping("/del-usermembership")
	public String deleteUserMembership(@RequestBody UserMembership usermembership) {
		userMembershipService.deleteByIdUserMembership(usermembership.getM_id());
		return "UserMembership Delete SuccessFully...";
	}

	@PostMapping("/add-or-update-usermembership")
	public UserMembership addOrUpdateUserMembership(@RequestBody UserMembership usermembership) {
		return  userMembershipService.addorUpdateUserMembership(usermembership);
	}
	
	@GetMapping("/find-membership-type")
	public List<FindBymembershipType> findMembershiptype(@RequestBody UserMembership membership){
		return userMembershipService.FindByMembershipType(membership.getMembership_type());
		
	}


}
