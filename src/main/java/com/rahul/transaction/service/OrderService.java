package com.rahul.transaction.service;

import com.rahul.transaction.dto.OrderRequest;
import com.rahul.transaction.dto.OrderResponse;

public interface OrderService {

	OrderResponse placeOrder(OrderRequest orderRequest);

}
