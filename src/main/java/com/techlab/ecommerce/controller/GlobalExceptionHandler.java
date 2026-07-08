package com.techlab.ecommerce.controller;

import com.techlab.ecommerce.exception.StockInsuficienteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@CrossOrigin(origins = "*") // <-- Aquí queda CORS configurado para aceptar peticiones de cualquier origen
public class GlobalExceptionHandler {

    @ExceptionHandler(StockInsuficienteException.class)
    public ResponseEntity<Map<String, Object>> manejarStockInsuficiente(StockInsuficienteException ex) {
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", HttpStatus.BAD_REQUEST.value());
        respuesta.put("error", "Bad Request");
        respuesta.put("message", ex.getMessage());
        respuesta.put("path", "/api/pedidos");

        return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
    }
}