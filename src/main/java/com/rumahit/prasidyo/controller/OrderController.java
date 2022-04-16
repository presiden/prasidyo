package com.rumahit.prasidyo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rumahit.prasidyo.entity.Company;
import com.rumahit.prasidyo.entity.Order;
import com.rumahit.prasidyo.request.OrderRequest;
import com.rumahit.prasidyo.service.OrderService;

@CrossOrigin
@RestController
@RequestMapping("/transaction")
public class OrderController {
	
	@Autowired
	OrderService orderService;

	@PostMapping
	public ResponseEntity<?> addOrder(@RequestBody OrderRequest orderRequest){
		try {
			return new ResponseEntity<>(orderService.add(orderRequest), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping
	public ResponseEntity<?> getOrder() {
		try {
			List<Order> orderList = orderService.get();
			if (orderList.isEmpty() || orderList.size() == 0) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(orderList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getOrderById(@PathVariable Long id) {
		try {
			Optional<Order> order = orderService.get(id);
			if (order.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(order.get(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	@PutMapping
	public ResponseEntity<?> updateOrder(@RequestBody OrderRequest orderRequest) {
		try {
			return new ResponseEntity<>(orderService.update(orderRequest), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteOrder(@PathVariable Long id) {
		try {
			orderService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
