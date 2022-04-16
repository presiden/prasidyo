package com.rumahit.prasidyo.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rumahit.prasidyo.entity.OrderDetails;
import com.rumahit.prasidyo.entity.Order;
import com.rumahit.prasidyo.repository.OrderDetailsRepository;
import com.rumahit.prasidyo.request.OrderDetailsRequest;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {

	@Autowired
	OrderDetailsRepository orderDetailsRepo;

	ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public OrderDetails add(OrderDetailsRequest orderDetailsRequest) {
		OrderDetails orderDetails = modelMapper.map(orderDetailsRequest, OrderDetails.class);
		
		return orderDetailsRepo.save(orderDetails);
	}

	@Override
	public List<OrderDetails> get() {
		return orderDetailsRepo.findAll();
	}

	@Override
	public Optional<OrderDetails> get(Long id) {
		return orderDetailsRepo.findById(id);
	}

	@Override
	public OrderDetails update(OrderDetailsRequest orderDetailsRequest) {
		OrderDetails orderDetails = modelMapper.map(orderDetailsRequest, OrderDetails.class);
		
		return orderDetailsRepo.save(orderDetails);
	}

	@Override
	public void delete(Long id) {
		if(get(id).isPresent()) {
			orderDetailsRepo.delete(get(id).get());
		}
	}
}
