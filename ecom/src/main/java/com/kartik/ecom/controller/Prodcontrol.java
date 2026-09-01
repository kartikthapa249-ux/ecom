package com.kartik.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kartik.ecom.model.Product;
import com.kartik.ecom.service.Productservice;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/product")
public class Prodcontrol {
	
	@Autowired
	Productservice service;
	
//	@GetMapping("/home")
//	public String kar() {
//		return service.greet();
//		
//	}
	
	@PostMapping("/multiple")
	public List<Product> addproduct(@RequestBody List<Product> product) {
		return service.addproduct(product) ;
	}
	@PostMapping
	public Product Singleproduct(@RequestBody Product product) {
		return service.Singleproduct(product) ;
	}
	@GetMapping("/all")
	public List<Product> getallproduct() {
		return service.getallproduct();
	}
	
	@GetMapping("/{id}")
	public Product getProduct(@PathVariable int id) {
		return service.getProduct(id);
	}
	
	@PutMapping("/update/{id}")
	public Product UpdateProduct(@PathVariable int id , @RequestBody Product product) {
		return service.UpdateProduct(id, product);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteproduct(@PathVariable int id) {
		service.deleteproduct(id);
		return "Product deleted succesfully";
	}
	@GetMapping("/search")
		public List<Product> Searchproduct(@RequestParam String key ){
			return service.Searchproduct(key);
		
	}
	@GetMapping("/categary")
	public List<Product> getbycategary(@RequestParam String categary) {
		return service.getbycategary(categary);
	}
	

}
