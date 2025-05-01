package flyweight;

import java.awt.Graphics;
import java.awt.Color;

/**
 * Implementación concreta de la interfaz Figura para representar un cuadrado.
 * Esta clase actúa como un ConcreteFlyweight en el patrón Flyweight.
 */
public class Cuadrado implements Figura {  
   
    /**
     * Dibuja el cuadrado en el contexto gráfico proporcionado.
     * Los parámetros x, y, y size son el estado extrínseco, proporcionado por el cliente.
     *
     * @param g    El contexto gráfico en el que dibujar.
     * @param x    La coordenada x de la esquina superior izquierda del cuadrado.
     * @param y    La coordenada y de la esquina superior izquierda del cuadrado.
     * @param size El tamaño del lado del cuadrado.
     * @param color El color del cuadrado.
     */
    @Override
    public void dibujar(Graphics g, int x, int y, int size, Color color) {
        g.setColor(color);
        g.fillRect(x, y, size, size);
    }
}