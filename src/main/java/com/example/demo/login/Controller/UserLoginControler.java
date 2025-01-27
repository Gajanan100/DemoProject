package com.example.demo.login.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.user.service.UserLoginService;
import com.example.demo.userlogin.TokenRequest;
import com.example.demo.userlogin.Users;


@RestController
public class UserLoginControler {
	
	@Autowired
	private UserLoginService loginService;
	
	@GetMapping("/")
	public String registerUser() {
		return "Welecome To the USer Profile";
		
	}
	@PostMapping("/register")
	public Users registerUser(@RequestBody Users user) {

	return  loginService.register(user);

	}

	@PostMapping("/login")
	public String login(@RequestBody Users user) {
		System.out.println(user);
		return loginService.verify(user);
	}
	
	@PostMapping("/refresh-token")
	public ResponseEntity<?> refreshTokens(@RequestBody TokenRequest request) {
		System.out.println(request);
		return loginService.refreshToken(request);
	}

	@GetMapping("/user-id")
	public Users getUsers(@RequestBody Users user) {
		return loginService.findById(user.getId());
	}

	@GetMapping("/all-users")
	public List<Users>getAllUsers(){
		return loginService.alluserList();
		
	}

}
