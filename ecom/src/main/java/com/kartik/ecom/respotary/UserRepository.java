package com.kartik.ecom.respotary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kartik.ecom.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findbyemail(String email);

	//User findbyId(User user);

}
