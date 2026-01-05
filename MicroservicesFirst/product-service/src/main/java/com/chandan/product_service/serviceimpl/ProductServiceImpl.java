package com.chandan.product_service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientAutoConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


import com.chandan.product_service.dtos.InventoryRequestDto;
import com.chandan.product_service.dtos.ProductRequestDto;
import com.chandan.product_service.dtos.ProductResponse;
import com.chandan.product_service.models.Product;
import com.chandan.product_service.repos.ProductRepogetory;
import com.chandan.product_service.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepogetory productRepogetory;
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	@Override
	public ProductResponse saveProduct(ProductRequestDto productDto) {
		log.debug("product service {}",productDto.getName());
		// TODO Auto-generated method stub
		Product product=Product.builder().name(productDto.getName())
				.description(productDto.getDescription()).price(productDto.getPrice()).build();
		product=productRepogetory.save(product);
		log.debug("inventory entering product created {}",product);
		if(product!=null) {
			InventoryRequestDto dtoInventory=InventoryRequestDto.builder().skuCode(product.getName().replaceAll("\\s+", "")).qty(0).build();
			webClientBuilder.build()
		    .post()
		    .uri("http://inventory-service/inventory/make-inventory")
		    .bodyValue(dtoInventory)   // ✅ send as JSON body
		    .retrieve()
		    .bodyToMono(String.class)
		    .block();
		}
		return ProductResponse.builder().id(product.getId()).name(product.getName())
				.description(product.getDescription()).price(product.getPrice()).build();
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
