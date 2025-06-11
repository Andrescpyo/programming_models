package collection;

import iterator.*;
import model.Thesis;

import java.util.ArrayList;
import java.util.List;

/**
 * La clase ThesisCollection implementa la interfaz MyCollection para gestionar una colección de objetos Thesis.
 * Es otro "Agregado Concreto" que permite la creación de iteradores específicos para tesis.
 */
public class ThesisCollection implements MyCollection<Thesis> {
    // La lista interna que almacena los objetos Thesis.
    private final List<Thesis> theses = new ArrayList<>();

    /**
     * Añade una nueva tesis a la colección.
     * @param item La tesis a añadir.
     */
    @Override
    public void addItem(Thesis item) {
        theses.add(item);
    }

    /**
     * Crea y devuelve un iterador para recorrer la colección de tesis en orden normal.
     * @return Una instancia de ThesisIterator.
     */
    @Override
    public MyIterator<Thesis> createIterator() {
        return new ThesisIterator(theses);
    }

    /**
     * Crea y devuelve un iterador para recorrer la colección de tesis en orden inverso.
     * @return Una instancia de ReverseThesisIterator.
     */
    @Override
    public MyIterator<Thesis> createReverseIterator() {
        return new ReverseThesisIterator(theses);
    }

    /**
     * Crea y devuelve un iterador para recorrer la colección de tesis ordenadas alfabéticamente por autor.
     * @return Una instancia de AuthorAlphabeticalThesisIterator.
     */
    @Override
    public MyIterator<Thesis> createAuthorAlphabeticalIterator() {
        return new AuthorAlphabeticalThesisIterator(theses);
    }

    /**
     * Método opcional para cargar datos de ejemplo en la colección de tesis.
     */
    public void loadSampleData() {
        addItem(new Thesis("Inteligencia Artificial", "Ana Gómez", "Dr. Pérez", 2021));
        addItem(new Thesis("Robótica Educativa", "Luis Torres", "Dra. Rojas", 2020));
        addItem(new Thesis("Big Data en la Salud", "Marta Díaz", "Dr. Sánchez", 2022));
    }
}