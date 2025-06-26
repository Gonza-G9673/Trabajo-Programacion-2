package interfaces;

import modelos.Nodo; //Se importan la clase Nodo que representa los nodos del grafo
import java.util.List; // Se importan las listas de nodos que se utilizarán en el algoritmo A* para encontrar la ruta más corta

public interface IAEstrella {
    List<Nodo> encontrarRuta(Nodo origen, Nodo destino); // Método para encontrar la ruta más corta entre dos nodos
                                                         // utilizando el algoritmo A*
}
