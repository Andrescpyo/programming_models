package flyweight;

import java.awt.Graphics;
import java.awt.Color;

/**
 * Implementación concreta de la interfaz Figura para representar un triángulo.
 * Esta clase actúa como un ConcreteFlyweight en el patrón Flyweight.
 */
public class Triangulo implements Figura {
    
    /**
     * Dibuja el triángulo en el contexto gráfico proporcionado.
     * Los parámetros x, y, y size son el estado extrínseco, proporcionado por el cliente.
     *
     * @param g    El contexto gráfico en el que dibujar.
     * @param x    La coordenada x del punto base izquierdo del triángulo.
     * @param y    La coordenada y del punto más alto del triángulo.
     * @param size El tamaño del triángulo (determina la posición de los otros vértices).
     * @param color El color del triángulo.
     */
    @Override
    public void dibujar(Graphics g, int x, int y, int size, Color color) {
        g.setColor(color);
        int[] xPoints = { x, x + size / 2, x + size };
        int[] yPoints = { y + size, y, y + size };
        g.fillPolygon(xPoints, yPoints, 3);
    }
}