package terminales;

/**
 * Esta clase **ConcreteExpression (TerminalExpression)** del patrón Interpreter.
 * Representa un valor numérico (un operando).
 * Su rol es simplemente empujar su valor a la pila de contexto.
 *
 * @author Andrés Cerdas Padilla, 20231020053.
 * @author Ana Karina Roa Mora. 20232020118.
 */
import java.util.*; // Importa la clase Stack
import abstraccion.Expresion; 

public class Expresion_numero implements Expresion {

    // Almacena el valor numérico de esta expresión.
    private final int Num;

    /**
     * Constructor para Expresion_numero.
     * Inicializa la expresión con un valor entero específico.
     *
     * @param num El valor numérico de esta expresión.
     */
    public Expresion_numero(int num) {

        this.Num = num;
    }

    /**
     * Implementación del método **interprete()** para un número.
     * Simplemente empuja el valor numérico de esta expresión a la pila de contexto.
     *
     * @param pil La pila que actúa como contexto para la interpretación.
     */
    @Override
    public void interprete(Stack<Integer> pil) {
        pil.push(Num); // Empuja el número a la pila.
    }
}