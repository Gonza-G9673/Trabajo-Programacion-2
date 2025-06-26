package modelos;

public class Arista { // Clase que representa una arista en el grafo
    private Nodo origen; // nodo de inicio de la arista
    private Nodo destino; // nodo final de la arista
    private double peso; // peso de la arista, que puede representar la distancia entre los nodos

    public Arista(Nodo origen, Nodo destino, double peso) { // Constructor de la clase Arista
        this.origen = origen; // nodo de inicio
        this.destino = destino; // nodo final
        this.peso = peso; // peso de la arista
    }

    public Nodo getOrigen() {
        return origen;
    }

    public Nodo getDestino() {
        return destino;
    }

    public double getPeso() {
        return peso;
    }
}
