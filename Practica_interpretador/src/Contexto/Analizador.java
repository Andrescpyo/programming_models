package Contexto;

/**
 * Esta clase **Contexto (o Client)** del patrón Interpreter.
 * Es responsable de construir el árbol de sintaxis abstracta (Abstract Syntax Tree - AST)
 * a partir de la expresión de entrada y de iniciar la operación de interpretación.
 *
 * @author Andrés Cerdas Padilla, 20231020053.
 * @author Ana Karina Roa Mora. 20232020118.
 */
import terminales.*; 
import java.util.*; // Importa la clase Stack
import abstraccion.Expresion; 

public class Analizador {

    // El árbol de sintaxis abstracta que contendrá las expresiones.
    // Es una lista de objetos que implementan la interfaz Expresion.
    private final ArrayList<Expresion> arbol = new ArrayList<>();

    /**
     * Constructor del Analizador.
     * Recibe una cadena de texto que representa la expresión a interpretar
     * (en notación polaca inversa, por ejemplo: "42 2 1 - +").
     * Construye el árbol de sintaxis abstracta a partir de esta cadena.
     *
     * @param pil La cadena de texto que contiene la expresión.
     */
    public Analizador(String pil) {

        // Divide la cadena de entrada en tokens (números, operadores)
        for (String pila : pil.split(" ")) {
            // Determina el tipo de expresión y crea el objeto correspondiente
            switch (pila) {
                case "+":
                    // Si el token es '+', añade una instancia de expresion_suma al árbol.
                    arbol.add(new expresion_suma());
                    break;
                case "-":
                    // Si el token es '-', añade una instancia de expresion_menos al árbol.
                    arbol.add(new expresion_menos());
                    break;
                default:
                    // Si el token es un número, añade una instancia de Expresion_numero.
                    // Convierte la cadena del número a un entero.
                    arbol.add(new Expresion_numero(Integer.valueOf(pila)));
                    break;
            }

        }
    }

    /**
     * Método **evaluar()**: Este método inicia la interpretación.
     * Crea una pila que servirá como contexto para la ejecución de las expresiones.
     * Itera sobre el árbol de sintaxis abstracta, llamando al método `interprete()`
     * de cada expresión, lo que resulta en la evaluación de la expresión completa.
     *
     * @return El resultado final de la evaluación de la expresión.
     */
    public int evaluar() {
        Stack<Integer> contexto = new Stack<>(); // Pila que actúa como contexto para la interpretación

        // Itera sobre cada expresión en el árbol y llama a su método interprete.
        // Las expresiones modifican el contexto (la pila) según su lógica.
        arbol.forEach((Expresion e) -> {
            e.interprete(contexto);
        });

        // El resultado final de la expresión se encuentra en la cima de la pila.
        return contexto.pop();
    }
}