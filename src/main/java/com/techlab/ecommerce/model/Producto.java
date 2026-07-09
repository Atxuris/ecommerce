package com.techlab.ecommerce.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

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
    
    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre; 

    @NotNull(message = "El precio es obligatorio")
    @Min(value = 0, message = "El precio no puede ser negativo")
    private double precio; 
    
    @NotNull(message = "El stock es obligatorio")
    @Min(value = 0, message = "El stock no puede ser negativo")
    private int stock;  

    @NotBlank(message = "La descripción no puede estar vacía")
    private String descripcion;
    private String categoria;
    private String imagenUrl;   

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

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }


    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getImagenUrl() { return imagenUrl; }
    public void setImagenUrl(String imagenUrl) { this.imagenUrl = imagenUrl; }



}