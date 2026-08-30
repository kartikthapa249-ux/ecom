package com.kartik.ecom.respotary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kartik.ecom.model.Product;
@Repository
public interface Productrepositary extends JpaRepository<Product, Integer>  {


	List<Product> findByName(String name);


	List<Product> findByNameContainingIgnoreCaseOrBrandIgnoreCase(String name, String brand);


	List<Product> findByCategary(String categary);


}
