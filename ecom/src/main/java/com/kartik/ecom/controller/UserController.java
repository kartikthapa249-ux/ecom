package com.kartik.ecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kartik.ecom.model.User;
import com.kartik.ecom.service.UserService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userv;
	
	@PostMapping("/login")
	public String login(@RequestBody User user ) {
		return userv.login(user);
		
	}
	
	@PostMapping("/register")
	public User register(@RequestBody User user) {
		return userv.register(user);
	}
	
	@GetMapping("/{id}")
	public User userdetails(@PathVariable int id) {
		return userv.userdetails(id);
	}

	@GetMapping("/email")
	public User usermail(@RequestParam String email) {
		return userv.usermail(email);
	}
	
	@PutMapping("/{id}")
	public User updatedetails(@PathVariable int id, @RequestBody User user) {
		return userv.updatedtails(id,user);
	}
	@DeleteMapping("/delete/{id}")
	public String deleteuser(@PathVariable int id) {
		return userv.deleteuser(id);
	}
}
