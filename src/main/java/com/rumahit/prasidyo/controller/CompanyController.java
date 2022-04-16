package com.rumahit.prasidyo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rumahit.prasidyo.entity.Company;
import com.rumahit.prasidyo.request.CompanyRequest;
import com.rumahit.prasidyo.service.CompanyService;

@CrossOrigin
@RestController
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	CompanyService companyService;
	
	@PostMapping
	public ResponseEntity<?> addCompany(@RequestBody CompanyRequest companyRequest){
		try {
			return new ResponseEntity<>(companyService.add(companyRequest), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping
	public ResponseEntity<?> getCompany() {
		try {
			List<Company> companyList = companyService.get();
			if (companyList.isEmpty() || companyList.size() == 0) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(companyList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getCompanyById(@PathVariable Long id) {
		try {
			Optional<Company> company = companyService.get(id);
			if (company.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(company.get(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody CompanyRequest companyRequest) {
		try {
			return new ResponseEntity<>(companyService.update(companyRequest), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCompany(@PathVariable Long id) {
		try {
			companyService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
