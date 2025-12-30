package com.chandan.order_service.ServiceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;

import com.chandan.order_service.dtos.InventoryDto;
import com.chandan.order_service.dtos.OrderLineItemsDto;
import com.chandan.order_service.dtos.OrderRequest;
import com.chandan.order_service.models.Order;
import com.chandan.order_service.models.OrderLineItems;
import com.chandan.order_service.repogetory.OrderRepo;
import com.chandan.order_service.services.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepo orderRepo;

	@Autowired
	WebClient webClient;

	@Override
	public Order saveOrder(OrderRequest orderRequest) {
		// TODO Auto-generated method stub
		List<String> skuCodeList = orderRequest.getItems().stream().map(OrderLineItemsDto::getSkuCode).toList();
		InventoryDto[] data = webClient.get()
				.uri("http://localhost:8082/inventory/isInStock",
						uriBuilder -> uriBuilder.queryParam("skuCodes", skuCodeList).build())
				.retrieve().bodyToMono(InventoryDto[].class).block();
		boolean isInStock = Arrays.stream(data).allMatch(InventoryDto::isAvailable);
		if (isInStock) {
			String orderNumber = UUID.randomUUID().toString();
			Order order = new Order();
			order.setOrderId(orderNumber);
			List<OrderLineItems> items = orderRequest.getItems().stream().map(this::mapOrderLineItem).toList();
			order.setItems(items);
			return orderRepo.save(order);
		}else {
			return null;
		}
	}

	private OrderLineItems mapOrderLineItem(OrderLineItemsDto orderLineItemsDto) {
		OrderLineItems orderLineItems = new OrderLineItems();
		orderLineItems.setPrice(orderLineItemsDto.getPrice());
		orderLineItems.setQty(orderLineItemsDto.getQty());
		orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
		return orderLineItems;
	}
}
