package com.chandan.order_service.services;

import com.chandan.order_service.dtos.OrderRequest;
import com.chandan.order_service.models.Order;

public interface OrderService {
   
	Order saveOrder(OrderRequest orderRequest);
}
