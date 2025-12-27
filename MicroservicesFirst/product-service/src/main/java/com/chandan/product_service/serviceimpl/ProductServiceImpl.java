package com.chandan.product_service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chandan.product_service.dtos.ProductRequestDto;
import com.chandan.product_service.dtos.ProductResponse;
import com.chandan.product_service.models.Product;
import com.chandan.product_service.repos.ProductRepogetory;
import com.chandan.product_service.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepogetory productRepogetory;
	@Override
	public ProductResponse saveProduct(ProductRequestDto productDto) {
		// TODO Auto-generated method stub
		Product product=Product.builder().name(productDto.getName())
				.description(productDto.getDescription()).price(productDto.getPrice()).build();
		productRepogetory.save(product);
		return ProductResponse.builder().name(product.getName()).description(product.getDescription()).build();
	}

	@Override
	public List<ProductResponse> getAllProduct() {
		// TODO Auto-generated method stub
		return productRepogetory.findAll().stream().map(this::maptoProductResponse).toList();
	}
    private ProductResponse maptoProductResponse(Product product) {
    	return ProductResponse.builder().id(product.getId())
    			.name(product.getName())
    			.description(product.getDescription())
    			.price(product.getPrice())
    			.build();
    }
}
