package com.cafeteria.modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int numeroPedido;
    private LocalDateTime fecha;
    private List<OrderItem> items;
    private static final double PORCENTAJE_IMPUESTO = 0.10;

    public Order(int numeroPedido) {
        this.numeroPedido = numeroPedido;
        this.fecha = LocalDateTime.now();
        this.items = new ArrayList<>();
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void agregarItem(OrderItem item) {
        this.items.add(item);
    }

    public double calcularSubtotal() {
        return items.stream()
                .mapToDouble(OrderItem::calcularSubtotal)
                .sum();
    }

    public double calcularImpuesto() {
        return calcularSubtotal() * PORCENTAJE_IMPUESTO;
    }

    public double calcularTotal() {
        return calcularSubtotal() + calcularImpuesto();
    }

    public String generarFactura() {
        StringBuilder factura = new StringBuilder();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        
        factura.append("========================================");
        factura.append("         FACTURA DE PEDIDO");
        factura.append("========================================");
        factura.append(String.format("Pedido #: %d", numeroPedido));
        factura.append(String.format("Fecha: %s", fecha.format(formatter)));
        factura.append("========================================");
        factura.append("DETALLE DE PRODUCTOS:");
        factura.append("----------------------------------------");
        
        for (OrderItem item : items) {
            factura.append(String.format("%-20s x%d  $%.2f",
                item.getProducto().getNombre(),
                item.getCantidad(),
                item.calcularSubtotal()));
        }
        
        factura.append("========================================");
        factura.append(String.format("Subtotal:          $%.2f", calcularSubtotal()));
        factura.append(String.format("Impuesto (10%%):    $%.2f", calcularImpuesto()));
        factura.append(String.format("TOTAL:             $%.2f", calcularTotal()));
        factura.append("========================================");
        
        return factura.toString();
    }
}
