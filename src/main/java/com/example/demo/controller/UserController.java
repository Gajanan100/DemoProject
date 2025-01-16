package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Author;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private  UserRepository userRepository;
	
	@PostMapping("/add-user")
	public User addUser(@RequestBody User  user) {
		return userService.addUsers(user);
	
    }

	@GetMapping("/all-users")
	public List<User> getAllUsers() {
		return userService.getallUser();
	}

	@GetMapping("/get-userByid")
	public User getUserByIds(@RequestBody User user) {
		return userService.getUserById(user.getUserId());
	}

	@DeleteMapping("/del-userById")
	public String deleteUsers(@RequestBody User user) {
		userService.deleteByUser(user.getUserId());
		return "User Id Deleted SuccessFully...";
	}

	@PutMapping("/add-update-users")
	public String addOrUpdateUsers(@RequestBody User user) {

		User userSaved = userService.addOrUpdateUser(user);
		return user.getUserId() == 0 ? "User Updated Successfully: " + userSaved.getUserId()
				: "User Added Successfully: " + userSaved.getUserId();
	}

//	@GetMapping("/get-isActive-Users")
//	public Map<String, Integer> countActiveUsers(@RequestBody User user) {
//	    Integer count = userService.findUsersByIsActiveUsers(user.isActive);
//	    Map<String, Integer> response = new HashMap<>();
//	    response.put("isActive", count);
//	    return response;
//	}
	
	@GetMapping("/get-isActive-Users")
	public Map<String, Integer> countActiveUsers(	) {
		List<Object[]> result = userRepository.countByIsActive();
	    Map<String, Integer> activeUserCount = new HashMap<>();
	    for (Object[] row : result) {
	        boolean isActive = (boolean) row[0];  
	        Long count = (Long) row[1]; 
	        String status = isActive ? "Active" : "Inactive";
	        activeUserCount.put(status, count.intValue());  
	    }
		return activeUserCount;
	}
	
//	public Map<Boolean, Integer> countActiveUsers() {
//	    return userRepository.countByIsActive().stream()
//	        .collect(Collectors.toMap(
//	            row -> (Boolean) row[0],  
//	            row -> ((Long) row[1]).intValue() 
//	        ));
//	}

}
