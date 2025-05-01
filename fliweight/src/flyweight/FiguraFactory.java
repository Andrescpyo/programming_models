package flyweight;

import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 * La clase FiguraFactory actúa como el FlyweightFactory en el patrón Flyweight.
 * Su responsabilidad es crear y gestionar las instancias de los objetos Flyweight (Figuras).
 * Asegura que las instancias de las figuras se compartan para ahorrar memoria.
 */
public class FiguraFactory {

    /**
     * El HashMap 'figuras' actúa como el pool o caché de objetos Flyweight.
     * Almacena las instancias de las figuras creadas, utilizando el tipo de figura como clave.
     */
    private static final HashMap<String, Figura> figuras = new HashMap<>();

    /**
     * Método estático para obtener una instancia de una Figura del tipo especificado.
     * Si ya existe una instancia de ese tipo en el pool, la devuelve.
     * Si no existe, crea una nueva instancia, la almacena en el pool y luego la devuelve.
     *
     * @param tipo El tipo de figura a obtener ("circulo", "cuadrado", "triangulo").
     * @return Una instancia compartida de la Figura del tipo solicitado.
     */
    public static Figura getFigura(String tipo) {
        // Primero, intenta obtener la figura del pool.
        Figura figura = figuras.get(tipo);

        // Si la figura no existe en el pool, se crea una nueva instancia.
        if (figura == null) {
            switch (tipo.toLowerCase()) {
                case "circulo":
                    figura = new Circulo();
                    break;
                case "cuadrado":
                    figura = new Cuadrado();
                    break;
                case "triangulo":
                    figura = new Triangulo();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Tipo de figura no soportado: " + tipo);
                    return null;
            }

            // Si se creó una nueva figura, se almacena en el pool para futuras solicitudes.
            if (figura != null) {
                figuras.put(tipo, figura);
                JOptionPane.showMessageDialog(null, "Figura creada: " + tipo);
            }
        }
        return figura;
    }
}