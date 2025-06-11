package iterator;

import java.util.List;
import model.Book;

/**
 * Implementación concreta de MyIterator para la colección de libros.
 * Este "Iterador Concreto" permite recorrer los libros en orden inverso.
 * El índice se inicializa al final de la lista y se decrementa en cada llamada a next().
 */
public class ReverseBookIterator implements MyIterator<Book> {
    private final List<Book> books;
    // El índice se inicializa en la última posición válida de la lista.
    private int index;

    /**
     * Constructor del iterador inverso.
     * @param books La lista de libros a iterar.
     */
    public ReverseBookIterator(List<Book> books) {
        this.books = books;
        this.index = books.size() - 1; // Empieza desde el último elemento.
    }

    /**
     * Comprueba si hay más elementos en la iteración.
     * Para una iteración inversa, hay elementos mientras el índice sea mayor o igual a 0.
     * @return true si hay más elementos, false en caso contrario.
     */
    @Override
    public boolean hasNext() {
        return index >= 0;
    }

    /**
     * Devuelve el siguiente elemento (en orden inverso) y retrocede el iterador.
     * @return El libro en la posición actual del índice.
     */
    @Override
    public Book next() {
        return books.get(index--); // Obtiene el libro y luego decrementa el índice.
    }
}