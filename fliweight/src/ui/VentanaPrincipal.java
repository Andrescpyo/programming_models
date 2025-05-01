package ui;

import flyweight.Figura;
import flyweight.FiguraFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

/**
 * Clase que representa la ventana principal de la aplicación.
 * Actúa como el Cliente en el patrón Flyweight.
 * Crea y gestiona el estado extrínseco de las figuras.
 */
public class VentanaPrincipal extends JFrame {

    private JPanel panelDibujo;
    private String figuraActual = "";
    private int cantidad = 0;
    private Color[] colores;
    /**
     * 'figuraCompartida' es la referencia al objeto Flyweight obtenido de la FiguraFactory.
     * Esta única instancia se utiliza para dibujar múltiples figuras con diferentes estados extrínsecos.
     */
    private Figura figuraCompartida;

    public VentanaPrincipal() {
        setTitle("Ejemplo Flyweight con Figuras");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel de botones
        JPanel panelBotones = new JPanel();
        JButton btnTriangulo = new JButton("Crear Triángulo");
        JButton btnCuadrado = new JButton("Crear Cuadrado");
        JButton btnCirculo = new JButton("Crear Círculo");
        JButton btnSalir = new JButton("Salir");

        panelBotones.add(btnTriangulo);
        panelBotones.add(btnCuadrado);
        panelBotones.add(btnCirculo);
        panelBotones.add(btnSalir);
        add(panelBotones, BorderLayout.NORTH);

        // Panel de dibujo
        panelDibujo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Si hay una figura compartida y una cantidad especificada, dibuja las figuras.
                if (figuraCompartida != null && cantidad > 0 && colores != null) {
                    Random rand = new Random();
                    for (int i = 0; i < cantidad; i++) {
                        // Estado extrínseco: posición (x, y), tamaño y color aleatorio.
                        int x = rand.nextInt(getWidth() - 50);
                        int y = rand.nextInt(getHeight() - 50);
                        int size = 20 + rand.nextInt(30);
                        g.setColor(colores[i]);
                        // Se llama al método dibujar del objeto Flyweight, pasando el estado extrínseco.
                        figuraCompartida.dibujar(g, x, y, size, colores[i]);
                    }
                }
            }
        };
        add(panelDibujo, BorderLayout.CENTER);

        // Eventos de los botones para crear diferentes tipos de figuras.
        btnTriangulo.addActionListener((ActionEvent e) -> crearFiguras("triangulo"));
        btnCuadrado.addActionListener((ActionEvent e) -> crearFiguras("cuadrado"));
        btnCirculo.addActionListener((ActionEvent e) -> crearFiguras("circulo"));
        btnSalir.addActionListener(e -> System.exit(0));
    }

    /**
     * Método para solicitar la cantidad de figuras a crear y obtener el Flyweight correspondiente.
     *
     * @param tipo El tipo de figura a crear.
     */
    private void crearFiguras(String tipo) {
        String input = JOptionPane.showInputDialog(this, "¿Cuántas figuras desea dibujar?", "Cantidad", JOptionPane.QUESTION_MESSAGE);
        try {
            int cantidadSolicitada = Integer.parseInt(input);
            if (cantidadSolicitada > 0) {
                figuraActual = tipo;
                cantidad = cantidadSolicitada;
                /**
                 * Se obtiene una única instancia del Flyweight (la Figura) desde la fábrica
                 * para el tipo de figura solicitado. Todas las figuras del mismo tipo compartirán
                 * esta misma instancia.
                 */
                figuraCompartida = FiguraFactory.getFigura(tipo); // ✅ SE CREA SOLO UNA VEZ AQUÍ
                generarColoresAleatorios();
                panelDibujo.repaint();
            } else {
                JOptionPane.showMessageDialog(this, "Por favor ingrese un número mayor que cero.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Entrada inválida. Ingrese un número entero.");
        }
    }

    /**
     * Genera un array de colores aleatorios para cada figura que se va a dibujar.
     * Este es parte del estado extrínseco.
     */
    private void generarColoresAleatorios() {
        colores = new Color[cantidad];
        Random rand = new Random();
        for (int i = 0; i < cantidad; i++) {
            colores[i] = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
        }
    }
}