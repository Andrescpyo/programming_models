package practica_cadenaresponsabilidad;     // Clase del cliente

/*
 * @author Andrés Cerdas Padilla, 20231020053.
 * @author Ana Karina Roa Mora. 20232020118.
 */

import javax.swing.SwingUtilities;

/**
 * Esta es la clase principal que inicia la aplicación.
 * Actúa como el **Client** (Cliente) que simplemente crea y hace visible la interfaz gráfica.
 * La lógica del patrón Chain of Responsibility se encuentra encapsulada dentro de la clase InterfazGrafica.
 */
public class Practica_cadenaResponsabilidad {

    /**
     * Método principal de la aplicación.
     *
     * @param args Argumentos de la línea de comandos (no utilizados en este caso).
     */
    public static void main(String[] args) {
         // Se crea una instancia de la InterfazGrafica y se hace visible,
         // iniciando así la aplicación y el flujo de la cadena de responsabilidad.
         new InterfazGrafica().setVisible(true);
    }
}