package practica_bridge;

import Abstraccion.*;
import Implementador.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BridgeGUI extends JFrame implements ActionListener {

    private JComboBox<String> prendaComboBox;
    private JComboBox<String> colorComboBox;
    private JButton agregarPrendaButton;
    private JButton mostrarTodasButton;
    private JButton cerrarButton; // Nuevo botón para cerrar
    private JTextArea resultadoTextArea;
    private JScrollPane resultadoScrollPane;

    private Map<String, Seleccion_color> coloresMap;
    private List<Abstract_prenda> prendasSeleccionadas;

    public BridgeGUI() {
        // Inicializar el mapa de colores
        coloresMap = new HashMap<>();
        coloresMap.put("Rojo", new Rojo());
        coloresMap.put("Azul", new Azul());
        coloresMap.put("Amarillo", new Amarillo());
        coloresMap.put("Lila", new Lila());
        coloresMap.put("Naranja", new Naranja());
        coloresMap.put("Verde Agua Marina", new VerdeAguaMarina());

        // Inicializar la lista de prendas seleccionadas
        prendasSeleccionadas = new ArrayList<>();

        // Configurar la ventana principal
        setTitle("Selector de Prendas Múltiples");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la aplicación al cerrar la ventana
        setLayout(new GridBagLayout()); // Usamos GridBagLayout
        setSize(450, 350); // Aumentamos un poco la altura

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Márgenes entre componentes
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1; // Cada componente ocupa una columna por defecto
        gbc.weightx = 0.5; // Distribuir espacio horizontal entre columnas de botones

        // Etiqueta "Seleccione una prenda:"
        JLabel prendaLabel = new JLabel("Seleccione una prenda:");
        add(prendaLabel, gbc);

        // ComboBox de prendas
        gbc.gridy++;
        add(prendaComboBox = new JComboBox<>(new String[]{"Chaqueta", "Buzo", "Pantalon", "Sombrero", "Camiseta"}), gbc);

        // Etiqueta "Seleccione un color:"
        gbc.gridy++;
        JLabel colorLabel = new JLabel("Seleccione un color:");
        add(colorLabel, gbc);

        // ComboBox de colores
        gbc.gridy++;
        add(colorComboBox = new JComboBox<>(coloresMap.keySet().toArray(new String[0])), gbc);

        // Fila para los botones Agregar y Mostrar
        gbc.gridy++;
        gbc.gridx = 0;
        add(agregarPrendaButton = new JButton("Agregar Prenda"), gbc);
        agregarPrendaButton.addActionListener(this);

        gbc.gridx = 1; // Cambiamos a la siguiente columna en la misma fila
        add(mostrarTodasButton = new JButton("Mostrar Todas las Prendas"), gbc);
        mostrarTodasButton.addActionListener(this);

        // Botón "Cerrar"
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2; // El botón de cerrar ocupa ambas columnas para centrarlo
        gbc.weightx = 0.0; // No necesitamos distribución de peso en esta fila
        gbc.fill = GridBagConstraints.HORIZONTAL; // Ocupa el ancho disponible
        add(cerrarButton = new JButton("Cerrar"), gbc);
        cerrarButton.addActionListener(this);

        // Área de texto para resultados
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2; // El área de texto ocupa ambas columnas
        gbc.weighty = 1.0; // Para que el área de texto se expanda verticalmente
        gbc.fill = GridBagConstraints.BOTH; // Para que se expanda en ambas direcciones
        add(resultadoScrollPane = new JScrollPane(resultadoTextArea = new JTextArea(10, 30)), gbc);
        resultadoTextArea.setEditable(false);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == agregarPrendaButton) {
            String prendaSeleccionadaTexto = (String) prendaComboBox.getSelectedItem();
            String colorSeleccionadoTexto = (String) colorComboBox.getSelectedItem();
            Seleccion_color colorImplementacion = coloresMap.get(colorSeleccionadoTexto);
            Abstract_prenda prenda = null;

            switch (prendaSeleccionadaTexto) {
                case "Chaqueta":
                    prenda = new Chaqueta(colorImplementacion);
                    break;
                case "Buzo":
                    prenda = new Buzo(colorImplementacion);
                    break;
                case "Pantalon":
                    prenda = new Pantalon(colorImplementacion);
                    break;
                case "Sombrero":
                    prenda = new Sombrero(colorImplementacion);
                    break;
                case "Camiseta":
                    prenda = new Camiseta(colorImplementacion);
                    break;
            }

            if (prenda != null) {
                prendasSeleccionadas.add(prenda);
                resultadoTextArea.append("Se agregó: ");
                prenda.prenda(); // Imprime en consola
                resultadoTextArea.append(colorSeleccionadoTexto + "\n");
            }
        } else if (e.getSource() == mostrarTodasButton) {
            resultadoTextArea.setText(""); // Limpiar el área de texto antes de mostrar
            if (prendasSeleccionadas.isEmpty()) {
                resultadoTextArea.append("No se ha seleccionado ninguna prenda.\n");
            } else {
                resultadoTextArea.append("Prendas Seleccionadas:\n");
                for (Abstract_prenda prenda : prendasSeleccionadas) {
                    prenda.prenda(); // Imprime en consola
                    String prendaTexto = "";
                    if (prenda instanceof Chaqueta) prendaTexto = "Chaqueta";
                    else if (prenda instanceof Buzo) prendaTexto = "Buzo";
                    else if (prenda instanceof Pantalon) prendaTexto = "Pantalon";
                    else if (prenda instanceof Sombrero) prendaTexto = "Sombrero";
                    else if (prenda instanceof Camiseta) prendaTexto = "Camiseta";

                    String colorTexto = "";
                    for (Map.Entry<String, Seleccion_color> entry : coloresMap.entrySet()) {
                        if (entry.getValue().equals(prenda.tono)) {
                            colorTexto = entry.getKey();
                            break;
                        }
                    }
                    resultadoTextArea.append(prendaTexto + " de color " + colorTexto + "\n");
                }
            }
        } else if (e.getSource() == cerrarButton) {
            // Cierra la ventana y termina la aplicación
            dispose(); // Libera los recursos de la ventana
            System.exit(0); // Termina la JVM
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BridgeGUI());
    }
}