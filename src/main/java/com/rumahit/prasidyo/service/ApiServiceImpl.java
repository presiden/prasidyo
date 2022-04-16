package com.rumahit.prasidyo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rumahit.prasidyo.entity.Product;
import com.rumahit.prasidyo.repository.ProductRepository;

@Service
public class ApiServiceImpl implements ApiService {

	@Autowired
	ProductRepository productRepo;

	@Override
	public String getFibonacci(int input) {
		String result = getOddFibonacci(input);

		return result;
	}

	private String getOddFibonacci(int input) {
		int n1 = 0, n2 = 1;
		String result = "";
		int[] fibo = new int[input];

		for (int x = 0; x < input; x++) {
			if (n1 % 2 != 0) {
				fibo[x] = n1;
			} else {
				x--;
			}

			int n3 = n1 + n2;
			n1 = n2;
			n2 = n3;
		}

		result = reverseFibonacci(fibo);
		return result;
	}

	private static String reverseFibonacci(int[] input) {
		String result = "";
		for (int i = input.length - 1; i >= 0; i--) {
			result += input[i] + " ";
		}
		result = result.substring(0, result.length()-1);
		return result;
	}

	@Override
	public int countIrisanString(String input) {
		final String alphabet = "abcdefghijklmnopqrstuvwxyz";
		String shortText = alphabet.length() < input.length() ? alphabet : input;
		String longText = alphabet.length() > input.length() ? alphabet : input;
		int result = 0, len = shortText.length();

		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len - i; j++) {
				String sub1 = shortText.substring(i, len - j);
				String sub2 = shortText.substring(j, len);

				if (longText.contains(sub1)) {
					result = sub1.length() > result ? sub1.length() : result;
				}

				if (longText.contains(sub2)) {
					result = sub2.length() > result ? sub2.length() : result;
				}
			}
		}

		return result;
	}
	
	@Override
	public List<Product> getListProduct() {
		return productRepo.findAll();
	}

	@Override
	public Product getProduct(Long id) {
		return productRepo.findById(id).get();
	}

}
