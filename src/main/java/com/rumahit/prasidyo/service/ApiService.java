package com.rumahit.prasidyo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rumahit.prasidyo.entity.Product;

@Service
public interface ApiService {
	public String getFibonacci(int input);

	public int countIrisanString(String input);

	public Product getProduct(Long id);

	public List<Product> getListProduct();
}
