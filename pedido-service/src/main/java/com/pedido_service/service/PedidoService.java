package com.pedido_service.service;

import com.pedido_service.dto.PedidoDTO;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {


    public String printDTO(PedidoDTO obj) {
        String arg = obj.toString();
        System.out.println(arg);
        return arg;
    }

}
