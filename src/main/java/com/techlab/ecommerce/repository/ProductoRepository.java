package com.techlab.ecommerce.repository;

import com.techlab.ecommerce.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    // Al extender de JpaRepository, Spring ya nos regala métodos como:
    // .save(), .findAll(), .findById(), .deleteById() sin escribir una sola línea de SQL.
}