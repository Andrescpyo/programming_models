package abstraccion;

/**
 * Esta es la interfaz **AbstractExpression** del patrón Interpreter.
 * Define la operación de interpretación que todas las expresiones (terminales y no terminales)
 * deben implementar.
 *
 * @author Andrés Cerdas Padilla, 20231020053.
 * @author Ana Karina Roa Mora. 20232020118.
 */
import java.util.*;

public interface Expresion {

    /**
     * Método **interprete()**: Esta es la operación de interpretación.
     * Toma una pila (Stack) como contexto, donde se almacenarán los resultados intermedios
     * y los valores finales de la expresión.
     *
     * @param pil La pila que actúa como contexto para la interpretación.
     */
    public void interprete(Stack<Integer> pil);

}