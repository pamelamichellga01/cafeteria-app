package com.cafeteria.cafeteria_app.config;

import com.cafeteria.cafeteria_app.model.DetallePedido;
import com.cafeteria.cafeteria_app.model.Pedido;
import com.cafeteria.cafeteria_app.model.Producto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Configuration
public class AppConfig {

    @Bean
    public Producto productoAmericano() {
        return new Producto("P01", "Café Americano", 3000);
    }

    @Bean
    public Producto productoLatte() {
        return new Producto("P02", "Café Latte", 3500);
    }

    @Bean
    public Producto productoCapuchino() {
        return new Producto("P03", "Capuchino", 4000);
    }

    @Bean
    public Producto productoTe() {
        return new Producto("P04", "Té", 2500);
    }

    @Bean
    public Producto productoPan() {
        return new Producto("P05", "Pan", 2000);
    }

    @Bean
    public Producto productoPastel() {
        return new Producto("P06", "Pastel", 4500);
    }

    @Bean
    public List<Pedido> pedidos() {
        return new ArrayList<>();
    }

    @Bean
    @Scope("prototype")
    public List<DetallePedido> detallesPedido() {
        return new ArrayList<>();
    }

    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }

    @Bean
    public DateTimeFormatter dateTimeFormatter() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    }
}
