package com.example.demo.user.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTService {
	
	@Value("${jwt.secret-key}")
    private final String secretKey=null;

//    public JWTService(@Value("${jwt.secret-key}") String secretKey) {
//        this.secretKey = secretKey;
//    }
	
    @Value("${jwt.refresh-token}")
	private  String refreshTokenKey;
    
    @Value("${jwt.token-expiration}")
	private  long expireToken;

    @Value("${jwt.refresh-token-expiration}")
    private long refreshTokenExpiration;


	public String generateToken(String username) {
		
		Map<String, Object>claims=new  HashMap<String, Object>();
		return Jwts.builder()
				.claims()
				.add(claims)
				.subject(username)
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis()+expireToken))
				.and()
				.signWith(getKey())
				.compact();
		
	}
	
	public String RefreshToken(String username) {
		
		Map<String, Object>claims=new  HashMap<String, Object>();
		return Jwts.builder()
				.claims()
				.add(claims)
				.subject(username)
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis()+refreshTokenExpiration))
				.and()
				.signWith(Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey)))
				.compact();
	}

	private SecretKey getKey() {
		byte[]keyBytes=Decoders.BASE64.decode(secretKey);
		return Keys.hmacShaKeyFor(keyBytes);
	}
	
    private SecretKey getRefreshKey() {
        byte[] keyBytes = Decoders.BASE64.decode(refreshTokenKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

	public String extractUsername(String token) {
		return extractClaim(token,Claims::getSubject);
	}

	private <T> T extractClaim(String token, Function<Claims, T>claimResolver) {
		final Claims  claims=extractAllClaims(token);
		return claimResolver.apply(claims);
	}

	@SuppressWarnings("deprecation")
	private Claims extractAllClaims(String token) {
		return Jwts.parser().setSigningKey(Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey)))
				.build().parseClaimsJws(token).getBody();
	}
		
	public boolean validateToken(String token, UserDetails userDetails) {
		final String userName=extractUsername(token);
		return (userName.equals(userDetails.getUsername())&& ! isTokenExpired(token)) ;
	}
	
	//refresh Token 
	public boolean RefreshToken(String token, UserDetails userDetails) {
		final String userName=extractUsername(token);
		return (userName.equals(userDetails.getUsername())&& ! isTokenExpired(token)) ;
	}

	private boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}
	private Date extractExpiration(String token) {
		return extractClaim(token,Claims::getExpiration);
	}
	


}
