package com.kartik.ecom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kartik.ecom.model.User;
import com.kartik.ecom.respotary.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository urepo;

	public String login(User user) {
		
		User existing = urepo.findbyemail(user.getEmail());
		if (existing == null) {
			return "user not found";
		}
		
		if(existing.getPassword().equals(user.getPassword())) {
			return "login successful";
		}
		
		return "Wrong password";
	}

	public User register(User user) {
		
		User existing = urepo.findbyemail(user.getEmail());
		if (existing != null) {
			throw new RuntimeException("user alread registered");
		}
		return urepo.save(user);
	}

	public User userdetails(int id) {
		
		return urepo.findById(id).orElse(null);
	}

	public User usermail(String email) {
		
		return urepo.findbyemail(email);
	}

	public User updatedtails(int id, User user) {
		User existing = urepo.findById(id).orElse(null);
		if (existing != null) {
			
			if (user.getName() != null) {
				existing.setName(user.getName());
			}
			if (user.getEmail() != null) {
				existing.setEmail(user.getEmail());
			}
			if (user.getPhone() != null) {
				existing.setPhone(user.getPhone());
			}
			if (user.getAddress() != null) {
				existing.setAddress(user.getAddress());
			}
		return urepo.save(existing);	
		}
		return null;
	}

	public String deleteuser(int id) {
		 urepo.deleteById(id);
		 return "deleted successfully";
	}	

}
