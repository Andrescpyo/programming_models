package iterator;

import java.util.List;
import model.Magazine;

/**
 * Implementación concreta de MyIterator para la colección de revistas.
 * Permite recorrer las revistas en su orden de inserción (normal).
 */
public class MagazineIterator implements MyIterator<Magazine> {
    private final List<Magazine> magazines;
    private int index = 0;

    /**
     * Constructor del iterador.
     * @param magazines La lista de revistas a iterar.
     */
    public MagazineIterator(List<Magazine> magazines) {
        this.magazines = magazines;
    }

    /**
     * Comprueba si hay más elementos en la iteración.
     * @return true si hay más elementos, false en caso contrario.
     */
    @Override
    public boolean hasNext() {
        return index < magazines.size();
    }

    /**
     * Devuelve el siguiente elemento de la iteración y avanza el iterador.
     * @return La revista en la posición actual.
     */
    @Override
    public Magazine next() {
        return magazines.get(index++);
    }
}