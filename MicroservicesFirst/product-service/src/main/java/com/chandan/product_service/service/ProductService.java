package com.chandan.product_service.service;

import java.util.List;

import com.chandan.product_service.dtos.ProductRequestDto;
import com.chandan.product_service.dtos.ProductResponse;
import com.chandan.product_service.models.Product;

public interface ProductService {
	
	ProductResponse saveProduct(ProductRequestDto productDto);
	
	List<ProductResponse> getAllProduct();

}
