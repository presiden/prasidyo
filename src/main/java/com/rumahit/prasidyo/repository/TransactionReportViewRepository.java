package com.rumahit.prasidyo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import com.rumahit.prasidyo.entity.TransactionReportView;

//@Repository
//public interface TransactionReportViewRepository extends JpaRepository<TransactionReportView, Long> {
public interface TransactionReportViewRepository extends ReadOnlyRepository<TransactionReportView, Long> {
}
