package com.chandan.order_service.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chandan.order_service.dtos.OrderRequest;
import com.chandan.order_service.models.Order;
import com.chandan.order_service.services.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	OrderService orderService;
    
	@PostMapping("/createOrder")
	public String makeOrder(@RequestBody OrderRequest orderRequest) {
		// TODO Auto-generated method stub
       Order order= orderService.saveOrder(orderRequest);
       return (order==null)?"Order not Placed.":"Order Placed Successfully";
	}
}
