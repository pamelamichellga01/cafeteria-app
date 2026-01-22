package com.cafeteria.cafeteria_app.service;

import com.cafeteria.cafeteria_app.model.Pedido;
import com.cafeteria.cafeteria_app.model.Producto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoFactory pedidoFactory;
    private final CalculadoraService calculadoraService;
    private final List<Pedido> pedidos;
    private int secuencia = 1;
    private double totalVentas = 0;

    public PedidoService(PedidoFactory pedidoFactory,
                         CalculadoraService calculadoraService,
                         List<Pedido> pedidos) {
        this.pedidoFactory = pedidoFactory;
        this.calculadoraService = calculadoraService;
        this.pedidos = pedidos;
    }

    public Pedido crearPedido() {
        return pedidoFactory.crearPedido(secuencia++);
    }

    public void agregarDetalle(Pedido pedido, Producto producto, int cantidad) {
        pedido.agregarDetalle(pedidoFactory.crearDetalle(producto, cantidad));
    }

    public void registrarPedido(Pedido pedido) {
        pedidos.add(pedido);
        double total = calculadoraService.calcularTotal(pedido.getSubtotal());
        totalVentas += total;
    }

    public int getCantidadPedidos() {
        return pedidos.size();
    }

    public double getTotalVentas() {
        return totalVentas;
    }
}
