package com.rumahit.prasidyo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rumahit.prasidyo.entity.Product;
import com.rumahit.prasidyo.service.ApiService;

@RestController
@RequestMapping("/api")
public class ApiController {

	@Autowired
	ApiService apiService;

	@GetMapping("/get-fibonacci/{input}")
	public ResponseEntity<?> getFibonacci(@PathVariable int input) {
		try {
			String result = apiService.getFibonacci(input);
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
	}

	@GetMapping("/count-irisan-string/{input}")
	public ResponseEntity<?> countIrisanString(@PathVariable String input) {
		try {
			int result = apiService.countIrisanString(input);
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
	}

	@GetMapping("/product/{id}")
	public ResponseEntity<?> getProduct(@PathVariable Long id) {
		try {
			Product product = apiService.getObject(id);
			return new ResponseEntity<>(product, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
	}

	@GetMapping("/product-list")
	public ResponseEntity<?> getProductList() {
		try {
			List<Product> productList = apiService.getListObject();
			return new ResponseEntity<>(productList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
	}
}
