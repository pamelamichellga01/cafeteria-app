package com.cafeteria.cafeteria_app.service;

import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {

    private static final double TASA_IMPUESTO = 0.10;

    public double calcularImpuesto(double subtotal) {
        return subtotal * TASA_IMPUESTO;
    }

    public double calcularTotal(double subtotal) {
        return subtotal + calcularImpuesto(subtotal);
    }
}
