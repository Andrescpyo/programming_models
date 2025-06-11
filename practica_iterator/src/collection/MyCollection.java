package collection;

import iterator.MyIterator;

/**
 * Interfaz MyCollection. Representa el "Agregado" (Aggregate) en el patrón Iterator.
 * Define la operación para crear un objeto Iterador.
 * Permite que diferentes implementaciones de colecciones (ej. BookCollection, MagazineCollection)
 * proporcionen sus propios iteradores sin exponer su estructura interna.
 *
 * @param <T> El tipo de elementos que contendrá la colección.
 */
public interface MyCollection<T> {
    /**
     * Añade un elemento a la colección.
     * @param item El elemento a añadir.
     */
    void addItem(T item);

    /**
     * Crea y devuelve un iterador para recorrer la colección en su orden predeterminado.
     * Este es el "Método de Fábrica" principal para crear iteradores.
     * @return Una instancia de MyIterator para el tipo T.
     */
    MyIterator<T> createIterator();

    /**
     * Crea y devuelve un iterador para recorrer la colección en orden inverso.
     * @return Una instancia de MyIterator para el tipo T en orden inverso.
     */
    MyIterator<T> createReverseIterator();

    /**
     * Crea y devuelve un iterador para recorrer la colección ordenada alfabéticamente por autor.
     * @return Una instancia de MyIterator para el tipo T ordenada por autor.
     */
    MyIterator<T> createAuthorAlphabeticalIterator();
}