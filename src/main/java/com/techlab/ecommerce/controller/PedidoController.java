package com.techlab.ecommerce.controller;

import com.techlab.ecommerce.model.Pedido;
import com.techlab.ecommerce.service.PedidoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    // CREAR UN PEDIDO (POST)
    @PostMapping
    public Pedido realizarPedido(@RequestBody Pedido pedido) {
        return pedidoService.registrarPedido(pedido);
    }
}