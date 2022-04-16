package com.rumahit.prasidyo.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rumahit.prasidyo.entity.Company;
import com.rumahit.prasidyo.repository.CompanyRepository;
import com.rumahit.prasidyo.request.CompanyRequest;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	CompanyRepository companyRepo;

	ModelMapper modelMapper = new ModelMapper();

	@Override
	public Company add(CompanyRequest companyRequest) {
		Company company = modelMapper.map(companyRequest, Company.class);
		company.setCreatedDate(new Date());
		
		return companyRepo.save(company);
	}

	@Override
	public List<Company> get() {
		return companyRepo.findAll();
	}

	@Override
	public Optional<Company> get(Long id) {
		return companyRepo.findById(id);
	}

	@Override
	public Company update(CompanyRequest companyRequest) {
		Company company = modelMapper.map(companyRequest, Company.class);
		company.setUpdatedDate(new Date());
		
		return companyRepo.save(company);
	}

	@Override
	public void delete(Long id) {
		if(get(id).isPresent()) {
			companyRepo.delete(get(id).get());
		}
	}

}
