package com.pedido_service.dto;


import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

public class PedidoDTO {

    UUID id;
    String description;
    Double value;

    public PedidoDTO(@RequestBody String description, UUID id, Double value) {
        this.description = description;
        this.id = id;
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public UUID getId() {
        return id;
    }

    public Double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "PedidoDTO{" +
                "description='" + description + '\'' +
                ", id=" + id +
                ", value=" + value +
                '}';
    }
}
