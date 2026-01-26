package com.cafeteria.servicio;

import com.cafeteria.modelo.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SalesService {
    
    private final List<Order> pedidosRealizados;

    public SalesService() {
        this.pedidosRealizados = new ArrayList<>();
    }

    public void registrarPedido(Order pedido) {
        pedidosRealizados.add(pedido);
    }

    public int obtenerCantidadPedidos() {
        return pedidosRealizados.size();
    }

    public double calcularTotalVendido() {
        return pedidosRealizados.stream()
                .mapToDouble(Order::calcularTotal)
                .sum();
    }

    public void mostrarResumen() {
        System.out.println("========================================");
        System.out.println("         RESUMEN DE VENTAS");
        System.out.println("========================================");
        System.out.println("Total de pedidos: " + obtenerCantidadPedidos());
        System.out.println(String.format("Total vendido: $%.2f", calcularTotalVendido()));
        System.out.println("========================================");
    }

    public List<Order> obtenerTodosLosPedidos() {
        return new ArrayList<>(pedidosRealizados);
    }
}
