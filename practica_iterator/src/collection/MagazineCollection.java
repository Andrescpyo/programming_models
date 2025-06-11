package collection;

import iterator.*;
import model.Magazine;

import java.util.ArrayList;
import java.util.List;

/**
 * La clase MagazineCollection implementa la interfaz MyCollection para gestionar una colección de objetos Magazine.
 * Al igual que BookCollection, es un "Agregado Concreto" que proporciona métodos
 * para crear iteradores específicos para revistas.
 */
public class MagazineCollection implements MyCollection<Magazine> {
    // La lista interna que almacena los objetos Magazine.
    private final List<Magazine> magazines = new ArrayList<>();

    /**
     * Añade una nueva revista a la colección.
     * @param item La revista a añadir.
     */
    @Override
    public void addItem(Magazine item) {
        magazines.add(item);
    }

    /**
     * Crea y devuelve un iterador para recorrer la colección de revistas en orden normal.
     * @return Una instancia de MagazineIterator.
     */
    @Override
    public MyIterator<Magazine> createIterator() {
        return new MagazineIterator(magazines);
    }

    /**
     * Crea y devuelve un iterador para recorrer la colección de revistas en orden inverso.
     * @return Una instancia de ReverseMagazineIterator.
     */
    @Override
    public MyIterator<Magazine> createReverseIterator() {
        return new ReverseMagazineIterator(magazines);
    }

    /**
     * Crea y devuelve un iterador para recorrer la colección de revistas ordenadas alfabéticamente por autor (editor).
     * @return Una instancia de AuthorAlphabeticalMagazineIterator.
     */
    @Override
    public MyIterator<Magazine> createAuthorAlphabeticalIterator() {
        return new AuthorAlphabeticalMagazineIterator(magazines);
    }

    /**
     * Método opcional para cargar datos de ejemplo en la colección de revistas.
     */
    public void loadSampleData() {
        addItem(new Magazine("National Geographic", "Smith", 150, 2022));
        addItem(new Magazine("Time", "Brown", 142, 2021));
        addItem(new Magazine("Nature", "Clark", 101, 2020));
    }
}