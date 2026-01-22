package com.cafeteria.cafeteria_app.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@Scope("prototype")
public class Pedido {

    private int numero;
    private LocalDateTime fecha;
    private List<DetallePedido> detalles;

    public Pedido() {
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public void setDetalles(List<DetallePedido> detalles) {
        this.detalles = detalles;
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
        if (detalles != null) {
            for (DetallePedido d : detalles) {
                subtotal += d.getSubtotal();
            }
        }
        return subtotal;
    }
}
