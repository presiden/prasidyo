package com.rumahit.prasidyo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.rumahit.prasidyo.service.ApiServiceImpl;

public class ApiServiceTest {

	private final ApiServiceImpl apiService = new ApiServiceImpl();

	@Test
	public void testGetFibonacci() {
		int input = 7;
		var result = apiService.getFibonacci(input);
		assertEquals("55 21 13 5 3 1 1", result);
	}
	
	@Test
	public void countIrisanString() {
		String input = "xxxxxxxxxxxxxxxxxxaxbcdefghzzzzzzzzzzzzzzzzzzzzzzzz";
		var result = apiService.countIrisanString(input);
		assertEquals(7, result);
	}
}
