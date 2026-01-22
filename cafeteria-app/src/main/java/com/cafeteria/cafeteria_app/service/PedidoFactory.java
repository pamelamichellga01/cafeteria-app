package com.cafeteria.cafeteria_app.service;

import com.cafeteria.cafeteria_app.model.DetallePedido;
import com.cafeteria.cafeteria_app.model.Pedido;
import com.cafeteria.cafeteria_app.model.Producto;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class PedidoFactory {

    private final ApplicationContext context;

    public PedidoFactory(ApplicationContext context) {
        this.context = context;
    }

    public Pedido crearPedido(int numero) {
        Pedido pedido = context.getBean(Pedido.class);
        pedido.setNumero(numero);
        pedido.setFecha(LocalDateTime.now());
        pedido.setDetalles(context.getBean("detallesPedido", List.class));
        return pedido;
    }

    public DetallePedido crearDetalle(Producto producto, int cantidad) {
        DetallePedido detalle = context.getBean(DetallePedido.class);
        detalle.setProducto(producto);
        detalle.setCantidad(cantidad);
        return detalle;
    }
}
