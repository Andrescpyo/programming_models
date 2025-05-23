package terminales;

/**
 * Esta clase **ConcreteExpression (TerminalExpression)** del patrón Interpreter.
 * Representa la operación de resta.
 * Implementa el método `interprete()` para realizar la operación de resta en el contexto.
 *
 * @author Andrés Cerdas Padilla, 20231020053.
 * @author Ana Karina Roa Mora. 20232020118.
 */
import java.util.*; // Importa la clase Stack
import abstraccion.Expresion; 

public class expresion_menos implements Expresion {

    /**
     * Implementación del método **interprete()** para la operación de resta.
     * Saca los dos operandos de la pila, realiza la resta (el segundo elemento sacado
     * se resta del primero que estaba en la pila, es decir, `valor1 - valor2`),
     * y luego empuja el resultado de nuevo a la pila.
     *
     * @param pil La pila que actúa como contexto para la interpretación.
     */
    @Override
    public void interprete(Stack<Integer> pil) {

        // Saca el segundo operando (el que está en la cima de la pila).
        int menos = pil.pop();

        // Saca el primer operando (el nuevo tope de la pila) y le resta el segundo.
        // El resultado se empuja de nuevo a la pila.
        pil.push(pil.pop() - menos);
    }

}