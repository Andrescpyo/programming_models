package iterator;

import java.util.List;
import model.Thesis;

/**
 * Implementación concreta de MyIterator para la colección de tesis.
 * Permite recorrer las tesis en orden inverso.
 */
public class ReverseThesisIterator implements MyIterator<Thesis> {
    private final List<Thesis> theses;
    private int index;

    /**
     * Constructor del iterador inverso.
     * @param theses La lista de tesis a iterar.
     */
    public ReverseThesisIterator(List<Thesis> theses) {
        this.theses = theses;
        this.index = theses.size() - 1;
    }

    /**
     * Comprueba si hay más elementos en la iteración.
     * @return true si hay más elementos, false en caso contrario.
     */
    @Override
    public boolean hasNext() {
        return index >= 0;
    }

    /**
     * Devuelve el siguiente elemento (en orden inverso) y retrocede el iterador.
     * @return La tesis en la posición actual.
     */
    @Override
    public Thesis next() {
        return theses.get(index--);
    }
}