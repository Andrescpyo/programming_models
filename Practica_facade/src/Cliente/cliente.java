package Cliente;

/**
 * Representa un cliente de la entidad bancaria.
 * Esta clase simple almacena el nombre del cliente.
 *
 * @author Andrés Cerdas Padilla, 20231020053
 * @author Ana Karina Roa Mora, 20232020118
 */
public class cliente {

    private String nom; // Nombre del cliente

    /**
     * Constructor para crear un nuevo cliente.
     *
     * @param nombre El nombre del cliente.
     */
    public cliente(String nombre) {
        this.nom = nombre;
    }

    /**
     * Obtiene el nombre del cliente.
     *
     * @return El nombre del cliente.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Establece el nombre del cliente.
     *
     * @param nombre El nuevo nombre del cliente.
     */
    public void setNom(String nombre) {
        this.nom = nombre;
    }

    /**
     * Imprime en la consola la información del cliente.
     */
    public void impre() {
        System.out.println();
        System.out.println("EL CLIENTE EN ESTUDIO ES..." + nom);
    }
}