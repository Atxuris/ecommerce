package com.techlab.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; 
    
    private String nombre; 
    private double precio; 
    private int stock;     

    // Constructor vacío
    public Producto() {
    }

    // Constructor con parámetros
    public Producto(String nombre, double precio, int stock) {
        // Usamos los setters acá también para que apliquen las validaciones al crear el objeto
        setNombre(nombre);
        setPrecio(precio);
        this.stock = stock;
    }

    // ==========================================
    // GETTERS Y SETTERS
    // ==========================================
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null) {
            this.nombre = "";
            return;
        }

        String nombreLimpio = nombre.trim();

        if (nombreLimpio.isEmpty()) {
            System.out.println("Error: El nombre no puede estar vacío.");
            return; 
        }

        if (nombreLimpio.matches(".*[0-9].*")) {
            System.out.println("Error: El nombre del producto no puede contener números.");
            return; 
        }

        this.nombre = nombreLimpio.toLowerCase();
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio >= 0) {
            this.precio = precio;
        } else {
            System.out.println("Error: El precio no puede ser negativo.");
        }
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}