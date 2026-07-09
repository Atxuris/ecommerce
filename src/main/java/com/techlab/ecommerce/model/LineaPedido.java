package com.techlab.ecommerce.model;

import jakarta.persistence.*;

@Entity
@Table(name = "linea_pedidos")
public class LineaPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    private int cantidad;

    public LineaPedido() {
    }

    public LineaPedido(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    // Método para calcular el subtotal de esta línea usando operadores aritméticos
    public double calcularSubtotal() {
        return this.producto.getPrecio() * this.cantidad;
    }

    // ==========================================
    // GETTERS Y SETTERS
    // ==========================================
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Producto getProducto() { return producto; }
    public void setProducto(Producto producto) { this.producto = producto; }

    public int getQuantity() { return cantidad; }
    public void setQuantity(int cantidad) { this.cantidad = cantidad; }
}