package com.product.productapi.controller;


import com.product.productapi.model.Product;
import com.product.productapi.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
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

    @GetMapping("/{id}")
    public Product getById(@PathVariable("id") String id) { // especificando o parametro (ja que o ID é UUID)
//        Optional<Product> product = productRepository.findById(id);
//        .var para criar variavel (optional: vai tentar encontrar o
//        produto com esse id)
        return productRepository.findById(id).orElse(null);
    }

}
