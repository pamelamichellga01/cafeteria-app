package com.cafeteria.cafeteria_app.service;

import com.cafeteria.cafeteria_app.model.Producto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    private final List<Producto> productos;

    public ProductoService(List<Producto> productos) {
        this.productos = List.copyOf(productos);
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
