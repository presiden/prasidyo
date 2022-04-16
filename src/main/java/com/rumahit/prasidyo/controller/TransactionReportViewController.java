package com.rumahit.prasidyo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rumahit.prasidyo.request.ProductRequest;
import com.rumahit.prasidyo.service.ProductService;
import com.rumahit.prasidyo.service.TransactionReportViewService;

@CrossOrigin
@RestController
@RequestMapping("/transaction-report")
public class TransactionReportViewController {

	@Autowired
	TransactionReportViewService transactionReportViewService;

	@GetMapping
	public ResponseEntity<?> findAll() {
		try {
			return new ResponseEntity<>(transactionReportViewService.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

}
