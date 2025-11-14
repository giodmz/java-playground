package com.product.productapi.controller;


import com.product.productapi.model.Product;
import com.product.productapi.repository.ProductRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("products")
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping
    public Product save(@RequestBody Product product){ // o objeto virá no body da requisição JSON -> App
        System.out.println("product received: " + product);
        var id = UUID.randomUUID().toString(); // Universal Unique ID (gerar id aleatorio)
        product.setId(id);
        productRepository.save(product);
        return product;
    }

}
