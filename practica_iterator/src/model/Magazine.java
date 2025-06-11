package model;

/**
 * Clase Magazine. Representa un objeto de datos (POJO) para una revista.
 * Contiene propiedades básicas de una revista.
 */
public class Magazine {
    private String title;
    private String editor;
    private int edition;
    private int year;

    /**
     * Constructor para crear un nuevo objeto Magazine.
     * @param title El título de la revista.
     * @param editor El editor de la revista.
     * @param edition El número de edición de la revista.
     * @param year El año de publicación de la revista.
     */
    public Magazine(String title, String editor, int edition, int year) {
        this.title = title;
        this.editor = editor;
        this.edition = edition;
        this.year = year;
    }

    /**
     * Obtiene el título de la revista.
     * @return El título de la revista.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Obtiene el nombre del editor.
     * Se interpreta "editor" como "autor" para fines de ordenamiento alfabético en los iteradores.
     * @return El editor de la revista.
     */
    public String getAuthor() {
        return editor;  // 👈 Se interpreta "editor" como "autor" para orden
    }

    /**
     * Obtiene el número de edición de la revista.
     * @return La edición de la revista.
     */
    public int getEdition() {
        return edition;
    }

    /**
     * Obtiene el año de publicación de la revista.
     * @return El año de la revista.
     */
    public int getYear() {
        return year;
    }

    /**
     * Sobreescribe el método toString() para proporcionar una representación legible del objeto Magazine.
     * @return Una cadena que describe la revista.
     */
    @Override
    public String toString() {
        return "Título: " + title + ", Editor: " + editor +
                ", Edición: " + edition + ", Año: " + year;
    }
}