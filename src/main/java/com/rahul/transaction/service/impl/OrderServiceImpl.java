package com.rahul.transaction.service.impl;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.rahul.transaction.dto.OrderRequest;
import com.rahul.transaction.dto.OrderResponse;
import com.rahul.transaction.entity.Order;
import com.rahul.transaction.entity.Payment;
import com.rahul.transaction.exception.PaymentException;
import com.rahul.transaction.repository.OrderRepository;
import com.rahul.transaction.repository.PaymentRepository;
import com.rahul.transaction.service.OrderService;

import jakarta.transaction.Transactional;
@Repository
public class OrderServiceImpl implements OrderService {

	private OrderRepository orderRepository;
    private PaymentRepository paymentRepository;

    public OrderServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    @Transactional
    public OrderResponse placeOrder(OrderRequest orderRequest) {

        Order order = orderRequest.getOrder();
        order.setStatus("INPROGRESS");
        order.setOrderTackingNumber(UUID.randomUUID().toString());
        orderRepository.save(order);

        Payment payment = orderRequest.getPayment();

        if(!payment.getType().equals("DEBIT")){
            throw new PaymentException("Payment card type do not support");
        }

        payment.setOrderId(order.getId());
        paymentRepository.save(payment);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderTackingNumber(order.getOrderTackingNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("SUCCESS");
        return orderResponse;
    }
}
