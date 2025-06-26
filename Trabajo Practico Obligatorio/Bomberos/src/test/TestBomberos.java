package test;

import modelos.AEstrella;
import interfaces.IAEstrella;
import modelos.Grafo;
import modelos.GrafoViewer;
import modelos.Nodo;
import java.util.List;
// Se importan todas las clases necesarias para el test de los bomberos

public class TestBomberos {
    public static void main(String[] args) { // Método principal para ejecutar el test de los bomberos

        Nodo estacion = new Nodo("Estación", 1, 1);
        Nodo A = new Nodo("Calle A", 3, 4);
        Nodo B = new Nodo("Calle B", 5, 2);
        Nodo C = new Nodo("Calle C", 6, 5);
        Nodo D = new Nodo("Calle D", 0, 3);
        Nodo E = new Nodo("Calle E", 4, 6);
        Nodo F = new Nodo("Calle F", 7, 3);
        Nodo G = new Nodo("Calle G", 3, 7);
        Nodo H = new Nodo("Calle H", 6, 4);
        // Se crean los nodos que representan las calles y la estación de bomberos con
        // cada valor de cordenada x e y, correspondiente, siendo estas el valor de
        // heuristica,
        // que se utiliza para calcular la distancia entre los nodos en el algoritmo A*.
        Nodo incendio = new Nodo("Incendio", 8, 1);
        Grafo ciudad = new Grafo();
        ciudad.agregarNodo(estacion);
        ciudad.agregarNodo(A);
        ciudad.agregarNodo(B);
        ciudad.agregarNodo(C);
        ciudad.agregarNodo(D);
        ciudad.agregarNodo(E);
        ciudad.agregarNodo(F);
        ciudad.agregarNodo(G);
        ciudad.agregarNodo(H);
        ciudad.agregarNodo(incendio);
        // Se crea un grafo que representa la ciudad

        ciudad.conectar(estacion, A, 3);
        ciudad.conectar(estacion, B, 6);
        ciudad.conectar(estacion, D, 4);
        ciudad.conectar(A, C, 4);
        ciudad.conectar(B, A, 2);
        ciudad.conectar(G, A, 1);
        ciudad.conectar(D, G, 3);
        ciudad.conectar(G, H, 2);
        ciudad.conectar(H, F, 10);
        ciudad.conectar(B, D, 5);
        ciudad.conectar(F, incendio, 3);
        ciudad.conectar(B, F, 5);
        ciudad.conectar(E, B, 1);
        ciudad.conectar(A, E, 0);

        // Se crean todas las conexiones entre los nodos, representando las las calles
        // y las distancias entre ellas, que se utilizan como pesos en el algoritmo A*.

        IAEstrella algoritmo = new AEstrella();
        List<Nodo> ruta = algoritmo.encontrarRuta(estacion, incendio);

        System.out.println("Ruta más rápida para los bomberos:");
        for (Nodo nodo : ruta) {
            System.out.print(nodo + " -> ");
        }
        System.out.println("FIN");

        GrafoViewer.mostrar(ciudad, estacion, incendio);
    }
}
