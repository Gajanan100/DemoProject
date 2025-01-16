package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.User;

@Service
public interface UserService {
	
	public User addUsers(User user);
	public List<User>getallUser();
	public User getUserById(int id);
	public void deleteByUser(int id);	
	public User addOrUpdateUser(User user);
	
	//custom Query
//     Integer findUsersByIsActiveUsers(boolean is_active);


}
