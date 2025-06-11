package model;

/**
 * Clase Thesis. Representa un objeto de datos (POJO) para una tesis.
 * Contiene propiedades básicas de una tesis.
 */
public class Thesis {
    private String title;
    private String author;
    private String advisor;
    private int year;

    /**
     * Constructor para crear un nuevo objeto Thesis.
     * @param title El título de la tesis.
     * @param author El autor de la tesis.
     * @param advisor El director de la tesis.
     * @param year El año de defensa de la tesis.
     */
    public Thesis(String title, String author, String advisor, int year) {
        this.title = title;
        this.author = author;
        this.advisor = advisor;
        this.year = year;
    }

    /**
     * Obtiene el título de la tesis.
     * @return El título de la tesis.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Obtiene el autor de la tesis. Utilizado por los iteradores para ordenar.
     * @return El autor de la tesis.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Obtiene el director de la tesis.
     * @return El director de la tesis.
     */
    public String getAdvisor() {
        return advisor;
    }

    /**
     * Obtiene el año de la tesis.
     * @return El año de la tesis.
     */
    public int getYear() {
        return year;
    }

    /**
     * Sobreescribe el método toString() para proporcionar una representación legible del objeto Thesis.
     * @return Una cadena que describe la tesis.
     */
    @Override
    public String toString() {
        return "Título: " + title + ", Autor: " + author +
                ", Director: " + advisor + ", Año: " + year;
    }
}