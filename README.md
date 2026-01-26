📦 Control de Pedidos – Spring Boot (Consola)

📌 Descripción del proyecto

Este proyecto es una aplicación de consola desarrollada en Spring Boot que simula el funcionamiento básico de un sistema de control de pedidos para una cafetería o restaurante.

El objetivo principal es aplicar correctamente los conceptos de:

Dependencias entre clases

Inyección de dependencias por constructor

Java Beans administrados por Spring

Separación de responsabilidades

Uso de CommandLineRunner



---

🎯 Objetivo general

Desarrollar una aplicación de consola en Spring Boot que permita la gestión básica de pedidos, cumpliendo con las restricciones técnicas y de diseño establecidas en el taller.


---

⚙️ Tecnologías utilizadas

Java 17+

Spring Boot

Maven

Consola (System.out.println / Scanner)



---

🧩 Funcionalidades del sistema

La aplicación permite:

1. Visualizar el menú de productos disponibles.


2. Crear pedidos seleccionando productos y cantidades.


3. Calcular subtotales, impuestos y total final.


4. Imprimir una factura legible en consola.


5. Registrar múltiples pedidos durante la ejecución.


6. Mostrar un resumen general de ventas.




---

📋 Requerimientos funcionales

RF1. Menú principal

Opciones disponibles:

Ver menú de productos

Crear pedido

Ver resumen de ventas

Salir del sistema


RF2. Menú de productos

Catálogo con mínimo 6 productos, cada uno con:

Código

Nombre

Precio


RF3. Creación de pedidos

El usuario puede:

Seleccionar productos por código

Indicar cantidades

Agregar múltiples productos a un mismo pedido


RF4. Cálculo de valores

El sistema calcula:

Subtotal por producto

Subtotal general

Impuesto o servicio (ej. 10%)

Total final


RF5. Factura

Al finalizar un pedido se imprime una factura con:

Número de pedido

Fecha

Detalle de productos

Subtotal

Impuesto

Total


RF6. Resumen de ventas

Cantidad total de pedidos realizados

Total vendido acumulado



---

🧠 Requerimientos de diseño (obligatorios)

Todas las clases de negocio son beans administrados por Spring.

La inyección de dependencias se realiza únicamente por constructor.

No se permite el uso de new dentro de servicios o componentes.

El método main solo arranca Spring Boot.

El flujo principal se ejecuta mediante CommandLineRunner.



---

🗂️ Estructura del proyecto (sugerida)

com.example.controlpedidos
│
├── model        # Clases de dominio (Producto, Pedido, DetallePedido)
├── service      # Lógica de negocio
├── component    # Componentes de consola (menú, entrada de datos)
├── runner       # Clase que implementa CommandLineRunner
└── ControlPedidosApplication.java


---

▶️ Ejecución del proyecto

1. Clonar el repositorio:



git clone <URL_DEL_REPOSITORIO>

2. Abrir el proyecto en un IDE (IntelliJ / Eclipse).


3. Ejecutar la clase principal:



ControlPedidosApplication.java

4. Interactuar con el sistema desde la consola.




---

🎤 Entregables

Entregable 1 – Código fuente

Proyecto Spring Boot funcional

Código organizado por paquetes

Uso correcto de beans e inyección de dependencias


Entregable 2 – Presentación oral

Video: https://drive.google.com/file/d/1ybW3LsMP5FDOJjf8d0gLhkVVg3CgTzf4/view?usp=sharing

Duración: 5 a 8 minutos

Debe responder:

1. ¿Qué dependencias existen entre las clases del proyecto?


2. ¿Qué clases fueron definidas como beans y por qué?




---

✍️ Autor

Maria Contreras
Taller No. 1 – Dependencias e Inyección de Dependencias


---

✅ Proyecto desarrollado con fines académicos.
