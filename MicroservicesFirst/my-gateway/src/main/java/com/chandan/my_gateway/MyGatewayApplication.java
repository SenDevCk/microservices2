package com.chandan.my_gateway;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyGatewayApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(MyGatewayApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.err.println("Api gateway is running fine...");
	}

}
