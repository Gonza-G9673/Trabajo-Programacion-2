package modelos;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;

public class GrafoViewer extends JPanel {

    // GrafoViewer es una clase que extiende JPanel y se encarga de visualizar un
    // grafo
    // Jpanel es un componente de Swing que permite dibujar gráficos y manejar
    // eventos
    // Esta clase se utiliza para mostrar el grafo de bomberos y el camino
    // encontrado por el algoritmo A*
    // Awt y Swing son bibliotecas de Java para crear interfaces gráficas de usuario
    // (GUI)

    private final Grafo grafo;
    private final List<Nodo> camino;

    public GrafoViewer(Grafo grafo, List<Nodo> camino) {
        this.grafo = grafo;
        this.camino = camino;
        setPreferredSize(new Dimension(600, 600));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibujar aristas (calles)
        for (Nodo nodo : grafo.getNodos()) {
            int x1 = (int) nodo.getX() * 80 + 50;
            int y1 = (int) nodo.getY() * 80 + 50;

            for (Map.Entry<Nodo, Double> entry : nodo.getVecinos().entrySet()) {
                Nodo vecino = entry.getKey();
                int x2 = (int) vecino.getX() * 80 + 50;
                int y2 = (int) vecino.getY() * 80 + 50;

                // ¿Es parte del camino?
                boolean esCamino = esParteDelCamino(nodo, vecino);

                g.setColor(esCamino ? Color.RED : Color.GRAY);
                g.drawLine(x1, y1, x2, y2);

                // Mostrar peso
                String peso = String.valueOf(entry.getValue());
                g.setColor(Color.BLACK);
                g.drawString(peso, (x1 + x2) / 2, (y1 + y2) / 2);
            }

        }

        // Dibujar nodos
        for (Nodo nodo : grafo.getNodos()) {
            int x = (int) nodo.getX() * 80 + 50;
            int y = (int) nodo.getY() * 80 + 50;
            g.setColor(Color.BLUE);
            g.fillOval(x - 10, y - 10, 20, 20);
            g.setColor(Color.BLACK);
            g.drawString(nodo.getNombre(), x - 5, y + 5);
        }
    }

    private boolean esParteDelCamino(Nodo a, Nodo b) {
        for (int i = 0; i < camino.size() - 1; i++) {
            Nodo actual = camino.get(i);
            Nodo siguiente = camino.get(i + 1);
            if ((actual == a && siguiente == b) || (actual == b && siguiente == a)) {
                return true;
            }
        }
        return false;
    }

    public static void mostrar(Grafo grafo, Nodo origen, Nodo destino) {
        AEstrella aEstrella = new AEstrella();
        List<Nodo> camino = aEstrella.encontrarRuta(origen, destino);

        JFrame frame = new JFrame("Grafo de Bomberos - A*");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new GrafoViewer(grafo, camino));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
