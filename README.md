# 🤖 Proyecto Transformers - Álbum y Batallas (Java Swing)

Aplicación de escritorio desarrollada en **Java Swing** aplicando los conceptos fundamentales de **Programación Orientada a Objetos (POO)** como herencia, polimorfismo y encapsulamiento.

## 🚀 Características
- **Interfaz compacta:** Visualización limpia de 10 personajes (5 Autobots y 5 Decepticons) en una sola pantalla sin necesidad de barras de desplazamiento.
- **Jerarquía de Clases:** Estructura base orientada a objetos con clase abstracta `Personaje` y subclases `Jugador` y `Enemigo`.
- **Sistema de Batallas:** Selección manual entre personajes o modo de simulación aleatoria contra la CPU con registro de resultados.

## 🛠️ Tecnologías utilizadas
- **Lenguaje:** Java 
- **Librería gráfica:** Java Swing (javax.swing)
- **IDE sugerido:** NetBeans / IntelliJ IDEA

## 📌 Estructura del Código
- `Personaje.java`: Clase abstracta base.
- `Jugador.java`: Subclase para Autobots.
- `Enemigo.java`: Subclase para Decepticons.
- `TarjetaPersonaje.java`: Componente visual personalizado para las cartas.
- `AlbumPersonajes.java`: Ventana principal (JFrame) y controlador de eventos.
