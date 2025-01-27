package com.example.demo.user.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.exception.UserAllRedyPresent;
import com.example.demo.userlogin.TokenRequest;
import com.example.demo.userlogin.Users;
import com.example.demo.userlogin.repository.UserLoginRepository;

@Service
public class UserLoginService {

	@Autowired
	private UserLoginRepository loginRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AuthenticationManager authManager;

	@Autowired
	private JWTService jwtService;

//    public boolean matches(CharSequence rawPassword, String encodedPassword) {
//
//
//        return passwordEncoder.matches(rawPassword, encodedPassword);
//    }
//
//    public String encode(CharSequence rawPassword) {
//        return Encoder.encode(rawPassword);
//    }

	public Users register(Users users) {
		Users userData = loginRepository.findByUsername(users.getUsername());
		if (userData != null) {
			throw new UserAllRedyPresent("User Already Present. " + "Please try to insert Another user");
		}

		users.setPassword(passwordEncoder.encode(users.getPassword()));

		return loginRepository.save(users);
	}

	public String verify(Users user) {
		try {
			Authentication authentication = authManager
					.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
			if (authentication.isAuthenticated()) {
				String token = jwtService.generateToken(user.getUsername());
				String refreshToken = jwtService.RefreshToken(user.getUsername());
				return String.format("{\"token\": \"%s\"\n \"refreshToken\": \"%s\"}", token, refreshToken);
			}
			return null;
		} catch (AuthenticationException e) {
			return "Invalid credentials. Authentication failed.";
		}

	}

	public ResponseEntity<?> refreshToken(TokenRequest tokenRequest) {
		String refreshToken = tokenRequest.getRefreshToken();
		if (jwtService.RefreshToken(refreshToken) != null) {
			String username = jwtService.extractUsername(refreshToken);
			String newAccessToken = jwtService.generateToken(username);
			return ResponseEntity.ok(Map.of("accessToken", newAccessToken));
		} else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid Refresh Token");
		}
	}

	public Users findById(int id) {
		Users user = loginRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
		String encryptedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encryptedPassword);
		loginRepository.save(user);

		return user;

	}
	public List<Users> alluserList(){
		return  loginRepository.findAll();
	}

}
