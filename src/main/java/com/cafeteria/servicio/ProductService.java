package com.cafeteria.servicio;

import com.cafeteria.modelo.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    
    private final List<Product> menuProductos;

    public ProductService() {
        this.menuProductos = new ArrayList<>();
        inicializarMenu();
    }

    private void inicializarMenu() {
        menuProductos.add(new Product("C001", "Café Americano", 3500.0));
        menuProductos.add(new Product("C002", "Café Latte", 4500.0));
        menuProductos.add(new Product("C003", "Capuchino", 4800.0));
        menuProductos.add(new Product("C004", "Expresso", 3000.0));
        menuProductos.add(new Product("P001", "Croissant", 3200.0));
        menuProductos.add(new Product("P002", "Sandwich", 6500.0));
    }

    public List<Product> obtenerTodosLosProductos() {
        return new ArrayList<>(menuProductos);
    }

    public Optional<Product> buscarProductoPorCodigo(String codigo) {
        return menuProductos.stream()
                .filter(p -> p.getCodigo().equalsIgnoreCase(codigo))
                .findFirst();
    }

    public void mostrarMenu() {
        System.out.println("========================================");
        System.out.println("          MENÚ DE PRODUCTOS");
        System.out.println("========================================");
        for (Product producto : menuProductos) {
            System.out.println(producto);
        }
        System.out.println("========================================");
    }

    public boolean existeProducto(String codigo) {
        return buscarProductoPorCodigo(codigo).isPresent();
    }
}
