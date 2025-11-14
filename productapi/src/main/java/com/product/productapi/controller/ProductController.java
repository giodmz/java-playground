package com.product.productapi.controller;


import com.product.productapi.model.Product;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
public class ProductController {

    @PostMapping
    public void save(@RequestBody Product product){ // o objeto virá no body da requisição JSON -> App
        System.out.println("product received: " + product);
    }
}
