package flyweight;

import java.awt.*;
import java.awt.Graphics;

/**
 * Interfaz que define el contrato para las figuras que se pueden dibujar.
 * Esta interfaz representa el Flyweight en el patrón Flyweight.
 * Declara el método para realizar una operación con el estado extrínseco.
 */
public interface Figura {
    
    /**
     * Método para dibujar la figura en el contexto gráfico.
     * Los parámetros g, x, y, y size representan el estado extrínseco de la figura,
     * que será proporcionado por el cliente en tiempo de ejecución.
     *
     * @param g    El contexto gráfico en el que dibujar.
     * @param x    La coordenada x para dibujar la figura.
     * @param y    La coordenada y para dibujar la figura.
     * @param size El tamaño de la figura.
     * @param color El color de la figura.
     */
    void dibujar(Graphics g, int x, int y, int size, Color color);
}