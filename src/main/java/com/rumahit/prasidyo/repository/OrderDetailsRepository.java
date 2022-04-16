package com.rumahit.prasidyo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rumahit.prasidyo.entity.OrderDetails;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {

}
