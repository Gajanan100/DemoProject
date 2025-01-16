package com.example.demo.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.exception.AutherNotFoundException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User addUsers(User user) {
		if (userRepository.findById(user.getUserId()).isPresent()) {
			throw new UserNotFoundException("User Already Exit ! please Incert new User...");
		}
		return userRepository.save(user);
	}

	@Override
	public List<User> getallUser() {
		List<User> userList = userRepository.findAll();
		if (userList.isEmpty()) {
			throw new UserNotFoundException("User list is empty..");
		}
		return userList;
	}

	@Override
	public User getUserById(int id) {
		Optional<User> optional = userRepository.findById(id);
		if (optional.isEmpty()) {
			throw new UserNotFoundException(id + "User Is not Present ! please Incert Valid User...");
		}
		return optional.get();
	}

	@Override
	public void deleteByUser(int id) {
		if (userRepository.findById(id).isEmpty()) {
			throw new UserNotFoundException(id + " User Is not Present ! please Incert Valid User...");
		}
		userRepository.deleteById(id);
	}

	@Override
	public User addOrUpdateUser(User user) {

		if (userRepository.findById(user.getUserId()).isEmpty()) {
			throw new UserNotFoundException(user.getUserId() + " User Is not Present ! please Incert Valid User...");
		}
		return userRepository.save(user);
	}

//	@Override
//	public Integer findUsersByIsActiveUsers(boolean is_active) {
//		return userRepository.countByIsActive(is_active);
//	}

}
