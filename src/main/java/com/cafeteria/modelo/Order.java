package com.cafeteria.modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int numeroPedido;
    private LocalDateTime fecha;
    private List<OrderItem> items;

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

    public double calcularTotal() {
        return calcularSubtotal();
    }

    public String generarFactura() {
        StringBuilder factura = new StringBuilder();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        
        factura.append("========================================\n");
        factura.append("         FACTURA DE PEDIDO\n");
        factura.append("========================================\n");
        factura.append(String.format("Pedido #: %d%n", numeroPedido));
        factura.append(String.format("Fecha: %s%n", fecha.format(formatter)));
        factura.append("========================================\n");
        factura.append("DETALLE DE PRODUCTOS:\n");
        factura.append("----------------------------------------\n");
        
        for (OrderItem item : items) {
            factura.append(String.format("%-20s x%d  $%.2f%n",
                item.getProducto().getNombre(),
                item.getCantidad(),
                item.calcularSubtotal()));
        }
        
        factura.append("========================================\n");
        factura.append(String.format("Subtotal:          $%.2f%n", calcularSubtotal()));
        factura.append(String.format("TOTAL:             $%.2f%n", calcularTotal()));
        factura.append("========================================\n");
        
        return factura.toString();
    }
}
