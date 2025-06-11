package ui;

import javax.swing.SwingUtilities;

/**
 * Clase Main. Punto de entrada de la aplicación.
 * Se encarga de iniciar la interfaz de usuario en el Event Dispatch Thread (EDT)
 * para asegurar un comportamiento seguro de los hilos en Swing.
 */
public class Main {
    public static void main(String[] args) {
        // SwingUtilities.invokeLater asegura que la creación y actualización de componentes Swing
        // se realice en el Event Dispatch Thread, que es el hilo seguro para UI.
        SwingUtilities.invokeLater(() -> new LibraryApp().setVisible(true));
    }
}