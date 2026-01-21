package com.cafeteria.cafeteria_app.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private int numero;
    private LocalDateTime fecha;
    private List<DetallePedido> detalles = new ArrayList<>();

    public Pedido(int numero) {
        this.numero = numero;
        this.fecha = LocalDateTime.now();
    }

    public void agregarDetalle(DetallePedido detalle) {
        detalles.add(detalle);
    }

    public int getNumero() {
        return numero;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public List<DetallePedido> getDetalles() {
        return detalles;
    }

    public double getSubtotal() {
        double subtotal = 0;
        for (DetallePedido d : detalles) {
            subtotal += d.getSubtotal();
        }
        return subtotal;
    }
}
