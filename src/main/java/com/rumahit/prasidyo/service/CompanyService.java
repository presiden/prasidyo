package com.rumahit.prasidyo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rumahit.prasidyo.entity.Company;
import com.rumahit.prasidyo.request.CompanyRequest;

@Service
public interface CompanyService {
	Company add(CompanyRequest companyRequest);
	
	List<Company> get();
	
	Optional<Company> get(Long id);
	
	Company update(CompanyRequest companyRequest);
	
	void delete(Long id);
}
