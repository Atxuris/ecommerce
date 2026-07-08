package com.techlab.ecommerce.service;

import com.techlab.ecommerce.exception.StockInsuficienteException;
import com.techlab.ecommerce.model.LineaPedido;
import com.techlab.ecommerce.model.Pedido;
import com.techlab.ecommerce.model.Producto;
import com.techlab.ecommerce.repository.PedidoRepository;
import com.techlab.ecommerce.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ProductoRepository productoRepository;

    // Un único constructor que recibe ambos repositorios y limpia las líneas amarillas
    public PedidoService(PedidoRepository pedidoRepository, ProductoRepository productoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.productoRepository = productoRepository;
    }

    public Pedido registrarPedido(Pedido pedido) {
        for (LineaPedido linea : pedido.getLineas()) {
            Optional<Producto> productoBuscado = productoRepository.findById(linea.getProducto().getId());
            
            if (productoBuscado.isPresent()) {
                Producto productoDb = productoBuscado.get();
                
                if (linea.getQuantity() > productoDb.getStock()) {
                    throw new StockInsuficienteException("No hay stock suficiente para el producto: " + productoDb.getNombre());
                }
                
                int nuevoStock = productoDb.getStock() - linea.getQuantity();
                productoDb.setStock(nuevoStock);
                
                productoRepository.save(productoDb);
                linea.setProducto(productoDb);
            } else {
                throw new RuntimeException("El producto con ID " + linea.getProducto().getId() + " no existe.");
            }
        }
        
        pedido.calcularTotal();
        return pedidoRepository.save(pedido);
    }
}