package com.techlab.ecommerce.controller;

import com.techlab.ecommerce.model.Producto;
import com.techlab.ecommerce.repository.ProductoRepository;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    
    private final ProductoRepository productoRepository;

    // Este constructor reemplaza al @Autowired. Spring pasa el repositorio por acá automáticamente.
    public ProductoController(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    // 1. OBTENER TODOS LOS PRODUCTOS (GET)
    @GetMapping
    public List<Producto> obtenerTodos() {
        return productoRepository.findAll();
    }

    // 2. CREAR UN PRODUCTO (POST)
    @PostMapping
    public Producto crearProducto(@Valid @RequestBody Producto producto) {
        return productoRepository.save(producto);
    }

    @GetMapping("/{id}")
public ResponseEntity<Producto> obtenerPorId(@PathVariable Integer id) {
    return productoRepository.findById(id)
            .map(producto -> ResponseEntity.ok(producto))
            .orElse(ResponseEntity.notFound().build());
}

// 4. ACTUALIZAR UN PRODUCTO EXISTENTE (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Integer id, @RequestBody Producto productoDetalles) {
        return productoRepository.findById(id)
                .map(productoExistente -> {
                    productoExistente.setNombre(productoDetalles.getNombre());
                    productoExistente.setDescripcion(productoDetalles.getDescripcion());
                    productoExistente.setPrecio(productoDetalles.getPrecio());
                    productoExistente.setCategoria(productoDetalles.getCategoria());
                    productoExistente.setImagenUrl(productoDetalles.getImagenUrl());
                    productoExistente.setStock(productoDetalles.getStock());
                    Producto productoActualizado = productoRepository.save(productoExistente);
                    return ResponseEntity.ok(productoActualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // 5. ELIMINAR UN PRODUCTO (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Integer id) {
        return productoRepository.findById(id)
                .map(producto -> {
                    productoRepository.delete(producto);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }


}