package com.rumahit.prasidyo.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rumahit.prasidyo.entity.Product;
import com.rumahit.prasidyo.entity.Order;
import com.rumahit.prasidyo.entity.Product;
import com.rumahit.prasidyo.repository.OrderRepository;
import com.rumahit.prasidyo.repository.ProductRepository;
import com.rumahit.prasidyo.request.ProductRequest;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepo;

	ModelMapper modelMapper = new ModelMapper();

	@Override
	public Product add(ProductRequest productRequest) {
		Product product = modelMapper.map(productRequest, Product.class);
		product.setCreatedDate(new Date());

		return productRepo.save(product);
	}

	@Override
	public List<Product> get() {
		return productRepo.findAll();
	}

	@Override
	public Optional<Product> get(Long id) {
		return productRepo.findById(id);
	}

	@Override
	public Product update(ProductRequest productRequest) {
		Product product = modelMapper.map(productRequest, Product.class);
		product.setUpdatedDate(new Date());
		
		return productRepo.save(product);
	}

	@Override
	public void delete(Long id) {
		if(get(id).isPresent()) {
			productRepo.delete(get(id).get());
		}
	}

}
