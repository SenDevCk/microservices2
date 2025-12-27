package com.chandan.product_service.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductResponse {
	   private Long id;
	   private String name;
	   private String description;
	   private Double price;
}
