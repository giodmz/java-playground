package com.product.productapi.repository;

import com.product.productapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> { // rep de product, a classe que representa o ID

    List<Product> findByName(String name);
}
