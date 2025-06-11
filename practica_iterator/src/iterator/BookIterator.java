package iterator;

import java.util.List;
import model.Book;

/**
 * Implementación concreta de MyIterator para la colección de libros.
 * Este "Iterador Concreto" permite recorrer los libros en su orden de inserción (normal).
 * Mantiene un índice para saber la posición actual dentro de la lista.
 */
public class BookIterator implements MyIterator<Book> {
    // Referencia a la lista de libros de la colección.
    private final List<Book> books;
    // Índice actual en la iteración, inicializado en 0 para empezar desde el primer elemento.
    private int index = 0;

    /**
     * Constructor del iterador. Recibe la lista de libros de la cual se va a iterar.
     * @param books La lista de libros a iterar.
     */
    public BookIterator(List<Book> books) {
        this.books = books;
    }

    /**
     * Comprueba si hay más elementos en la iteración.
     * @return true si el índice es menor que el tamaño de la lista, indicando que hay más libros.
     */
    @Override
    public boolean hasNext() {
        return index < books.size();
    }

    /**
     * Devuelve el siguiente elemento de la iteración y avanza el iterador.
     * @return El libro en la posición actual del índice.
     */
    @Override
    public Book next() {
        return books.get(index++); // Obtiene el libro en el índice actual y luego incrementa el índice.
    }
}