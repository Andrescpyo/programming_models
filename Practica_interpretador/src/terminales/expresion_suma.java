package terminales;

/**
 * Esta clase **ConcreteExpression (TerminalExpression)** del patrón Interpreter.
 * Representa la operación de suma.
 * Implementa el método `interprete()` para realizar la operación de suma en el contexto.
 *
 * @author Andrés Cerdas Padilla, 20231020053.
 * @author Ana Karina Roa Mora. 20232020118.
 */
import java.util.*; // Importa la clase Stack
import abstraccion.Expresion;

public class expresion_suma implements Expresion {

    /**
     * Implementación del método **interprete()** para la operación de suma.
     * Saca los dos operandos de la pila (en notación polaca inversa, el orden
     * no importa para la suma), realiza la suma, y luego empuja el resultado
     * de nuevo a la pila.
     *
     * @param pil La pila que actúa como contexto para la interpretación.
     */
    @Override
    public void interprete(Stack<Integer> pil) {

        // Saca los dos operandos de la pila y los suma.
        // El resultado se empuja de nuevo a la pila.
        pil.push(pil.pop() + pil.pop());
    }
}