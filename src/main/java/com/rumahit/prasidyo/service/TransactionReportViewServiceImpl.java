package com.rumahit.prasidyo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.rumahit.prasidyo.entity.TransactionReportView;
import com.rumahit.prasidyo.repository.TransactionReportViewRepository;

@Service
public class TransactionReportViewServiceImpl implements TransactionReportViewService{
	
	@Autowired
	TransactionReportViewRepository repo;
	
	@Override
	public List<TransactionReportView> findAll() {
		List<TransactionReportView> res = repo.findAll();
		return res;
	}

	@Override
	public List<TransactionReportView> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<TransactionReportView> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<TransactionReportView> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

}
