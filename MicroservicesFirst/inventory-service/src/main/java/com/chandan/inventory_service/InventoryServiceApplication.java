package com.chandan.inventory_service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.chandan.inventory_service.models.Inventory;
import com.chandan.inventory_service.repogetory.InventoryRepo;

@SpringBootApplication
//@EnableDiscoveryClient
public class InventoryServiceApplication implements CommandLineRunner{
	
	@Autowired
	InventoryRepo inventoryRepo;

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.err.println("Inventory App Running...");
	}

}
