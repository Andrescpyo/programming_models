package practica_interpretador;

/**
 * Esta es la clase **Main** de la aplicación.
 * Anteriormente, aquí se iniciaba directamente la interpretación.
 * Ahora, su rol principal es lanzar la interfaz gráfica de la calculadora.
 *
 * @author Andrés Cerdas Padilla, 20231020053.
 * @author Ana Karina Roa Mora. 20232020118.
 */
// import Contexto.Analizador; // Ya no se usa directamente aquí, la GUI lo usa.
import javax.swing.SwingUtilities; 

public class Practica_interpretador {

    /**
     * Método principal (main) de la aplicación.
     * Es el punto de entrada para ejecutar el programa.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Se asegura de que la creación y actualización de la GUI se realice en el
        // Event Dispatch Thread (EDT) de Swing para evitar problemas de concurrencia.
        SwingUtilities.invokeLater(() -> {
            new CalculadoraGUI().setVisible(true); // Crea y muestra la ventana de la calculadora
        });
    }

}