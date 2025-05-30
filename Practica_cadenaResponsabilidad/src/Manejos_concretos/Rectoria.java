package Manejos_concretos;

import Interfaces.Manejo_principal;

/**
 * Esta clase representa el **último Concrete Handler** en la cadena de responsabilidad.
 * A diferencia de los otros manejadores, Rectoría no tiene un "siguiente" y siempre procesa la petición.
 * Esto asegura que todas las peticiones sean eventualmente manejadas.
 */
public class Rectoria implements Manejo_principal {

    /**
     * Implementación del método para manejar la petición.
     * Rectoría siempre responde a la petición, marcando el final del flujo de la cadena.
     *
     * @param peticion La petición a manejar.
     * @param historial El historial de la petición.
     */
    @Override
    public void manejarPeticion(String peticion, StringBuilder historial) {
        historial.append("Rectoría recibe la petición...\n");
        historial.append("Rectoría responde: ").append(peticion).append("\n");
    }
}