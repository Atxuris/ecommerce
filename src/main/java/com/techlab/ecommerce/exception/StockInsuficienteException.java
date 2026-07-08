package com.techlab.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Esta anotación hace que si salta el error, Thunder Client muestre un código 400 (Bad Request)
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class StockInsuficienteException extends RuntimeException {
    public StockInsuficienteException(String mensaje) {
        super(mensaje);
    }
}