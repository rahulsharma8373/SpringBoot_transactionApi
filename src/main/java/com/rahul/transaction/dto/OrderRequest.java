package com.rahul.transaction.dto;

import com.rahul.transaction.entity.Order;
import com.rahul.transaction.entity.Payment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {
    private Order order;
    private Payment payment;
}
