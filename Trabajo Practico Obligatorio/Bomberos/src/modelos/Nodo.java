package modelos;

import java.util.*;

public class Nodo {
    private String nombre; // nombre del nodo
    private double x, y; // Estas coordenadas representan la posición del nodo en un espacio
                         // bidimensional, simulando un mapa
    private Map<Nodo, Double> vecinos; // Mapa de vecinos del nodo, donde la clave es el nodo vecino y el valor es el
                                       // peso de la arista hacia ese vecino

    public Nodo(String nombre, double x, double y) { // Constructor de la clase Nodo
        this.nombre = nombre; // nombre del nodo
        this.x = x; // coordenada x del nodo
        this.y = y; // coordenada y del nodo
        this.vecinos = new HashMap<>(); // Inicializa el mapa de vecinos del nodo
    }

    public String getNombre() {
        return nombre;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Map<Nodo, Double> getVecinos() {
        return vecinos;
    }

    public void agregarVecino(Nodo vecino, double peso) { // Método para agregar un vecino al nodo con un peso dado
        vecinos.put(vecino, peso); // Esto agrega el vecino al mapa de vecinos del nodo, donde el peso representa
                                   // la distancia o costo para llegar a ese vecino
    }

    @Override
    public String toString() {
        return nombre;
    }
}
