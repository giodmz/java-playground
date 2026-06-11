package com.pedido_service.controller;

import com.pedido_service.dto.PedidoDTO;
import com.pedido_service.service.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/pedidos")
public class PedidoController{


    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> postPedido(@RequestBody PedidoDTO obj){
        service.printDTO(obj);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{pedidos}")
                .buildAndExpand(obj.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }
}
