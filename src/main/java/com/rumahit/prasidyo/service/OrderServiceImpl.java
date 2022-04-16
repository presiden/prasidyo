package com.rumahit.prasidyo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rumahit.prasidyo.entity.Order;
import com.rumahit.prasidyo.entity.OrderDetails;
import com.rumahit.prasidyo.entity.Product;
import com.rumahit.prasidyo.repository.CompanyRepository;
import com.rumahit.prasidyo.repository.OrderRepository;
import com.rumahit.prasidyo.repository.ProductRepository;
import com.rumahit.prasidyo.request.OrderDetailsRequest;
import com.rumahit.prasidyo.request.OrderRequest;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepo;
	
	@Autowired
	CompanyRepository companyRepo;

	@Autowired
	ProductRepository productRepo;
	
	ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public Order add(OrderRequest orderRequest) {
		List<OrderDetails> listOrderDetails = new ArrayList<OrderDetails>();
		Order order = new Order();
		
		for(OrderDetailsRequest details: orderRequest.getListDetails()) {
			OrderDetails orderDetails = new OrderDetails();
			Product product = productRepo.findById(details.getProductId()).get();
			
			orderDetails.setOrder(order);
			orderDetails.setProduct(product);
			orderDetails.setQuantity(details.getQuantity());
			orderDetails.setPrice(details.getPrice());
			orderDetails.setTotalPrice(details.getTotalPrice());
			orderDetails.setNotes(details.getNotes());
			
			listOrderDetails.add(orderDetails);
			
			product.setStock(product.getStock() - details.getQuantity());
		}
		
		order.setCompany(companyRepo.findById(orderRequest.getCompanyId()).get());
		order.setTotalPrice(orderRequest.getTotalPrice());
		order.setCreatedDate(new Date());
		order.setListDetails(listOrderDetails);
		
		return orderRepo.save(order);
	}

	@Override
	public List<Order> get() {
		return orderRepo.findAll();
	}

	@Override
	public Optional<Order> get(Long id) {
		return orderRepo.findById(id);
	}

	@Override
	public Order update(OrderRequest orderRequest) {
		List<OrderDetails> listOrderDetails = new ArrayList<OrderDetails>();
		Order order = new Order();
		
		for(OrderDetailsRequest details: orderRequest.getListDetails()) {
			OrderDetails orderDetails = new OrderDetails();
			orderDetails.setOrder(order);
			orderDetails.setProduct(productRepo.findById(details.getProductId()).get());
			orderDetails.setQuantity(details.getQuantity());
			orderDetails.setPrice(details.getPrice());
			orderDetails.setTotalPrice(details.getTotalPrice());
			orderDetails.setNotes(details.getNotes());
			
			listOrderDetails.add(orderDetails);
		}
		
		order.setCompany(companyRepo.findById(orderRequest.getCompanyId()).get());
		order.setTotalPrice(orderRequest.getTotalPrice());
		order.setCreatedDate(new Date());
		order.setListDetails(listOrderDetails);
		
		return orderRepo.save(order);
	}

	@Override
	public void delete(Long id) {
		if(get(id).isPresent()) {
			orderRepo.delete(get(id).get());
		}
	}

}
