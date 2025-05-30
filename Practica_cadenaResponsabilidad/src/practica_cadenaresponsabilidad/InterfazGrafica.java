package practica_cadenaresponsabilidad;

import Interfaces.Manejo_principal;
import Manejos_concretos.*; // Importa todos los manejadores concretos

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Esta clase gestiona la interfaz gráfica de usuario para el ejemplo del patrón Chain of Responsibility.
 * Actúa como el **Client** (Cliente) que inicia la petición y la envía a la cadena de manejadores.
 */
public class InterfazGrafica extends JFrame {

    private JPanel panelPrincipal, panelResultado;
    private JTextArea areaResultado;
    // Esta es la referencia al primer manejador de la cadena, el punto de entrada para las peticiones.
    private Manejo_principal cadena;

    /**
     * Constructor de la InterfazGrafica. Configura la ventana principal y los paneles.
     */
    public InterfazGrafica() {
        setTitle("Petición de Nota");
        setSize(250, 120);  // Tamaño pequeño inicial
        setResizable(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); // Evita cerrar la ventana directamente
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                JOptionPane.showMessageDialog(
                        InterfazGrafica.this,
                        "no puedes :(",
                        "Acción no permitida",
                        JOptionPane.WARNING_MESSAGE
                );

            }
        });
        setLocationRelativeTo(null);
        setLayout(new CardLayout()); // Permite alternar entre paneles

        // Se inicializa la cadena de responsabilidad aquí.
        inicializarCadenaResponsabilidad();
        crearPanelPrincipal();
        crearPanelResultado();

        add(panelPrincipal, "principal");
        add(panelResultado, "resultado");

        mostrarPanel("principal"); // Muestra el panel inicial
    }

    /**
     * Este método es crucial para el patrón Chain of Responsibility.
     * Aquí se construye la **cadena de manejadores**.
     * Cada manejador se enlaza con el siguiente, formando una secuencia de procesamiento.
     * En este caso, la petición comienza con el Profesor, luego pasa a Coordinación, luego a Decanatura, y finalmente a Rectoría.
     */
    private void inicializarCadenaResponsabilidad() {
        // Se construye la cadena de forma que cada manejador "conoce" a su sucesor.
        // La petición fluirá desde Profesor hasta Rectoria si no es manejada antes.
        cadena = new Profesor( // Profesor es el primer manejador en recibir la petición
                new Coordinacion( // Si Profesor no maneja, pasa a Coordinación
                        new Decanatura( // Si Coordinación no maneja, pasa a Decanatura
                                new Rectoria() // Si Decanatura no maneja, pasa a Rectoría (último en la cadena, siempre responde)
                        )
                )
        );
    }

    /**
     * Crea y configura el panel principal con los botones de acción.
     */
    private void crearPanelPrincipal() {
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(2, 1, 8, 8));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(15, 40, 15, 40));

        JButton btnPeticion = new JButton("Hacer Petición");
        JButton btnSalir = new JButton("Salir");

        Dimension tamBoton = new Dimension(120, 25);
        btnPeticion.setPreferredSize(tamBoton);
        btnSalir.setPreferredSize(tamBoton);

        // Cuando se hace clic en "Hacer Petición", se invoca el método hacerPeticion,
        // que a su vez iniciará el flujo de la cadena de responsabilidad.
        btnPeticion.addActionListener(this::hacerPeticion);
        btnSalir.addActionListener(e -> System.exit(0));

        panelPrincipal.add(btnPeticion);
        panelPrincipal.add(btnSalir);
    }

    /**
     * Crea y configura el panel donde se mostrarán los resultados de la petición.
     */
    private void crearPanelResultado() {
        panelResultado = new JPanel(new BorderLayout(10, 10));
        areaResultado = new JTextArea();
        areaResultado.setEditable(false);
        areaResultado.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        areaResultado.setLineWrap(true);
        areaResultado.setWrapStyleWord(true);

        JScrollPane scroll = new JScrollPane(areaResultado);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        JButton volver = new JButton("Volver");
        volver.setPreferredSize(new Dimension(80, 25));
        volver.addActionListener(e -> {
            setSize(250, 120);  // Vuelve al tamaño pequeño
            mostrarPanel("principal");
        });

        JPanel contenedorBoton = new JPanel();
        contenedorBoton.add(volver);

        panelResultado.add(scroll, BorderLayout.CENTER);
        panelResultado.add(contenedorBoton, BorderLayout.SOUTH);
    }

    /**
     * Este método es el punto de **inicio de la petición** por parte del cliente.
     * Captura la petición del usuario y la envía al primer manejador de la cadena.
     * La cadena se encarga de determinar quién la procesará.
     *
     * @param e El evento de acción.
     */
    private void hacerPeticion(ActionEvent e) {
        String peticion = JOptionPane.showInputDialog(this, "¿Cuál es tu petición?", "Petición", JOptionPane.QUESTION_MESSAGE);
        if (peticion != null && !peticion.trim().isEmpty()) {
            StringBuilder historial = new StringBuilder();
            historial.append("Estudiante solicita: ").append(peticion).append("\n\n");
            // Aquí se envía la petición al primer manejador de la cadena.
            // El cliente no necesita saber quién maneja la petición, solo la envía a la cadena.
            cadena.manejarPeticion(peticion, historial);
            areaResultado.setText(historial.toString());

            setSize(500, 350);  // Tamaño mediano para mostrar resultados
            mostrarPanel("resultado");
        } else if (peticion != null) {
            JOptionPane.showMessageDialog(this, "Por favor escribe una petición válida.");
        }
    }

    /**
     * Muestra un panel específico usando CardLayout.
     * @param nombre El nombre del panel a mostrar.
     */
    private void mostrarPanel(String nombre) {
        CardLayout cl = (CardLayout) getContentPane().getLayout();
        cl.show(getContentPane(), nombre);
    }
}