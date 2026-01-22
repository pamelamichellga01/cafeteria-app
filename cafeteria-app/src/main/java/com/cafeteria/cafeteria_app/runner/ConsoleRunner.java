package com.cafeteria.cafeteria_app.runner;

import com.cafeteria.cafeteria_app.model.Producto;
import com.cafeteria.cafeteria_app.service.ProductoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final ProductoService productoService;
    private final Scanner scanner;

    public ConsoleRunner(ProductoService productoService, Scanner scanner) {
        this.productoService = productoService;
        this.scanner = scanner;
    }

    @Override
    public void run(String... args) {
        boolean continuar = true;
        while (continuar) {
            mostrarMenuPrincipal();
            int opcion = leerEntero("Seleccione una opción: ");
            switch (opcion) {
                case 1:
                    mostrarMenuProductos();
                    break;
                case 2:
                    continuar = false;
                    System.out.println("Saliendo del sistema. Hasta pronto.");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    private void mostrarMenuPrincipal() {
        System.out.println();
        System.out.println("=== CAFETERÍA ===");
        System.out.println("1. Ver menú de productos");
        System.out.println("2. Salir del sistema");
    }

    private void mostrarMenuProductos() {
        System.out.println();
        System.out.println("=== MENÚ DE PRODUCTOS ===");
        for (Producto producto : productoService.obtenerProductos()) {
            String linea = String.format("%s - %s - $%.2f",
                    producto.getCodigo(),
                    producto.getNombre(),
                    producto.getPrecio());
            System.out.println(linea);
        }
    }

    private int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine().trim();
            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException ex) {
                System.out.println("Entrada inválida. Use un número.");
            }
        }
    }
}
