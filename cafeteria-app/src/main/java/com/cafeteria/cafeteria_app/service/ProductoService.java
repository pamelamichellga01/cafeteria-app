package com.cafeteria.cafeteria_app.service;

import com.cafeteria.cafeteria_app.model.Producto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService {

    private List<Producto> productos = new ArrayList<>();

    public ProductoService() {
        productos.add(new Producto("PO1", "Café Americano", 3000));
        productos.add(new Producto("P02","Café Latte", 3500));
        productos.add(new Producto("P03", "Capuchino", 4000 ));
        productos.add(new Producto("P04", "Té", 2500));
        productos.add(new Producto("P05", "Pan", 2000 ));
        productos.add(new Producto("P06", "Pastel", 4500));
    }

    public List<Producto> obtenerProductos() {
        return productos;
    }

    public Producto obtenerProductoPorCodigo(String codigo) {
        for (Producto p : productos) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                return p;
            }
        }
        return null;
    }
}
