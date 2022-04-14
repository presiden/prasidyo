package com.rumahit.prasidyo.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface ApiService {
	public String getFibonacci(int input);

	public int countIrisanString(String input);

	public Object getObject();

	public List<Object> getListObject();
}
