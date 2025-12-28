package com.chandan.order_service.dtos;

import java.util.List;

import com.chandan.order_service.models.OrderLineItems;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderRequest {
	 private List<OrderLineItemsDto> items;
}
