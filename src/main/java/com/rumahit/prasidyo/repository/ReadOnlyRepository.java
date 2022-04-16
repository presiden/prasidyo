package com.rumahit.prasidyo.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
//@Repository
public interface ReadOnlyRepository<T, ID> extends Repository<T, ID> {
//	public interface ReadOnlyRepository<T, ID extends Serializable> extends Repository<T, ID> {
	List<T> findAll();

	List<T> findAll(Sort sort);

	Page<T> findAll(Pageable pageable);

	Optional<T> findById(ID id);

	long count();
}
