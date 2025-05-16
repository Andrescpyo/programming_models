package Bingo.Core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Card {
    private List<Integer> numbers; //Lista de números en el cartón
    private int rows;              //Número de filas del cartón
    private int cols;              //Número de columnas del cartón
    private boolean[][] marked;    //Matriz para rastrear los números marcados


    /**
     * Constructor de la clase Card.
     * Inicializa la matriz de marcados con un tamaño igual al número de filas y columnas del cartón.
     * @param numbers Lista de números en el cartón.
     * @param rows Número de filas del cartón.
     * @param cols Número de columnas del cartón.
     */
    public Card(List<Integer> numbers, int rows, int cols) {
        this.numbers = numbers; 
        this.rows = rows;
        this.cols = cols;
        this.marked = new boolean[rows][cols]; 
    }

    /**
     * Método para obtener la lista de números en el cartón.
     * @return Lista de números en el cartón.
     */
    public List<Integer> getNumbers() {
        return numbers; 
    }

    /**
     * Método para obtener el número de filas del cartón.
     * @return Número de filas del cartón.
     */
    public int getRows() {
        return rows;
    }

    /**
     * Método para obtener el número de columnas del cartón.
     * @return Número de columnas del cartón.
     */
    public int getCols() {
        return cols;
    }

    /**
     * Método para marcar un número en el cartón.
     * @param number Número a marcar.
     * @return true si el número se marcó correctamente, false en caso contrario.
     */
    public boolean markNumber(int number) {
        int index = numbers.indexOf(number);
        if (index != -1) { //Si el número está en la lista de números
            int row = index / cols; //Obtener la fila del número
            int col = index % cols; //Obtener la columna del número
            marked[row][col] = true; //Marcar el número
            return true;
        }
        return false; //Si el número no está en la lista de números, no se marcó correctamente
    }

    /**
     * Método para verificar si el cartón está en un bingo horizontal.
     * @return true si el cartón está en un bingo horizontal, false en caso contrario.
     */
    public boolean checkHorizontalBingo() {
        for (int i = 0; i < rows; i++) { //Recorrer todas las filas del cartón
            boolean bingo = true; 
            for (int j = 0; j < cols; j++) { //Recorrer todas las columnas del cartón
                if (!marked[i][j]) { //Si el número no está marcado en la fila i y columna j
                    bingo = false;
                    break;
                }
            }
            if (bingo) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método para mostrar el cartón en pantalla.
     */
    public void display() {
        for (int i = 0; i < numbers.size(); i++) {
            System.out.printf("%2d%s ", numbers.get(i), marked[i / cols][i % cols] ? "*" : " "); //Mostrar el número y el asterisco si está marcado
            if ((i + 1) % cols == 0) {  //Si el número es el último del cartón, imprimir una nueva línea
                System.out.println();
            }
        }
        System.out.println();
    }
}