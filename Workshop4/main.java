package Workshop4;

import Workshop4.ConcreteBuilders.HamburguesaClasicaBuilder;
import Workshop4.ConcreteBuilders.HamburguesaDobleTocinoBuilder;
import Workshop4.ConcreteBuilders.HamburguesaVegetarianaBuilder;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                crearGUI();
            }
        });
    }

    private static void crearGUI() {
        JFrame frame = new JFrame("Constructor de Hamburguesas (Builder Pattern)");
        frame.setSize(400, 250); // Aumenta el tamaño del frame para el padding
        frame.setLayout(new GridLayout(3, 1));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] hamburguesas = {"Clásica", "Doble Tocino", "Vegetariana"};
        JComboBox<String> hamburguesaComboBox = new JComboBox<>(hamburguesas);
        hamburguesaComboBox.setPreferredSize(new Dimension(200, 30)); // Ajusta el tamaño del JComboBox
        agregarPadding(hamburguesaComboBox, 10);
        frame.add(hamburguesaComboBox);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton construirButton = new JButton("Construir Hamburguesa");
        construirButton.setPreferredSize(new Dimension(200, 50));
        agregarPadding(construirButton, 10);
        buttonPanel.add(construirButton);
        frame.add(buttonPanel);

        JTextArea resultadoArea = new JTextArea();
        resultadoArea.setEditable(false);
        agregarPadding(resultadoArea, 10);
        frame.add(new JScrollPane(resultadoArea));

        construirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String seleccion = (String) hamburguesaComboBox.getSelectedItem();
                HamburguesaBuilder builder = null;

                switch (seleccion) {
                    case "Clásica":
                        builder = new HamburguesaClasicaBuilder();
                        break;
                    case "Doble Tocino":
                        builder = new HamburguesaDobleTocinoBuilder();
                        break;
                    case "Vegetariana":
                        builder = new HamburguesaVegetarianaBuilder();
                        break;
                }

                if (builder != null) {
                    Hamburguesa hamburguesa = builder.build();
                    resultadoArea.setText(formatearHamburguesa(hamburguesa));
                }
            }
        });

        frame.setVisible(true);
    }

    private static void agregarPadding(JComponent component, int padding) {
        component.setBorder(new EmptyBorder(padding, padding, padding, padding));
    }

    private static String formatearHamburguesa(Hamburguesa hamburguesa) {
        return "Hamburguesa:\n" +
                "Pan: " + hamburguesa.getPan() + "\n" +
                "Carne: " + hamburguesa.getCarne() + "\n" +
                "Queso: " + hamburguesa.getQueso() + "\n" +
                "Salsa: " + hamburguesa.getSalsa() + "\n" +
                "Vegetales: " + hamburguesa.getVegetales() + "\n" +
                "Extras: " + hamburguesa.getExtras();
    }
}