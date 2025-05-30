package Manejos_concretos;

import Interfaces.Manejo_principal;
import java.util.Random;

/**
 * Esta clase es otro **Concrete Handler** en la cadena de responsabilidad.
 * Es el primer punto de contacto en esta implementación específica de la cadena.
 */
public class Profesor implements Manejo_principal {
    // Referencia al siguiente manejador en la cadena.
    private Manejo_principal siguiente;
    private Random random = new Random();

    /**
     * Constructor para inicializar el manejador de Profesor.
     *
     * @param siguiente El siguiente manejador en la cadena.
     */
    public Profesor(Manejo_principal siguiente) {
        this.siguiente = siguiente;
    }

    /**
     * Implementación del método para manejar la petición.
     * Profesor intenta responder a la petición con una probabilidad del 30%.
     * Si no puede, la pasa al manejador de Coordinación.
     *
     * @param peticion La petición a manejar.
     * @param historial El historial de la petición.
     */
    @Override
    public void manejarPeticion(String peticion, StringBuilder historial) {
        historial.append("Profesor recibe la petición...\n");
        // Lógica para determinar si Profesor puede manejar la petición.
        if (random.nextInt(100) < 30) {  // 30% de probabilidad de responder
            historial.append("Profesor responde: ").append(peticion).append("\n");
        } else {
            historial.append("Profesor no puede responder. Pasa a Coordinación...\n");
            // La petición se pasa al siguiente manejador en la cadena.
            siguiente.manejarPeticion(peticion, historial);
        }
    }
}