package iterator;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import model.Magazine;

/**
 * Implementación concreta de MyIterator para la colección de revistas.
 * Este "Iterador Concreto" permite recorrer las revistas ordenadas alfabéticamente por editor (considerado autor).
 */
public class AuthorAlphabeticalMagazineIterator implements MyIterator<Magazine> {
    private final List<Magazine> sortedMagazines;
    private int index = 0;

    /**
     * Constructor del iterador. Recibe la lista de revistas y la ordena por editor.
     * @param magazines La lista de revistas a iterar.
     */
    public AuthorAlphabeticalMagazineIterator(List<Magazine> magazines) {
        sortedMagazines = new ArrayList<>(magazines);
        // Se asume que getAuthor() de Magazine devuelve el editor para el propósito de ordenamiento.
        sortedMagazines.sort(Comparator.comparing(Magazine::getAuthor));
    }

    /**
     * Comprueba si hay más elementos en la iteración.
     * @return true si hay más elementos, false en caso contrario.
     */
    @Override
    public boolean hasNext() {
        return index < sortedMagazines.size();
    }

    /**
     * Devuelve el siguiente elemento de la iteración y avanza el iterador.
     * @return La siguiente revista en la secuencia ordenada.
     */
    @Override
    public Magazine next() {
        return sortedMagazines.get(index++);
    }
}