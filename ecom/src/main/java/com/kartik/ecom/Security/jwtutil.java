package com.kartik.ecom.Security;

import java.security.Key;
import java.security.Signature;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureAlgorithm;

@Component
public class jwtutil {

	@Value("${jwt.secret}")
	private String SECRET_KEY;
	
	@Value("${jwt.expiration}")
	private Long EXPIRATION_TIME;
	
	private SecretKey getsigningkey() {
		return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
	}
	
	
	public String generatetoken(String Username) {
		return Jwts.builder()
				.subject(Username)
				.issuedAt(new Date())
				.expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
				.signWith(getsigningkey())
				.compact();
		
	}
	
	public String extractusername(String token) {
		return extractAllClaims(token).getSubject();
	}
	
	public boolean istokenexpired(String token) {
		return extractAllClaims(token).getExpiration().before(new Date());
		
	}
	
	public boolean validatetoken(String token, String Username) {
		return extractusername(token).equals(Username) && !istokenexpired(token);
		
	}
	
	private Claims extractAllClaims(String token) {
		return Jwts.parser()
				.verifyWith(getsigningkey())
				.build()
				.parseSignedClaims(token)
				.getPayload();
	}
}
