package iterator;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import model.Book;

/**
 * Implementación concreta de MyIterator para la colección de libros.
 * Este "Iterador Concreto" permite recorrer los libros ordenados alfabéticamente por autor.
 * Mantiene el estado de la iteración (el índice actual) de forma independiente
 * de la colección subyacente.
 */
public class AuthorAlphabeticalBookIterator implements MyIterator<Book> {
    // Una copia ordenada de la lista de libros. Esto asegura que la iteración
    // no afecte el orden original de la colección, y permite un ordenamiento específico.
    private final List<Book> sortedBooks;
    // El índice actual para la iteración.
    private int index = 0;

    /**
     * Constructor del iterador. Recibe la lista de libros y la ordena por autor.
     * @param books La lista de libros a iterar.
     */
    public AuthorAlphabeticalBookIterator(List<Book> books) {
        // Se crea una nueva lista para evitar modificar la lista original.
        sortedBooks = new ArrayList<>(books);
        // Se ordena la lista de libros usando un Comparator que compara por el nombre del autor.
        sortedBooks.sort(Comparator.comparing(Book::getAuthor));
    }

    /**
     * Comprueba si hay más elementos en la iteración.
     * @return true si hay más elementos, false en caso contrario.
     */
    @Override
    public boolean hasNext() {
        return index < sortedBooks.size();
    }

    /**
     * Devuelve el siguiente elemento de la iteración y avanza el iterador.
     * @return El siguiente libro en la secuencia ordenada.
     */
    @Override
    public Book next() {
        return sortedBooks.get(index++);
    }
}