package Manejos_concretos;

import Interfaces.Manejo_principal;
import java.util.Random;

/**
 * Esta clase representa un **Concrete Handler** (Manejador Concreto) en el patrón Chain of Responsibility.
 * Es uno de los nodos en la cadena que puede procesar una petición.
 * Si no puede manejarla, la pasa al siguiente manejador.
 */
public class Coordinacion implements Manejo_principal {
    // Referencia al siguiente manejador en la cadena. Esta es la clave para encadenar los manejadores.
    private Manejo_principal siguiente;
    private Random random = new Random();

    /**
     * Constructor para inicializar el manejador de Coordinación.
     *
     * @param siguiente El siguiente manejador en la cadena, o 'null' si este es el último.
     */
    public Coordinacion(Manejo_principal siguiente) {
        this.siguiente = siguiente;
    }

    /**
     * Implementación del método para manejar la petición.
     * Coordinación intenta responder a la petición con una probabilidad del 40%.
     * Si no puede, pasa la petición al manejador de Decanatura.
     *
     * @param peticion La petición a manejar.
     * @param historial El historial de la petición.
     */
    @Override
    public void manejarPeticion(String peticion, StringBuilder historial) {
        historial.append("Coordinación recibe la petición...\n");
        // Lógica para determinar si Coordinación puede manejar la petición.
        if (random.nextInt(100) < 40) { // 40% de probabilidad de responder
            historial.append("Coordinación responde: ").append(peticion).append("\n");
        } else {
            historial.append("Coordinación no puede responder. Pasa a Decanatura...\n");
            // La petición se pasa al siguiente manejador en la cadena.
            siguiente.manejarPeticion(peticion, historial);
        }
    }
}
