package com.rahul.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rahul.transaction.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}

