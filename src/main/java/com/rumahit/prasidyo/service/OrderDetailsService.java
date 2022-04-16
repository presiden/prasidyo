package com.rumahit.prasidyo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rumahit.prasidyo.entity.OrderDetails;
import com.rumahit.prasidyo.request.OrderDetailsRequest;

@Service
public interface OrderDetailsService {

	OrderDetails add(OrderDetailsRequest orderDetailsRequest);
	
	List<OrderDetails> get();
	
	Optional<OrderDetails> get(Long id);
	
	OrderDetails update(OrderDetailsRequest orderDetailsRequest);
	
	void delete(Long id);
}
