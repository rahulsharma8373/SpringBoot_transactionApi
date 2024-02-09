package com.rahul.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rahul.transaction.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
