package Practica_Singleton;

import Productos.Peluqueria;
import javax.swing.JOptionPane;

public class PracticaSigleton {

    public static void main(String[] args) {
        int op;
        do {
            op = menu(); // Pregunta por la opción elegida
            switch (op) {
                case 1:
                    Peluqueria peluqueria = Peluqueria.getInstance();
                    peluqueria.mostrarInformacion();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Cerrando Programa");
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Inténtelo de nuevo.");
            }

        } while (op != 2);
    }

    public static int menu() {
        String opcion = JOptionPane.showInputDialog(
                "Elija una opción:\n"
                + "1. Ver información de la peluquería\n"
                + "2. Cerrar programa\n"
                + "Seleccione una opción..."
        );

        if (opcion == null || opcion.trim().isEmpty()) {
            // Si el usuario presiona "Cancelar" o deja el campo vacío, devolver una opción inválida
            return -1;
        }

        try {
            return Integer.parseInt(opcion);
        } catch (NumberFormatException e) {
            // Si el usuario ingresa un valor no numérico, devolver una opción inválida
            return -1;
        }
    }

}
