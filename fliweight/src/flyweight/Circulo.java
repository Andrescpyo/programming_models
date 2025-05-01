package flyweight;

import java.awt.Graphics;
import java.awt.Color;

/**
 * Implementación concreta de la interfaz Figura para representar un círculo.
 * Esta clase actúa como un ConcreteFlyweight en el patrón Flyweight.
 */
public class Circulo implements Figura {
    
    /**
     * Dibuja el círculo en el contexto gráfico proporcionado.
     * Los parámetros x, y, y size son el estado extrínseco, proporcionado por el cliente.
     *
     * @param g    El contexto gráfico en el que dibujar.
     * @param x    La coordenada x del centro del círculo.
     * @param y    La coordenada y del centro del círculo.
     * @param size El tamaño (diámetro) del círculo.
     * @param color El color del círculo.
     */
    @Override
    public void dibujar(Graphics g, int x, int y, int size, Color color) {
        g.setColor(color);
        g.fillOval(x, y, size, size);
    }
}