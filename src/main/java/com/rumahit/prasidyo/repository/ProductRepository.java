package com.rumahit.prasidyo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rumahit.prasidyo.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
