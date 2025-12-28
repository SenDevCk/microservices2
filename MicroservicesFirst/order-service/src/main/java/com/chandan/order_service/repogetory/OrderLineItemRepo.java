package com.chandan.order_service.repogetory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chandan.order_service.models.OrderLineItems;

public interface OrderLineItemRepo extends JpaRepository<OrderLineItems, Long>{

}
