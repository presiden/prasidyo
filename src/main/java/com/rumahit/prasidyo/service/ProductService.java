package com.rumahit.prasidyo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rumahit.prasidyo.entity.Product;
import com.rumahit.prasidyo.request.ProductRequest;

@Service
public interface ProductService {

	Product add(ProductRequest productRequest);

	List<Product> get();

	Optional<Product> get(Long id);

	Product update(ProductRequest productRequest);

	void delete(Long id);
}
