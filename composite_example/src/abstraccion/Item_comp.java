package abstraccion;

/**
 * Interfaz Componente (Item_comp):
 * Define la interfaz común para todos los objetos en la composición,
 * tanto para los objetos individuales (Hojas) como para los objetos compuestos (Compuestos).
 * Declara el método 'getNombre()' que todos los componentes deben implementar.
 */
public interface Item_comp {
    String getNombre();
}