package com.techlab.ecommerce.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Un Pedido tiene muchas líneas. "cascade = CascadeType.ALL" hace que al guardar 
    // el pedido se guarden automáticamente todas sus líneas en la base de datos.
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pedido_id") // Une las tablas en la Base de Datos
    private List<LineaPedido> lineas = new ArrayList<>(); // Aplicamos Colecciones/Listas

    private double total;

    public Pedido() {
    }

    
    public void calcularTotal() {
        double suma = 0;
        // Recorremos la colección (Lista) usando un bucle for-each
        for (LineaPedido linea : lineas) {
            suma += linea.calcularSubtotal(); // Operador aritmético de suma
        }
        this.total = suma;
    }

    // Método útil para agregar líneas al pedido de forma controlada
    public void agregarLinea(LineaPedido linea) {
        this.lineas.add(linea);
    }

    // ==========================================
    // GETTERS Y SETTERS
    // ==========================================
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public List<LineaPedido> getLineas() { return lineas; }
    public void setLineas(List<LineaPedido> lineas) { this.lineas = lineas; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
}