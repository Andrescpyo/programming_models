package abstraccion;

/**
 * Clase Hoja (Producto):
 * Representa un objeto individual en la composición.
 * Implementa la interfaz Item_comp y no puede contener otros objetos.
 */
public class Producto implements Item_comp {
    private String nombre; // Nombre del producto

    /**
     * Constructor del Producto.
     * @param nombre El nombre del producto.
     */
    public Producto(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Implementación del método 'getNombre()' de la interfaz Item_comp.
     * Devuelve el nombre del producto.
     * @return El nombre del producto.
     */
    @Override
    public String getNombre() {
        return nombre;
    }
}