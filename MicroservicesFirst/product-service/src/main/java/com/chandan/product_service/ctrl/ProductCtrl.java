package com.chandan.product_service.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.chandan.product_service.dtos.ProductRequestDto;
import com.chandan.product_service.dtos.ProductResponse;
import com.chandan.product_service.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductCtrl {
  
	@Autowired
	ProductService productService;
	
	@PostMapping("/create-product")
	@ResponseStatus(HttpStatus.CREATED)
	ProductResponse careateProduct(@RequestBody ProductRequestDto product) {
		System.out.println(product.toString());
		ProductResponse product2=  productService.saveProduct(product);
		return product2;
	}
	
	@GetMapping("/getAllProduct")
	@ResponseStatus(HttpStatus.OK)
	List<ProductResponse> getAllProduct() {
		List<ProductResponse> products=  productService.getAllProduct();
		return products;
	}
	
	@PostMapping("/create-product2")
	@ResponseStatus(HttpStatus.OK)
	ProductResponse careateProduct2(@RequestBody ProductRequestDto productRequestDto) {
		//System.out.println(product.toString());
		ProductResponse product2=  ProductResponse.builder().name(productRequestDto.getName()).build();
		return product2;
	}
}
