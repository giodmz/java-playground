package com.product.productapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ProductApiApplication {

	@GetMapping("/test") // url
	public String Test(){
		return "Teste1";
	}

	public static void main(String[] args) {
		SpringApplication.run(ProductApiApplication.class, args);
	}

}
