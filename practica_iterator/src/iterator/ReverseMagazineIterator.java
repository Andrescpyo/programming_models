package iterator;

import java.util.List;
import model.Magazine;

/**
 * Implementación concreta de MyIterator para la colección de revistas.
 * Permite recorrer las revistas en orden inverso.
 */
public class ReverseMagazineIterator implements MyIterator<Magazine> {
    private final List<Magazine> magazines;
    private int index;

    /**
     * Constructor del iterador inverso.
     * @param magazines La lista de revistas a iterar.
     */
    public ReverseMagazineIterator(List<Magazine> magazines) {
        this.magazines = magazines;
        this.index = magazines.size() - 1;
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
     * @return La revista en la posición actual.
     */
    @Override
    public Magazine next() {
        return magazines.get(index--);
    }
}