package interfaces;

import modelos.Nodo; // Se importan la clase Nodo que representa los nodos del grafo

public interface IGrafo {
    void agregarNodo(Nodo nodo); // Método para agregar un nodo al grafo

    void conectar(Nodo origen, Nodo destino, double peso); // Método para conectar dos nodos con una arista de peso dado
    // Nodo origen seria el nodo de inicio y destino el nodo final, peso es la
    // distancia entre ambos nodos
    // Es double porque puede ser un valor decimal, por ejemplo, si la distancia es
    // 3.5 km

}
