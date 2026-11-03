package com.kartik.ecom.Security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.kartik.ecom.service.UserService;
import com.kartik.ecom.service.jwtservice;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component

public class jwtfilter extends OncePerRequestFilter{
	
	@Autowired
	private jwtutil util;

	@Autowired
	private userdetailserviceimpl userdetailservice;
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String authHeader = request.getHeader("Authorization");
		String token = null;
		String email = null;
		
		if (authHeader != null && authHeader.startsWith("Bearer ")) {
			
			token = authHeader.substring(7);
			try {
				email = util.extractusername(token);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		
		if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			
			UserDetails userdetails = userdetailservice.loadUserByUsername(email);
			
			if (util.validatetoken(token, userdetails.getUsername())) {
				
				UsernamePasswordAuthenticationToken authtoken = new UsernamePasswordAuthenticationToken(userdetails	, null, userdetails.getAuthorities());
				authtoken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authtoken);
			}
		}
		
		filterChain.doFilter(request, response);
	}

}
