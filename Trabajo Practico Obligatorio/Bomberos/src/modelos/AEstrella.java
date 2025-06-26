package modelos;

import interfaces.IAEstrella; // Se importa la interfaz IAEstrella que define el método encontrarRuta

import java.util.*; // Se importan las clases necesarias para manejar listas, mapas y colas de prioridad

public class AEstrella implements IAEstrella {

    // Heurística: distancia euclídea
    private double heuristica(Nodo a, Nodo b) { // Método privado que calcula la distancia euclidiana entre dos nodos
        double dx = a.getX() - b.getX(); // diferencia en las coordenadas x
        double dy = a.getY() - b.getY(); // diferencia en las coordenadas y
        return Math.sqrt(dx * dx + dy * dy); // calcular la raíz cuadrada de la suma de los cuadrados de las diferencias

        // Lo que hace la heuristica es calcular la distancia entre dos nodos en un
        // grafo, utilizando las coordenadas x e y de cada nodo.
        // Se necesitan las 2 diferencias, una en x y otra en y, para poder calcular la
        // distancia euclidiana entre los dos nodos.
        // y la raiz cuadrada se utiliza para obtener la distancia real entre los dos
        // puntos en el espacio bidimensional.

    }

    @Override
    public List<Nodo> encontrarRuta(Nodo inicio, Nodo fin) { // Método que implementa el algoritmo A* para encontrar la
                                                             // ruta más corta entre dos nodos
        Map<Nodo, Nodo> cameFrom = new HashMap<>(); // Mapa para rastrear el camino recorrido, donde la clave es el nodo
                                                    // actual y el valor es el nodo anterior en el camino
        // El cameFrom se utiliza para rastrear el camino recorrido, lo que permite al
        // algoritmo A* reconstruir la ruta más corta una vez que se ha encontrado el
        // nodo final.

        Map<Nodo, Double> gScore = new HashMap<>(); // Mapa que almacena el costo acumulado desde el nodo de inicio
                                                    // hasta cada nodo, donde la clave es el nodo y el valor es el costo
        // El gScore se utiliza para almacenar el costo acumulado desde el nodo de
        // inicio hasta cada nodo, lo que permite al algoritmo A* evaluar la ruta más
        // corta.

        Map<Nodo, Double> fScore = new HashMap<>(); // Mapa que almacena el costo estimado total desde el nodo de inicio
                                                    // hasta el nodo final a través de cada nodo, donde la clave es el
                                                    // nodo y el valor es el costo estimado
        // El fScore se utiliza para almacenar el costo estimado total desde el nodo de
        // inicio hasta el nodo final a través de cada nodo, lo que permite al algoritmo
        // A* evaluar la ruta más corta.

        PriorityQueue<Nodo> abiertos = new PriorityQueue<>(Comparator.comparingDouble(fScore::get)); // Cola de
                                                                                                     // prioridad que
                                                                                                     // almacena los
                                                                                                     // nodos abiertos,
                                                                                                     // ordenados por su
                                                                                                     // fScore (costo
                                                                                                     // estimado total)
        // La cola de prioridad se utiliza para almacenar los nodos abiertos, lo que
        // permite al algoritmo A* seleccionar el nodo con el menor costo estimado en
        // cada iteración.

        gScore.put(inicio, 0.0); // Inicializa el costo acumulado desde el nodo de inicio a 0, esto se hace
                                 // porque el costo para llegar al nodo de inicio es cero, ya que no se ha
                                 // recorrido ningún camino.
        fScore.put(inicio, heuristica(inicio, fin)); // Inicializa el costo estimado total desde el nodo de inicio al
                                                     // nodo final utilizando la heurística, esto se hace para
                                                     // establecer un punto de partida para la evaluación del costo
                                                     // total.
        abiertos.add(inicio); // Agrega el nodo de inicio a la cola de prioridad de nodos abiertos

        while (!abiertos.isEmpty()) { // Verifica si hay nodos abiertos para procesar
            Nodo actual = abiertos.poll(); // Extrae el nodo con el menor fScore de la cola de prioridad, este es el
                                           // nodo actual que se está evaluando en esta iteración del algoritmo A*.

            if (actual.equals(fin)) { // Si el nodo actual es el nodo final, se ha encontrado la ruta más corta
                return reconstruirCamino(cameFrom, actual); // Reconstruye el camino desde el nodo final hasta el nodo
                                                            // de inicio utilizando el mapa cameFrom
            }

            for (Map.Entry<Nodo, Double> vecino : actual.getVecinos().entrySet()) { // Por cada vecino del nodo actual,
                                                                                    // se itera sobre los nodos vecinos
                                                                                    // y sus pesos (distancias), esto
                                                                                    // permite evaluar los nodos
                                                                                    // adyacentes al nodo actual para
                                                                                    // encontrar la ruta más corta.
                Nodo v = vecino.getKey(); // Obtener el vecino del nodo actual
                double peso = vecino.getValue(); // Obtener el peso (distancia) de la arista que conecta el nodo actual
                                                 // con el vecino
                double tentativeG = gScore.getOrDefault(actual, Double.MAX_VALUE) + peso; // Calcular el costo acumulado
                                                                                          // tentativo desde el nodo de
                                                                                          // inicio hasta el vecino a
                                                                                          // través del nodo actual

                if (tentativeG < gScore.getOrDefault(v, Double.MAX_VALUE)) { // Si el costo acumulado tentativo es menor
                                                                             // que el costo acumulado actual para el
                                                                             // vecino
                    cameFrom.put(v, actual); // Actualiza el mapa cameFrom para indicar que el nodo actual es el nodo
                                             // anterior del vecino en la ruta más corta
                    gScore.put(v, tentativeG); // Actualiza el costo acumulado para el vecino con el costo tentativo
                                               // calculado
                    fScore.put(v, tentativeG + heuristica(v, fin)); // Calcula el costo estimado total para el vecino
                                                                    // sumando el costo acumulado tentativo y la
                                                                    // heurística desde el vecino al nodo final
                    if (!abiertos.contains(v)) { // Si el vecino no está en la cola de prioridad de nodos abiertos
                        abiertos.add(v); // Agrega el vecino a la cola de prioridad para ser procesado en futuras
                                         // iteraciones
                    }
                }
            }
        }

        return Collections.emptyList(); // Si no se encuentra una ruta, devuelve una lista vacía
    }

    private List<Nodo> reconstruirCamino(Map<Nodo, Nodo> cameFrom, Nodo actual) { // Método que reconstruye el camino
                                                                                  // desde el nodo final hasta el nodo
                                                                                  // de inicio utilizando el mapa
                                                                                  // cameFrom
        List<Nodo> camino = new ArrayList<>(); // Lista para almacenar el camino reconstruido
        camino.add(actual); // Agrega el nodo actual (final) al camino
        while (cameFrom.containsKey(actual)) { // Mientras haya nodos anteriores en el mapa cameFrom
            actual = cameFrom.get(actual); // Obtiene el nodo anterior del nodo actual
            camino.add(actual); // Agrega el nodo anterior al camino reconstruido
        }
        Collections.reverse(camino); // Invierte el camino para que vaya desde el nodo de inicio hasta el nodo final
        return camino; // Devuelve el camino reconstruido desde el nodo de inicio hasta el nodo final
    }
}
