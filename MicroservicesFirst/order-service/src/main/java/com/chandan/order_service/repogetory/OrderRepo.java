package com.chandan.order_service.repogetory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chandan.order_service.models.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long>{

}
