package com.techlab.ecommerce.controller;

import com.techlab.ecommerce.model.Producto;
import com.techlab.ecommerce.repository.ProductoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    // Al poner final, nos aseguramos de que no cambie y obligamos a usar el constructor
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
    public Producto crearProducto(@RequestBody Producto producto) {
        return productoRepository.save(producto);
    }
}