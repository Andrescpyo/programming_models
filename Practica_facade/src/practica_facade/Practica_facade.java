package practica_facade;

import Facade.*;
import Cliente.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Clase principal que demuestra el uso del patrón Facade para la solicitud de préstamos.
 * También incluye una interfaz gráfica simple para interactuar con el sistema.
 *
 * @author Andrés Cerdas Padilla, 20231020053
 * @author Ana Karina Roa Mora, 20232020118
 */
public class Practica_facade extends JFrame implements ActionListener {

    private JTextField nombreTextField;
    private JButton verificarButton;
    private JLabel resultadoLabel;
    private JTextArea outputTextArea;
    private FacadePrestamo facadePrestamo;

    /**
     * Constructor de la interfaz gráfica.
     */
    public Practica_facade() {
        super("Solicitud de Préstamo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 350); // Aumentamos la altura para dar espacio
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10)); // Usamos FlowLayout para disposición vertical

        JLabel nombreLabel = new JLabel("Nombre del Cliente:");
        nombreTextField = new JTextField(20);
        verificarButton = new JButton("Verificar Préstamo");

        resultadoLabel = new JLabel("Resultado:");

        outputTextArea = new JTextArea(10, 30);
        outputTextArea.setEditable(false);
        JScrollPane outputScrollPane = new JScrollPane(outputTextArea);

        verificarButton.addActionListener(this);

        add(nombreLabel);
        add(nombreTextField);
        add(verificarButton);
        add(Box.createVerticalStrut(10)); // Espacio vertical
        add(outputScrollPane);
        add(Box.createVerticalStrut(10)); // Espacio vertical
        add(resultadoLabel);

        // Redirigimos la salida de System.out al JTextArea
        System.setOut(new PrintStream(new OutputStream() {
            @Override
            public void write(int b) {
                outputTextArea.append(String.valueOf((char) b));
                outputTextArea.setCaretPosition(outputTextArea.getDocument().getLength());
            }
        }));

        facadePrestamo = new FacadePrestamo();
        setVisible(true);
    }

    /**
     * Maneja el evento del clic en el botón "Verificar Préstamo".
     * Obtiene el nombre del cliente de la interfaz, crea un objeto Cliente,
     * y utiliza la fachada para verificar si el préstamo es aprobado.
     * La fachada ahora gestiona el otorgamiento del préstamo y la salida se redirige al JTextArea.
     * Muestra el resultado final de la aprobación en la etiqueta.
     *
     * @param e El evento de acción.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == verificarButton) {
            String nombreCliente = nombreTextField.getText();
            Cliente.cliente cliente = new Cliente.cliente(nombreCliente);
            cliente.impre();

            // Limpiamos el área de texto antes de una nueva verificación
            outputTextArea.setText("");
            cliente.impre();

            // Utilizamos la fachada para verificar si el cliente cumple con los requisitos del préstamo.
            boolean aprobado = facadePrestamo.verificarPrestamo(cliente);

            // Mostramos el resultado final de la aprobación en la etiqueta.
            resultadoLabel.setText("Préstamo Aprobado: " + aprobado);
        }
    }

    /**
     * Método principal para ejecutar la aplicación.
     *
     * @param args Los argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        // Crea e inicia la interfaz gráfica en el hilo de eventos de Swing.
        SwingUtilities.invokeLater(Practica_facade::new);
    }
}