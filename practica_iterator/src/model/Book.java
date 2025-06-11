package model;

/**
 * Clase Book. Representa un objeto de datos (POJO - Plain Old Java Object) para un libro.
 * Contiene propiedades básicas de un libro y métodos para acceder a ellas.
 */
public class Book {
    private String title;
    private String author;
    private String genre;
    private int year;

    /**
     * Constructor para crear un nuevo objeto Book.
     * @param title El título del libro.
     * @param author El autor del libro.
     * @param genre El género del libro.
     * @param year El año de publicación del libro.
     */
    public Book(String title, String author, String genre, int year) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.year = year;
    }

    /**
     * Obtiene el autor del libro. Utilizado por los iteradores para ordenar.
     * @return El autor del libro.
     */
    public String getAuthor() {
        return author;
    }

    // Métodos getter para otras propiedades pueden ser añadidos si son necesarios.
    public String getTitle() { return title; }
    public String getGenre() { return genre; }
    public int getYear() { return year; }

    /**
     * Sobreescribe el método toString() para proporcionar una representación legible del objeto Book.
     * @return Una cadena que describe el libro.
     */
    @Override
    public String toString() {
        return "Título: " + title + ", Autor: " + author + ", Género: " + genre + ", Año: " + year;
    }
}