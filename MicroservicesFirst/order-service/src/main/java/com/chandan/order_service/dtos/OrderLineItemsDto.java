package com.chandan.order_service.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderLineItemsDto {
	private String skuCode;
	private Double price;
	private Integer qty;
}
