package iterator;

import java.util.Iterator;

/**
 * Interfaz MyIterator. Representa el "Iterador" (Iterator) en el patrón Iterator.
 * Declara la interfaz para acceder y recorrer los elementos de una colección.
 * Extiende la interfaz java.util.Iterator para compatibilidad y reuso de métodos estándar.
 *
 * @param <T> El tipo de elementos que el iterador recorrerá.
 */
public interface MyIterator<T> extends Iterator<T> {
    /**
     * Determina si quedan más elementos en la colección para iterar.
     * Este método es fundamental para el control del bucle de iteración.
     * @return true si hay al menos un elemento más, false si se ha llegado al final de la colección.
     */
    boolean hasNext();

    /**
     * Devuelve el siguiente elemento en la secuencia y avanza el iterador a la siguiente posición.
     * @return El siguiente elemento de tipo T.
     */
    T next();

    // El método remove() de la interfaz java.util.Iterator no se implementa aquí,
    // ya que el enfoque principal es la iteración, no la modificación durante la misma.
}