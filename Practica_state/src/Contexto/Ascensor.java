package Contexto;

import Interfaces.Estado_ascensor;

/**
 * La clase Ascensor es el "Contexto" en el patrón State.
 * Contiene una referencia a un objeto de estado concreto (Estado_ascensor)
 * y delega las operaciones específicas del estado a ese objeto.
 * También gestiona el estado interno del ascensor (como el contador de uso
 * que lo lleva a mantenimiento) y la lógica para cambiar entre estados.
 */
public class Ascensor {

    // Referencia al objeto de estado actual del ascensor.
    // Esta es la clave del patrón State: el Contexto delega su comportamiento a este objeto.
    private Estado_ascensor estado;
    private int uso = 0; // Contador para simular el uso y entrar en mantenimiento.
    private boolean enMantenimiento = false; // Bandera para indicar si está en mantenimiento.

    /**
     * Establece el estado actual del ascensor.
     * Esta es la operación que permite al Contexto cambiar su comportamiento
     * dinámicamente al cambiar su objeto de estado.
     * @param nuevoEstado La nueva instancia del estado concreto (ej. Enservicio, Mantenimiento).
     */
    public void setEstado(Estado_ascensor nuevoEstado) {
        this.estado = nuevoEstado;
    }

    /**
     * Obtiene el nombre del estado actual del ascensor.
     * El Contexto delega esta llamada al objeto de estado actual.
     * @return El nombre del estado actual.
     */
    public String obtenerEstado() {
        return estado != null ? estado.getNombreEstado() : "Sin estado asignado";
    }

    /**
     * Verifica si el ascensor está actualmente en mantenimiento.
     * @return true si está en mantenimiento, false en caso contrario.
     */
    public boolean estaEnMantenimiento() {
        return enMantenimiento;
    }

    /**
     * Simula el uso del ascensor. Esta operación contiene la lógica
     * para cambiar el estado del ascensor a "mantenimiento" después de cierto uso.
     * Aunque la lógica de cambio de estado a mantenimiento está aquí, en un patrón State
     * más puro, la transición del estado (por ejemplo, al entrar en mantenimiento)
     * podría ser manejada por los objetos de estado concretos mismos.
     * @param piso El piso al que se "va" el ascensor.
     * @return Un mensaje sobre la acción realizada.
     */
    public String usarAscensor(int piso) {
        if (enMantenimiento) {
            // Este es un chequeo en el contexto para evitar el uso cuando ya está en mantenimiento.
            // La lógica para la "acción" de usar (que aquí es ir a un piso) se ejecuta.
            return "Ascensor en mantenimiento. No disponible.";
        }

        uso++; // Incrementa el contador de uso.
        if (uso >= 2) { // Si el uso supera el umbral, el ascensor entra en mantenimiento.
            enMantenimiento = true;
            // Aquí se cambia la bandera interna del Contexto,
            // pero el cambio del objeto de estado real (`setEstado(mantenimiento)`)
            // se gestiona en la GUI (el cliente), lo que es una variación del patrón.
            return "Has llegado al piso " + piso + ".\nEl ascensor entró en mantenimiento.";
        }
        return "Has llegado al piso " + piso + ".";
    }

    /**
     * Reinicia el contador de uso y saca el ascensor del modo mantenimiento.
     * Esta acción permite al Contexto volver a un estado inicial de "En Servicio".
     */
    public void resetearUso() {
        uso = 0;
        enMantenimiento = false;
    }
}