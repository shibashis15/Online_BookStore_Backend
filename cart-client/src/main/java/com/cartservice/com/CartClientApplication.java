package com.cartservice.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CartClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartClientApplication.class, args);
	}

}
