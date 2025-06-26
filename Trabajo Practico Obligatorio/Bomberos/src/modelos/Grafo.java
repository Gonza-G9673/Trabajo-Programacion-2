package modelos;

import interfaces.IGrafo;
import java.util.*;

public class Grafo implements IGrafo { // Implementación de la interfaz IGrafo
    private List<Nodo> nodos; // Lista de nodos que componen el grafo

    public Grafo() { // Constructor de la clase Grafo
        this.nodos = new ArrayList<>(); // Inicializa la lista de nodos
    }

    public void agregarNodo(Nodo nodo) { // Método para agregar un nodo al grafo
        nodos.add(nodo);
    }

    public void conectar(Nodo origen, Nodo destino, double peso) { // Método para conectar dos nodos con una arista de
                                                                   // peso dado
        origen.agregarVecino(destino, peso); // grafo dirigido
        destino.agregarVecino(origen, peso); // grafo no dirigido
    }

    public List<Nodo> getNodos() {
        return nodos;
    }
}
