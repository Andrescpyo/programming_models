package practica_state;

import Contexto.Ascensor;
import Estados.Enservicio;
import Estados.Mantenimiento;
import Interfaces.Estado_ascensor;

import javax.swing.*;
import java.awt.*;

/**
 * La clase AscensorGUI actúa como el "Cliente" (Client) en el patrón State.
 * Crea una instancia del Contexto (Ascensor) y las instancias de los Estados Concretos
 * (Enservicio, Mantenimiento). Es responsable de configurar el estado inicial
 * del Contexto y de manejar las interacciones del usuario, lo que a su vez
 * provoca cambios en el estado del Contexto.
 */
public class AscensorGUI extends JFrame {

    // El "Contexto" (Ascensor) cuya lógica de comportamiento cambia según su estado.
    private final Ascensor ascensor = new Ascensor();
    // Las instancias de los "Estados Concretos". El Cliente las mantiene y las pasa
    // al Contexto cuando es necesario cambiar el estado.
    private final Estado_ascensor enServicio = new Enservicio();
    private final Estado_ascensor mantenimiento = new Mantenimiento();
    private final JLabel estadoLabel = new JLabel("Estado actual: Sin seleccionar");

    private final JTextArea historialArea = new JTextArea(10, 30);
    private final JScrollPane scrollPane = new JScrollPane(historialArea);

    /**
     * Constructor de la interfaz gráfica del ascensor.
     * Configura los componentes de la UI y los listeners de los botones.
     */
    public AscensorGUI() {
        setTitle("Gestión de Ascensor");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Configuración de la UI (etiquetas, áreas de texto, paneles, botones)
        estadoLabel.setHorizontalAlignment(JLabel.CENTER);
        estadoLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(estadoLabel, BorderLayout.NORTH);

        historialArea.setEditable(false);
        historialArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPane, BorderLayout.CENTER);

        JButton btnPedir = new JButton("Pedir Ascensor");
        JButton btnSalir = new JButton("Salir");
        JButton btnReparar = new JButton("Salir de Mantenimiento");

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panelBotones.add(btnPedir);
        panelBotones.add(btnReparar);
        panelBotones.add(btnSalir);
        add(panelBotones, BorderLayout.SOUTH);

        // *** Punto clave del patrón State: Establecer el estado inicial del Contexto ***
        ascensor.setEstado(enServicio);
        actualizarEstado(ascensor.obtenerEstado()); // Muestra el nombre del estado actual

        // Listener para el botón "Pedir Ascensor"
        btnPedir.addActionListener(e -> {
            // El cliente (GUI) es el que verifica el estado actual del ascensor
            // y decide qué acción tomar o qué mensaje mostrar, y lo más importante,
            // cuándo cambiar el estado del Contexto.
            if (ascensor.estaEnMantenimiento()) {
                // Si el ascensor está en mantenimiento según su lógica interna,
                // el cliente cambia explícitamente el objeto de estado del Contexto
                // a 'mantenimiento'. Esto refleja el comportamiento del patrón.
                ascensor.setEstado(mantenimiento);
                actualizarEstado(ascensor.obtenerEstado());
                mostrarMensaje("Ascensor en mantenimiento. No se puede usar ahora.", "Mantenimiento");
                agregarAlHistorial("Intento fallido de uso: Ascensor en mantenimiento.");
            } else {
                // Si no está en mantenimiento, permite al usuario solicitar un piso.
                String input = JOptionPane.showInputDialog(this,
                        "¿A qué piso desea ir? ", "Seleccionar Piso", JOptionPane.QUESTION_MESSAGE);
                if (input != null && !input.isBlank()) {
                    try {
                        int piso = Integer.parseInt(input);
                        if (piso >= 1 && piso <= 12) {
                            // Delega la operación 'usarAscensor' al Contexto.
                            // La lógica interna de 'usarAscensor' determinará si entra en mantenimiento.
                            String mensaje = ascensor.usarAscensor(piso);
                            mostrarMensaje(mensaje, "Ascensor");
                            agregarAlHistorial("Ascensor enviado al piso " + piso);

                            if (ascensor.estaEnMantenimiento()) {
                                // Si el Contexto (Ascensor) indica que entró en mantenimiento,
                                // el Cliente (GUI) actualiza el objeto de estado del Contexto.
                                ascensor.setEstado(mantenimiento);
                                actualizarEstado(ascensor.obtenerEstado());
                                agregarAlHistorial("Estado cambiado a: Mantenimiento");
                            }
                        } else {
                            mostrarMensaje("Piso inválido. El ascensor solo va del piso 1 al 12.", "Piso fuera de rango");
                            agregarAlHistorial("Intento de ir al piso " + piso + ": fuera del rango permitido.");
                        }
                    } catch (NumberFormatException ex) {
                        mostrarMensaje("Entrada inválida. Debe ser un número.", "Error");
                        agregarAlHistorial("Entrada inválida detectada.");
                    }
                }
            }
        });

        // Listener para el botón "Salir"
        btnSalir.addActionListener(e -> System.exit(0));

        // Listener para el botón "Salir de Mantenimiento"
        btnReparar.addActionListener(e -> {
            ascensor.resetearUso(); // Reinicia el contador de uso interno del Contexto.
            // El cliente cambia el objeto de estado del Contexto a "En Servicio".
            ascensor.setEstado(enServicio);
            actualizarEstado(ascensor.obtenerEstado());
            mostrarMensaje("El ascensor ha vuelto al servicio.", "Mantenimiento Finalizado");
            agregarAlHistorial("Ascensor reparado y en servicio.");
        });
    }

    /**
     * Actualiza la etiqueta de estado en la GUI.
     * @param estadoTexto El texto a mostrar como estado.
     */
    private void actualizarEstado(String estadoTexto) {
        estadoLabel.setText("Estado actual: " + estadoTexto);
    }

    /**
     * Muestra un cuadro de diálogo con un mensaje.
     * @param mensaje El mensaje a mostrar.
     * @param titulo El título del cuadro de diálogo.
     */
    private void mostrarMensaje(String mensaje, String titulo) {
        JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Añade un texto al historial de la GUI.
     * @param texto El texto a añadir.
     */
    private void agregarAlHistorial(String texto) {
        historialArea.append("• " + texto + "\n");
        historialArea.setCaretPosition(historialArea.getDocument().getLength());
    }

    /**
     * Método principal para iniciar la aplicación GUI.
     * @param args Argumentos de la línea de comandos (no usados).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AscensorGUI gui = new AscensorGUI();
            gui.setVisible(true);
        });
    }
}