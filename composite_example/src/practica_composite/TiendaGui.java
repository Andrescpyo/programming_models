package practica_composite;

import abstraccion.*; // Importa las clases de la capa de abstracción
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;

/**
 * Clase Cliente (TiendaGui):
 * Esta clase utiliza la estructura del patrón Composite para mostrar
 * una representación jerárquica de productos y paquetes en una interfaz gráfica.
 * El cliente interactúa con los objetos Item_comp a través de la interfaz común.
 */
public class TiendaGui extends JFrame {
    public TiendaGui() {
        /** 
        * Constructor de la clase TiendaGui.
        * Inicializa la ventana principal de la aplicación.
        */
        setTitle("Tienda Unificada");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        mostrarVentanaInicio(); // Muestra la ventana de inicio al ejecutar la aplicación
    }

    /**
     * Método para mostrar la ventana de inicio con opciones.
     */
    private void mostrarVentanaInicio() {
        getContentPane().removeAll(); // Limpia el contenido anterior de la ventana
        setLayout(new BorderLayout()); // Establece el layout de la ventana

        JLabel mensaje = new JLabel("¿Qué desea hacer?");
        mensaje.setHorizontalAlignment(SwingConstants.CENTER);

        JButton btnVerInfo = new JButton("Ver Información");
        JButton btnSalir = new JButton("Salir");

        // ActionListener para el botón "Ver Información", muestra la estructura de la tienda
        btnVerInfo.addActionListener((ActionEvent e) -> mostrarTienda());
        // ActionListener para el botón "Salir", cierra la aplicación
        btnSalir.addActionListener(e -> System.exit(0));

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnVerInfo);
        panelBotones.add(btnSalir);

        add(mensaje, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        revalidate(); // Revalida el layout para que los cambios se reflejen
        repaint(); // Repinta la ventana
    }

    /**
     * Método para mostrar la estructura de la tienda utilizando un JTree.
     * Aquí se crea y se utiliza la composición de Paquetes y Productos.
     */
    private void mostrarTienda() {
        getContentPane().removeAll();
        setLayout(new BorderLayout());

        // Crear la estructura del árbol utilizando las clases del patrón Composite
        Paquete paquetePrincipal = new Paquete("Paquete Ofertas"); // Crea el nodo raíz (Compuesto)

        Paquete paqueteSnacks = new Paquete("Snacks"); // Crea un paquete de snacks (Compuesto)
        paqueteSnacks.agregar(new Producto("Papas")); // Agrega un producto (Hoja) al paquete de snacks
        paqueteSnacks.agregar(new Producto("Galletas")); // Agrega otro producto (Hoja)

        Paquete paqueteBebidas = new Paquete("Bebidas"); // Crea un paquete de bebidas (Compuesto)
        paqueteBebidas.agregar(new Producto("Jugo")); // Agrega un producto (Hoja) al paquete de bebidas
        paqueteBebidas.agregar(new Producto("Agua")); // Agrega otro producto (Hoja)

        paquetePrincipal.agregar(paqueteSnacks); // Agrega el paquete de snacks al paquete principal
        paquetePrincipal.agregar(paqueteBebidas); // Agrega el paquete de bebidas al paquete principal
        paquetePrincipal.agregar(new Producto("Chocolate")); // Agrega un producto (Hoja) directamente al paquete principal

        // Crea un JTree utilizando el nodo raíz creado por el método crearNodo() del Compuesto
        JTree arbol = new JTree(paquetePrincipal.crearNodo());
        JScrollPane scroll = new JScrollPane(arbol); // Permite hacer scroll si el árbol es muy grande

        JButton btnRegresar = new JButton("Regresar");
        btnRegresar.addActionListener(e -> mostrarVentanaInicio()); // Vuelve a la ventana de inicio

        JPanel panelInferior = new JPanel();
        panelInferior.add(btnRegresar);

        add(scroll, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);

        revalidate();
        repaint();
    }
}