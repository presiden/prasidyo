package com.rumahit.prasidyo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rumahit.prasidyo.entity.Order;
import com.rumahit.prasidyo.request.OrderRequest;

@Service
public interface OrderService {

	Order add(OrderRequest orderRequest);
	
	List<Order> get();
	
	Optional<Order> get(Long id);
	
	Order update(OrderRequest orderRequest);
	
	void delete(Long id);
}
