package iterator;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import model.Thesis;

/**
 * Implementación concreta de MyIterator para la colección de tesis.
 * Este "Iterador Concreto" permite recorrer las tesis ordenadas alfabéticamente por autor.
 */
public class AuthorAlphabeticalThesisIterator implements MyIterator<Thesis> {
    private final List<Thesis> sortedTheses;
    private int index = 0;

    /**
     * Constructor del iterador. Recibe la lista de tesis y la ordena por autor.
     * @param theses La lista de tesis a iterar.
     */
    public AuthorAlphabeticalThesisIterator(List<Thesis> theses) {
        sortedTheses = new ArrayList<>(theses);
        sortedTheses.sort(Comparator.comparing(Thesis::getAuthor));
    }

    /**
     * Comprueba si hay más elementos en la iteración.
     * @return true si hay más elementos, false en caso contrario.
     */
    @Override
    public boolean hasNext() {
        return index < sortedTheses.size();
    }

    /**
     * Devuelve el siguiente elemento de la iteración y avanza el iterador.
     * @return La siguiente tesis en la secuencia ordenada.
     */
    @Override
    public Thesis next() {
        return sortedTheses.get(index++);
    }
}