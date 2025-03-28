package Productos;
import javax.swing.JOptionPane;

public class Peluqueria {
    private static Peluqueria instance; // Instancia única de Peluquería

    private String nombre;
    private String direccion;

    // Constructor privado para evitar que se cree más de una instancia
    private Peluqueria(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    // Método estático para obtener la instancia única de la peluquería
    public static Peluqueria getInstance() {
        if (instance == null) {
            // Si no existe una instancia, se crea
            instance = new Peluqueria("Peluqueria Exclusiva", "Calle del Sol 123");
        }
        return instance; // Si ya existe, simplemente se devuelve la instancia
    }

    public void mostrarInformacion() {
        JOptionPane.showMessageDialog(null, "Nombre: " + nombre);
        JOptionPane.showMessageDialog(null, "Direccion: " + direccion);
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }
}
