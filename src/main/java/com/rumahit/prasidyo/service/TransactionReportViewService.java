package com.rumahit.prasidyo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.rumahit.prasidyo.entity.TransactionReportView;

@Service
public interface TransactionReportViewService {
	
	List<TransactionReportView> findAll();

	List<TransactionReportView> findAll(Sort sort);

	Page<TransactionReportView> findAll(Pageable pageable);

	Optional<TransactionReportView> findById(Long id);

	long count();
}
