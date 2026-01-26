package com.cafeteria.componente;

import com.cafeteria.modelo.Order;
import com.cafeteria.servicio.OrderService;
import com.cafeteria.servicio.ProductService;
import com.cafeteria.servicio.SalesService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MenuComponent implements CommandLineRunner {
    
    private final ProductService productService;
    private final OrderService orderService;
    private final SalesService salesService;

    public MenuComponent(ProductService productService, 
                        OrderService orderService, 
                        SalesService salesService) {
        this.productService = productService;
        this.orderService = orderService;
        this.salesService = salesService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        mostrarBienvenida();

        while (continuar) {
            mostrarMenuPrincipal();
            String opcion = scanner.nextLine().trim();

            switch (opcion) {
                case "1":
                    verMenuProductos();
                    break;
                case "2":
                    crearNuevoPedido(scanner);
                    break;
                case "3":
                    verResumenVentas();
                    break;
                case "4":
                    continuar = false;
                    mostrarDespedida();
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }

        scanner.close();
    }

    private void mostrarBienvenida() {
        System.out.println("\n");
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║                                        ║");
        System.out.println("║   SISTEMA DE GESTIÓN DE CAFETERÍA     ║");
        System.out.println("║                                        ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println();
    }

    private void mostrarMenuPrincipal() {
        System.out.println("========================================");
        System.out.println("           MENÚ PRINCIPAL");
        System.out.println("========================================");
        System.out.println("1. Ver menú de productos");
        System.out.println("2. Crear pedido");
        System.out.println("3. Ver resumen de ventas");
        System.out.println("4. Salir del sistema");
        System.out.println("========================================");
        System.out.print("Seleccione una opción: ");
    }

    private void verMenuProductos() {
        productService.mostrarMenu();
    }

    private void crearNuevoPedido(Scanner scanner) {
        try {
            Order pedido = orderService.crearPedido(scanner);
            
            if (pedido.getItems().isEmpty()) {
                System.out.println(" El pedido no tiene productos. No se registrará.");
                return;
            }
            
            salesService.registrarPedido(pedido);
            orderService.imprimirFactura(pedido);
            
            System.out.println("✓ Pedido registrado exitosamente.");
            
        } catch (Exception e) {
            System.out.println("Error al crear el pedido: " + e.getMessage());
        }
    }

    private void verResumenVentas() {
        salesService.mostrarResumen();
    }

    private void mostrarDespedida() {
        System.out.println("========================================");
        System.out.println("   Gracias por usar nuestro sistema");
        System.out.println("          ¡Hasta pronto!");
        System.out.println("========================================");
    }
}
