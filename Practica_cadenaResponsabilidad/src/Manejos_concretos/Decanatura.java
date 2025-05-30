package Manejos_concretos;

import Interfaces.Manejo_principal;
import java.util.Random;

/**
 * Esta clase representa otro **Concrete Handler** en el patrón Chain of Responsibility.
 * Similar a Coordinación, Decanatura intenta procesar la petición y, si no es posible, la delega.
 */
public class Decanatura implements Manejo_principal {
    // Referencia al siguiente manejador en la cadena.
    private Manejo_principal siguiente;
    private Random random = new Random();

    /**
     * Constructor para inicializar el manejador de Decanatura.
     *
     * @param siguiente El siguiente manejador en la cadena.
     */
    public Decanatura(Manejo_principal siguiente) {
        this.siguiente = siguiente;
    }

    /**
     * Implementación del método para manejar la petición.
     * Decanatura intenta responder a la petición con una probabilidad del 50%.
     * Si no puede, la pasa al manejador de Rectoría.
     *
     * @param peticion La petición a manejar.
     * @param historial El historial de la petición.
     */
    @Override
    public void manejarPeticion(String peticion, StringBuilder historial) {
        historial.append("Decanatura recibe la petición...\n");
        // Lógica para determinar si Decanatura puede manejar la petición.
        if (random.nextInt(100) < 50) { // 50% de probabilidad de responder
            historial.append("Decanatura responde: ").append(peticion).append("\n");
        } else {
            historial.append("Decanatura no puede responder. Pasa a Rectoría...\n");
            // La petición se pasa al siguiente manejador en la cadena.
            siguiente.manejarPeticion(peticion, historial);
        }
    }
}