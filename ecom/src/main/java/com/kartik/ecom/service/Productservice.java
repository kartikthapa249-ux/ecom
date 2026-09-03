package com.kartik.ecom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kartik.ecom.Exception_class.InvalidProductException;
import com.kartik.ecom.Exception_class.Productnotfound;
import com.kartik.ecom.model.Product;
import com.kartik.ecom.respotary.Productrepositary;

@Service
public class Productservice {
	
	@Autowired
	Productrepositary repo;
	
	public String greet() {
		return "Hello kartik" ;
	}
		public List<Product> addproduct(List<Product> product) {
			return repo.saveAll(product);
			
	}
		public Product Singleproduct(Product product) {
		    return repo.save(product);
		}
		
		public List<Product> getallproduct(){
			return repo.findAll();
		}

		public Product getProduct(int id) {
			return repo.findById(id)
					.orElseThrow(() -> 
					new Productnotfound("product not found with id: "+ id));
		}
		public void deleteproduct(int id) {
			repo.deleteById(id);
		}
		public Product UpdateProduct(int id, Product product) {	
		
			Product existing = repo.findById(id).orElse(null);
			
			if(existing != null) {
				
			if(product.getName()!= null) {
				existing.setName(product.getName());
			}
				if(product.getDescription() != null) {
				existing.setDescription(product.getDescription());
				}	
				if(product.getBrand() != null) {
				existing.setBrand(product.getBrand());
				}
				if(product.getPrice() !=  null ) {
					
					if(product.getPrice() <= 0 ) {
						throw new InvalidProductException("The Price Cannot be Null");
					}
				existing.setPrice(product.getPrice());
				}
				if(product.getRelease_date() != null) {
				existing.setRelease_date(product.getRelease_date());
				}
				if(product.getQuantity() != null) {
					if(product.getQuantity() < 0 ) {
						 throw new IllegalArgumentException("The Quantity Cannot be Null ");
					}
				existing.setQuantity(product.getQuantity());
				}
				if(product.getCategary()
						!= null) {
				existing.setCategary(product.getCategary());
				}
				return repo.save(existing);
			}
			return null;
		}
		public List<Product> Searchproduct(String key) {
			
			return repo.findByNameContainingIgnoreCaseOrBrandIgnoreCase(key,key);
			
		}
		public List<Product> getbycategary(String categary) {
			return repo.findByCategary(categary);
		}
		
		
}
