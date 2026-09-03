package com.kartik.ecom.Exception_class;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(Productnotfound.class)
	public ResponseEntity<String> productnotfound(Productnotfound e){
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(e.getMessage());
		
	}
	
	@ExceptionHandler(InvalidProductException.class)
	public ResponseEntity<String> invalidProductException(InvalidProductException e){
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(e.getMessage());
	}

}
