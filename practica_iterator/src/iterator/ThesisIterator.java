package iterator;

import java.util.List;
import model.Thesis;

/**
 * Implementación concreta de MyIterator para la colección de tesis.
 * Permite recorrer las tesis en su orden de inserción (normal).
 */
public class ThesisIterator implements MyIterator<Thesis> {
    private final List<Thesis> theses;
    private int index = 0;

    /**
     * Constructor del iterador.
     * @param theses La lista de tesis a iterar.
     */
    public ThesisIterator(List<Thesis> theses) {
        this.theses = theses;
    }

    /**
     * Comprueba si hay más elementos en la iteración.
     * @return true si hay más elementos, false en caso contrario.
     */
    @Override
    public boolean hasNext() {
        return index < theses.size();
    }

    /**
     * Devuelve el siguiente elemento de la iteración y avanza el iterador.
     * @return La tesis en la posición actual.
     */
    @Override
    public Thesis next() {
        return theses.get(index++);
    }
}