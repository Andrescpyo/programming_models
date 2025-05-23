package practica_interpretador;

/**
 * Esta clase implementa la interfaz gráfica de usuario para la calculadora,
 * diseñada para construir expresiones en notación polaca inversa (RPN).
 * Permite al usuario introducir números, operadores y **espacios**,
 * **eliminar el último carácter ingresado**, y al presionar '=',
 * la expresión RPN se evalúa utilizando el patrón Interpreter.
 *
 * @author Andrés Cerdas Padilla, 20231020053.
 * @author Ana Karina Roa Mora. 20232020118.
 */
import Contexto.Analizador; // Importa la clase Analizador para interpretar las expresiones
import java.awt.BorderLayout; // Para organizar componentes en la ventana
import java.awt.Font; // Para controlar el tamaño y estilo de la fuente
import java.awt.GridLayout; // Para organizar botones en una cuadrícula
import java.awt.event.ActionEvent; // Para manejar eventos de los botones
import java.awt.event.ActionListener; // Interfaz para manejar eventos
import javax.swing.JButton; // Componente para botones
import javax.swing.JFrame; // Ventana principal de la aplicación
import javax.swing.JPanel; // Contenedor genérico
import javax.swing.JTextField; // Campo de texto para la pantalla de la calculadora
import javax.swing.SwingUtilities; // Utilidad para manejar el hilo de eventos de Swing

public class CalculadoraGUI extends JFrame implements ActionListener {

    private JTextField pantalla; // Campo de texto donde se muestran los números y el resultado.
    // StringBuilder para construir la expresión en notación polaca inversa de manera eficiente.
    private StringBuilder expresionRPN = new StringBuilder();

    /**
     * Constructor de la CalculadoraGUI.
     * Configura la ventana principal, la pantalla y los botones de la calculadora.
     */
    public CalculadoraGUI() {
        super("Calculadora Interpreter RPN"); // Establece el título de la ventana.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define qué hacer al cerrar la ventana.
        setSize(400, 400); // Establece el tamaño de la ventana.
        setLocationRelativeTo(null); // Centra la ventana en la pantalla.

        // Configuración del componente de la pantalla.
        pantalla = new JTextField("0"); // Inicializa con "0".
        pantalla.setEditable(false); // La pantalla no es editable directamente por el usuario.
        pantalla.setHorizontalAlignment(JTextField.RIGHT); // Alinea el texto a la derecha.

        // --- Modificación aquí: Ajustar el tamaño de la fuente de la pantalla ---
        // Puedes cambiar el tamaño (ej. 30) y el estilo (ej. Font.BOLD, Font.PLAIN)
        pantalla.setFont(new Font("Arial", Font.BOLD, 30));
        // --- Fin de modificación ---

        add(pantalla, BorderLayout.NORTH); // Añade la pantalla en la parte superior de la ventana.

        // Panel para organizar los botones.
        JPanel panelBotones = new JPanel();
        // Ajustamos GridLayout para acomodar el nuevo botón "DEL".
        // Sugiero una cuadrícula de 5 filas por 4 columnas para una buena distribución.
        panelBotones.setLayout(new GridLayout(5, 4, 5, 5));

        // Textos de los botones de la calculadora, incluyendo "DEL".
        String[] botones = {
            "7", "8", "9", "+",
            "4", "5", "6", "-",
            "1", "2", "3", "Space",
            "0", "DEL", "C", "=" // Botones de control en la última fila
        };

        for (String textoBoton : botones) {
            JButton boton = new JButton(textoBoton); // Crea un nuevo botón.
            boton.addActionListener(this); // Asigna el ActionListener a este botón.
            // Opcional: Aumentar el tamaño de la fuente de los botones para mejor legibilidad
            boton.setFont(new Font("Arial", Font.PLAIN, 15));
            panelBotones.add(boton); // Añade el botón al panel de botones.
        }

        add(panelBotones, BorderLayout.CENTER); // Añade el panel de botones en el centro de la ventana.
    }

    /**
     * Método **actionPerformed()**: Maneja los eventos de clic de los botones.
     * Es invocado cuando un botón de la calculadora es presionado.
     *
     * @param e El evento de acción generado por el clic del botón.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand(); // Obtiene el texto del botón que fue presionado.

        // Lógica para manejar diferentes tipos de botones.
        if (comando.equals("=")) {
            // Si el botón '=' es presionado, se evalúa la expresión RPN actual.
            try {
                // Elimina cualquier espacio final extra si lo hubiera.
                String expresionFinal = expresionRPN.toString().trim();
                if (expresionFinal.isEmpty()) {
                    pantalla.setText("0"); // Si no hay nada, mostrar 0.
                    return;
                }

                // Crea una instancia de Analizador con la expresión RPN construida.
                Analizador analizador = new Analizador(expresionFinal);
                int resultado = analizador.evaluar(); // Evalúa la expresión usando el Interpreter.
                pantalla.setText(String.valueOf(resultado)); // Muestra el resultado en la pantalla.
                expresionRPN.setLength(0); // Limpia la expresión RPN después de evaluar.
                expresionRPN.append(resultado); // El resultado se convierte en la nueva "entrada" si se desea continuar operando.
            } catch (Exception ex) {
                // En caso de error (ej. expresión inválida), muestra "Error" y limpia la expresión.
                pantalla.setText("Error");
                expresionRPN.setLength(0); // Limpia la expresión RPN.
            }
        } else if (comando.equals("C")) {
            // Si el botón 'C' (Clear) es presionado, limpia la pantalla y la expresión RPN.
            pantalla.setText("0");
            expresionRPN.setLength(0); // Vacía el StringBuilder.
        } else if (comando.equals("DEL")) {
            if (expresionRPN.length() > 0) {
                expresionRPN.deleteCharAt(expresionRPN.length() - 1); // Elimina el último carácter.
                if (expresionRPN.length() == 0) {
                    pantalla.setText("0"); // Si no queda nada, muestra "0".
                } else {
                    pantalla.setText(expresionRPN.toString()); // Actualiza la pantalla.
                }
            }
            
        } else if (comando.equals("Space")) {
            // Si el botón 'Space' es presionado, añade un espacio si la expresión no está vacía
            // y el último carácter no es ya un espacio.
            if (expresionRPN.length() > 0 && expresionRPN.charAt(expresionRPN.length() - 1) != ' ') {
                expresionRPN.append(" ");
            }
            // Muestra la expresión actual en la pantalla. Usamos trim() para que no muestre el espacio final si existe.
            pantalla.setText(expresionRPN.toString().trim());
        } else if (comando.equals("+") || comando.equals("-")) {
            // Si el botón es un operador (+ o -).
            // Siempre añade un espacio antes del operador si la expresión no está vacía
            // y el último carácter no es ya un espacio.
            if (expresionRPN.length() > 0 && expresionRPN.charAt(expresionRPN.length() - 1) != ' ') {
                 expresionRPN.append(" ");
            }
            expresionRPN.append(comando); // Añade el operador.
            pantalla.setText(expresionRPN.toString()); // Actualiza la pantalla.
        } else {
            // Si el botón es un número (0-9).
            // Si la pantalla muestra "0" y es el inicio de la entrada, sobrescribe ese "0".
            if (pantalla.getText().equals("0") && expresionRPN.length() == 0) {
                pantalla.setText(""); // Limpia la pantalla.
            }
            expresionRPN.append(comando); // Añade el dígito al número actual.
            pantalla.setText(expresionRPN.toString()); // Muestra la expresión actual.
        }
    }
}