package com.product.productapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// POJO -> Plain Old Java Object

@Entity
@Table(name = "product") // tbm não é obrigatório
public class Product {

    @Id // primary key
    @Column(name = "id") // tem o mesmo nome da table = não precisa colocar o @column
    private String id;

    @Column(name = "name")
    private String name;

    @Column
    private String info;
    
    @Column
    private Double price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", info='" + info + '\'' +
                ", price=" + price +
                '}';
    }
}
