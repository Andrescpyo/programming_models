package abstraccion;

import java.util.ArrayList;
import java.util.List;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Clase Compuesto (Paquete):
 * Representa un objeto compuesto que puede contener otros objetos Item_comp,
 * tanto Productos (Hojas) como otros Paquetes (Compuestos).
 * Implementa la interfaz Item_comp, permitiendo que los paquetes sean tratados
 * de la misma manera que los productos individuales.
 */
public class Paquete implements Item_comp {
    private String nombre; // Nombre del paquete
    private List<Item_comp> items = new ArrayList<>(); // Lista para almacenar los items contenidos en este paquete

    /**
     * Constructor del Paquete.
     * @param nombre El nombre del paquete.
     */
    public Paquete(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método para agregar un Item_comp (Producto o Paquete) a este paquete.
     * Este método permite construir la estructura jerárquica del patrón Composite.
     * @param item El Item_comp a agregar.
     */
    public void agregar(Item_comp item) {
        items.add(item);
    }

    /**
     * Implementación del método 'getNombre()' de la interfaz Item_comp.
     * Devuelve el nombre del paquete.
     * @return El nombre del paquete.
     */
    @Override
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para obtener la lista de items contenidos en este paquete.
     * @return La lista de Item_comp dentro del paquete.
     */
    public List<Item_comp> getItems() {
        return items;
    }

    /**
     * Método para crear un nodo de árbol (DefaultMutableTreeNode) representando
     * este paquete y sus contenidos de forma recursiva.
     * Este método demuestra cómo el Compuesto opera sobre sus hijos.
     * @return Un DefaultMutableTreeNode que representa el paquete y su estructura interna.
     */
    public DefaultMutableTreeNode crearNodo() {
        DefaultMutableTreeNode nodo = new DefaultMutableTreeNode(nombre); // Crea un nodo para este paquete
        for (Item_comp item : items) {
            if (item instanceof Paquete) {
                // Si el item es otro Paquete (Compuesto), llama recursivamente a su método crearNodo()
                nodo.add(((Paquete) item).crearNodo());
            } else {
                // Si el item es un Producto (Hoja), crea un nodo simple con su nombre
                nodo.add(new DefaultMutableTreeNode(item.getNombre()));
            }
        }
        return nodo;
    }
}