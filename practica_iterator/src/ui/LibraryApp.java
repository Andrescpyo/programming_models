package ui;

import collection.BookCollection;
import collection.MagazineCollection;
import collection.MyCollection;
import collection.ThesisCollection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Iterator;
import model.Book;
import model.Magazine;
import model.Thesis;

/**
 * Clase principal de la aplicación GUI que demuestra el uso del patrón Iterator.
 * Actúa como el "Cliente" (Client) en el patrón, ya que utiliza las interfaces
 * MyCollection y MyIterator para interactuar con las colecciones y sus elementos
 * sin conocer su estructura interna.
 */
public class LibraryApp extends JFrame {

    private JTextArea textArea;
    // currentCollection es la "interfaz Agregado" (MyCollection) que se usa para
    // interactuar con la colección actualmente seleccionada (Libros, Revistas, Tesis).
    // Esto permite que el cliente trabaje con diferentes tipos de colecciones de manera uniforme.
    private MyCollection<?> currentCollection;
    private String currentType;
    private JPanel buttonPanel;

    // Colecciones concretas de los "Agregados Concretos".
    // Estas son las implementaciones específicas de MyCollection.
    private final BookCollection bookCollection = new BookCollection();
    private final MagazineCollection magazineCollection = new MagazineCollection();
    private final ThesisCollection thesisCollection = new ThesisCollection();

    /**
     * Constructor de la aplicación LibraryApp. Configura la interfaz de usuario
     * y carga los datos de ejemplo.
     */
    public LibraryApp() {
        setTitle("Biblioteca");
        setSize(300, 250); // Tamaño inicial pequeño
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); // Evita el cierre directo
        setLocationRelativeTo(null); // Centra la ventana
        setLayout(new GridBagLayout());

        // Cargar datos de ejemplo en cada colección al iniciar la aplicación.
        bookCollection.loadSampleData();
        magazineCollection.loadSampleData();
        thesisCollection.loadSampleData();

