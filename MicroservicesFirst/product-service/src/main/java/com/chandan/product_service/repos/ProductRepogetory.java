package com.chandan.product_service.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chandan.product_service.models.Product;

public interface ProductRepogetory extends JpaRepository<Product, Long>{

}
