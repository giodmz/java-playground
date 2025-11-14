package com.product.productapi.repository;

import com.product.productapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> { // rep de product, a classe que representa o ID

}