        // Manejar cierre con "X" de manera personalizada.
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                JOptionPane.showMessageDialog(
                    LibraryApp.this,
                    "No puedes :(",
                    "Acción no permitida",
                    JOptionPane.WARNING_MESSAGE
                );
            }
        });

        // Muestra el menú principal al inicio.
        showMainMenu();
    }

    /**
     * Muestra el menú principal con opciones para seleccionar el tipo de colección.
     */
    private void showMainMenu() {
        getContentPane().removeAll(); // Limpia el contenido anterior
        setLayout(new GridBagLayout()); // Establece el layout para el menú

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 30, 10, 30); // Espaciado entre componentes
        gbc.fill = GridBagConstraints.HORIZONTAL; // Rellena el espacio horizontal
        gbc.gridx = 0; // Columna 0

        JButton btnBooks = new JButton("Libros");
        JButton btnMagazines = new JButton("Revistas");
        JButton btnTheses = new JButton("Tesis");
        JButton btnExit = new JButton("Salir");

        // Configura el tamaño preferido para los botones del menú.
        for (JButton btn : new JButton[]{btnBooks, btnMagazines, btnTheses, btnExit}) {
            btn.setPreferredSize(new Dimension(200, 30));
        }

        // Asigna acciones a los botones para cargar la colección correspondiente
        // o salir de la aplicación.
        btnBooks.addActionListener(e -> loadCollection("Books"));
        btnMagazines.addActionListener(e -> loadCollection("Magazines"));
        btnTheses.addActionListener(e -> loadCollection("Theses"));
        btnExit.addActionListener(e -> System.exit(0)); // Salir de la aplicación

        // Añade los botones al panel con las restricciones de GridBagLayout.
        gbc.gridy = 0;
        add(btnBooks, gbc);
        gbc.gridy = 1;
        add(btnMagazines, gbc);
        gbc.gridy = 2;
        add(btnTheses, gbc);
        gbc.gridy = 3;
        add(btnExit, gbc);

        setSize(300, 250); // Ajusta el tamaño de la ventana para el menú
        revalidate(); // Revalida el contenedor para que los cambios de UI se apliquen
        repaint(); // Repinta el contenedor
    }

    /**
     * Carga la colección seleccionada (Libros, Revistas o Tesis) y actualiza la vista.
     * @param type El tipo de colección a cargar ("Books", "Magazines", "Theses").
     */
    private void loadCollection(String type) {
        currentType = type;
        switch (type) {
            case "Books" -> currentCollection = bookCollection;
            case "Magazines" -> currentCollection = magazineCollection;
            case "Theses" -> currentCollection = thesisCollection;
        }
        showCollectionView(); // Muestra la vista de la colección cargada.
    }

    /**
     * Muestra la vista de la colección seleccionada, incluyendo el área de texto
     * para mostrar los elementos y los botones para diferentes modos de iteración.
     */
    private void showCollectionView() {
        getContentPane().removeAll(); // Limpia el contenido anterior
        setLayout(new BorderLayout()); // Establece el layout para la vista de colección

        // Área de texto para mostrar los elementos.
        textArea = new JTextArea();
        textArea.setEditable(false); // No permite edición manual
        textArea.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        add(new JScrollPane(textArea), BorderLayout.CENTER); // Añade con scroll

        // Panel de botones para controlar la iteración y agregar elementos.
        buttonPanel = new JPanel();
        JButton btnNormal = new JButton("Orden Normal");
        JButton btnReverse = new JButton("Orden Inverso");
        JButton btnAuthor = new JButton("Por Autor");
        JButton btnAdd = new JButton("Agregar");
        JButton btnVolver = new JButton("Volver");

        // Asigna acciones a los botones para cambiar el modo de visualización (iteración)
        // o volver al menú principal/agregar elementos.
        btnNormal.addActionListener(e -> display("normal"));
        btnReverse.addActionListener(e -> display("reverse"));
        btnAuthor.addActionListener(e -> display("author"));
        btnVolver.addActionListener(e -> showMainMenu());
        btnAdd.addActionListener(e -> agregarElemento());

        // Añade los botones al panel.
        buttonPanel.add(btnNormal);
        buttonPanel.add(btnReverse);
        buttonPanel.add(btnAuthor);
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnVolver);

        add(buttonPanel, BorderLayout.NORTH); // Añade el panel de botones en la parte superior

        display("normal"); // Muestra la colección en orden normal por defecto al cargarla

        setSize(600, 500); // Ajusta el tamaño de la ventana para la vista de colección
        revalidate();
        repaint();
    }

    /**
     * Muestra los elementos de la colección actual en el área de texto,
     * utilizando el iterador apropiado según el modo seleccionado.
     * Esta es la parte donde el "Cliente" interactúa con la "interfaz Iterador".
     * @param mode El modo de iteración ("normal", "reverse", "author").
     */
    private void display(String mode) {
        textArea.setText(""); // Limpia el área de texto

        // Se solicita al "Agregado" (currentCollection) que cree el "Iterador" (Iterator)
        // adecuado según el modo. Esto desacopla al cliente de la implementación concreta del iterador.
        Iterator<?> iterator = switch (mode) {
            case "normal" -> currentCollection.createIterator(); // Iterador en orden normal
            case "reverse" -> currentCollection.createReverseIterator(); // Iterador en orden inverso
            case "author" -> currentCollection.createAuthorAlphabeticalIterator(); // Iterador por autor
            default -> null;
        };

        // Si se obtuvo un iterador válido, se procede a recorrer la colección.
        // El cliente usa los métodos hasNext() y next() de la interfaz Iterator
        // sin saber cómo se implementa internamente la iteración.
        if (iterator != null) {
            while (iterator.hasNext()) {
                textArea.append("- " + iterator.next().toString() + "\n");
            }
        } else {
            textArea.append("No se pudo generar el iterador.\n");
        }
    }

    /**
     * Abre diálogos para agregar un nuevo elemento a la colección actual,
     * pidiendo los detalles específicos del tipo de elemento.
     */
    private void agregarElemento() {
        switch (currentType) {
            case "Books" -> {
                String titulo = JOptionPane.showInputDialog(this, "Título del libro:");
                String autor = JOptionPane.showInputDialog(this, "Autor:");
                String genero = JOptionPane.showInputDialog(this, "Género:");
                // Manejo básico de errores para la entrada de año.
                int año = -1;
                try {
                    año = Integer.parseInt(JOptionPane.showInputDialog(this, "Año:"));
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Año inválido. Por favor, introduce un número.");
                    return;
                }
                bookCollection.addItem(new Book(titulo, autor, genero, año));
            }
            case "Magazines" -> {
                String titulo = JOptionPane.showInputDialog(this, "Título de la revista:");
                String autor = JOptionPane.showInputDialog(this, "Autor:");
                int edicion = -1;
                try {
                    edicion = Integer.parseInt(JOptionPane.showInputDialog(this, "Edición:"));
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Edición inválida. Por favor, introduce un número.");
                    return;
                }
                int año = -1;
                try {
                    año = Integer.parseInt(JOptionPane.showInputDialog(this, "Año:"));
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Año inválido. Por favor, introduce un número.");
                    return;
                }
                magazineCollection.addItem(new Magazine(titulo, autor, edicion, año));
            }
            case "Theses" -> {
                String titulo = JOptionPane.showInputDialog(this, "Título de la tesis:");
                String autor = JOptionPane.showInputDialog(this, "Autor:");
                String asesor = JOptionPane.showInputDialog(this, "Asesor:");
                int año = -1;
                try {
                    año = Integer.parseInt(JOptionPane.showInputDialog(this, "Año:"));
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Año inválido. Por favor, introduce un número.");
                    return;
                }
                thesisCollection.addItem(new Thesis(titulo, autor, asesor, año));
            }
        }
        display("normal"); // Actualizar la vista después de agregar un elemento.
    }
}