package collection;

import iterator.*;
import model.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * La clase BookCollection implementa la interfaz MyCollection para gestionar una colección de objetos Book.
 * Actúa como el "Agregado Concreto" en el patrón Iterator, ya que proporciona métodos
 * para crear diferentes tipos de iteradores para su colección interna de libros.
 */
public class BookCollection implements MyCollection<Book> {
    // La lista interna que almacena los objetos Book.
    // Esta es la colección sobre la cual los iteradores operarán.
    private final List<Book> books = new ArrayList<>();

    /**
     * Añade un nuevo libro a la colección.
     * @param item El libro a añadir.
     */
    @Override
    public void addItem(Book item) {
        books.add(item);
    }

    /**
     * Crea y devuelve un iterador para recorrer la colección de libros en orden normal.
     * Este es un "Método de Fábrica" para producir un "Iterador Concreto" (BookIterator).
     * @return Una instancia de BookIterator.
     */
    @Override
    public MyIterator<Book> createIterator() {
        return new BookIterator(books);
    }

    /**
     * Crea y devuelve un iterador para recorrer la colección de libros en orden inverso.
     * Este es otro "Método de Fábrica" para producir un "Iterador Concreto" (ReverseBookIterator).
     * @return Una instancia de ReverseBookIterator.
     */
    @Override
    public MyIterator<Book> createReverseIterator() {
        return new ReverseBookIterator(books);
    }

    /**
     * Crea y devuelve un iterador para recorrer la colección de libros ordenados alfabéticamente por autor.
     * Este es un "Método de Fábrica" para producir un "Iterador Concreto" (AuthorAlphabeticalBookIterator).
     * @return Una instancia de AuthorAlphabeticalBookIterator.
     */
    @Override
    public MyIterator<Book> createAuthorAlphabeticalIterator() {
        return new AuthorAlphabeticalBookIterator(books);
    }

    /**
     * Devuelve el número de libros en la colección.
     * @return El tamaño de la colección.
     */
    public int size() {
        return books.size();
    }

    /**
     * Método opcional para cargar datos de ejemplo en la colección de libros.
     */
    public void loadSampleData() {
        addItem(new Book("El Quijote", "Cervantes", "Novela", 1605));
        addItem(new Book("Cien Años de Soledad", "Gabriel García Márquez", "Realismo Mágico", 1967));
        addItem(new Book("La Sombra del Viento", "Carlos Ruiz Zafón", "Misterio", 2001));
    }
}