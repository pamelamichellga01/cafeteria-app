package com.cafeteria.cafeteria_app.service;

import com.cafeteria.cafeteria_app.model.DetallePedido;
import com.cafeteria.cafeteria_app.model.Pedido;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;

@Service
public class FacturaService {

    private final CalculadoraService calculadoraService;
    private final DateTimeFormatter dateTimeFormatter;

    public FacturaService(CalculadoraService calculadoraService,
                          DateTimeFormatter dateTimeFormatter) {
        this.calculadoraService = calculadoraService;
        this.dateTimeFormatter = dateTimeFormatter;
    }

    public void imprimirFactura(Pedido pedido) {
        System.out.println("======================================");
        System.out.println("FACTURA - Pedido #" + pedido.getNumero());
        System.out.println("Fecha: " + pedido.getFecha().format(dateTimeFormatter));
        System.out.println("--------------------------------------");
        System.out.println("Detalle de productos:");

        for (DetallePedido detalle : pedido.getDetalles()) {
            String linea = String.format(
                    "%s x%d - $%.2f",
                    detalle.getProducto().getNombre(),
                    detalle.getCantidad(),
                    detalle.getSubtotal()
            );
            System.out.println(linea);
        }

        double subtotal = pedido.getSubtotal();
        double impuesto = calculadoraService.calcularImpuesto(subtotal);
        double total = calculadoraService.calcularTotal(subtotal);

        System.out.println("--------------------------------------");
        System.out.println(String.format("Subtotal: $%.2f", subtotal));
        System.out.println(String.format("Impuesto (10%%): $%.2f", impuesto));
        System.out.println(String.format("Total: $%.2f", total));
        System.out.println("======================================");
    }
}
