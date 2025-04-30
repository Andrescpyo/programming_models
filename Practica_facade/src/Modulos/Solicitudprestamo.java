package Modulos;

import Cliente.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Este módulo del subsistema verifica si el cliente ya posee otros préstamos activos.
 * En un sistema real, esta clase consultaría la base de datos de préstamos del banco.
 *
 * @author Andrés Cerdas Padilla, 20231020053
 * @author Ana Karina Roa Mora, 20232020118
 */
public class Solicitudprestamo {

    private Set<String> clientesConPrestamo = new HashSet<>();

    /**
     * Verifica si el cliente ya tiene otros préstamos activos.
     *
     * @param cliente El objeto cliente del cual se va a verificar si tiene otros préstamos.
     * @return true si el cliente no tiene otros préstamos activos, false en caso contrario.
     */
    public boolean poseeprestamo(cliente cliente) {
        System.out.println("Verificando si el cliente tiene otros prestamos...");
        if (clientesConPrestamo.contains(cliente.getNom())) {
            System.out.println("El cliente YA tiene prestamos activos.");
            return false;
        } else {
            System.out.println("El cliente NO tiene prestamos activos.");
            return true;
        }
    }

    /**
     * Simula el otorgamiento de un préstamo a un cliente.
     *
     * @param cliente El cliente al que se le otorgó el préstamo.
     */
    public void otorgarPrestamo(cliente cliente) {
        clientesConPrestamo.add(cliente.getNom());
    }

    /**
     * Simula la cancelación de un préstamo de un cliente (para pruebas).
     *
     * @param cliente El cliente que canceló el préstamo.
     */
    public void cancelarPrestamo(cliente cliente) {
        clientesConPrestamo.remove(cliente.getNom());
    }
}