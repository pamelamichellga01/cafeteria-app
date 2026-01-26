package com.cafeteria.servicio;

import com.cafeteria.modelo.Order;
import com.cafeteria.modelo.OrderItem;
import com.cafeteria.modelo.Product;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class OrderService {
    
    private final ProductService productService;
    private int contadorPedidos;

    public OrderService(ProductService productService) {
        this.productService = productService;
        this.contadorPedidos = 0;
    }

    public Order crearPedido(Scanner scanner) {
        contadorPedidos++;
        Order pedido = new Order(contadorPedidos);
        
        System.out.println("========================================");
        System.out.println("       CREANDO PEDIDO #" + contadorPedidos);
        System.out.println("========================================");
        
        boolean agregarMasProductos = true;
        
        while (agregarMasProductos) {
            productService.mostrarMenu();
            
            System.out.print("Ingrese el código del producto: ");
            String codigo = scanner.nextLine().trim();
            
            Product producto = productService.buscarProductoPorCodigo(codigo).orElse(null);
            
            if (producto == null) {
                System.out.println("Producto no encontrado. Intente nuevamente.");
                continue;
            }
            
            System.out.print("Ingrese la cantidad: ");
            int cantidad = Integer.parseInt(scanner.nextLine().trim());
            
            OrderItem item = new OrderItem(producto, cantidad);
            pedido.agregarItem(item);
            
            System.out.println("✓ Producto agregado: " + producto.getNombre() + " x" + cantidad);
            
            System.out.print("¿Desea agregar otro producto? (S/N): ");
            String respuesta = scanner.nextLine().trim();
            agregarMasProductos = respuesta.equalsIgnoreCase("S");
        }
        
        return pedido;
    }

    public void imprimirFactura(Order pedido) {
        System.out.println(pedido.generarFactura());
    }
}
