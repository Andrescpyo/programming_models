/*
 * @author Andrés Cerdas Padilla, 20231020053.
 * @author Ana Karina Roa Mora. 20232020118.
 */

package Interfaces;

/**
 * Esta interfaz representa el **Handler** (Manejador) en el patrón Chain of Responsibility.
 * Define la interfaz común para todos los manejadores concretos en la cadena.
 * Cualquier clase que implemente esta interfaz puede manejar una petición o pasarla al siguiente manejador.
 */
public interface Manejo_principal {
    /**
     * Este método es el punto de entrada para manejar una petición.
     * Cada manejador concreto implementará su lógica específica para decidir si puede manejar la petición
     * o si debe pasarla al siguiente en la cadena.
     *
     * @param peticion La petición o solicitud que debe ser manejada.
     * @param historial Un StringBuilder para registrar el flujo de la petición a través de la cadena.
     */
    void manejarPeticion(String peticion, StringBuilder historial);
}