package Workshop2;
import javax.swing.*;

import Workshop2.ConcreteCreator.CircleCreate;
import Workshop2.ConcreteCreator.SquareCreate;
import Workshop2.Interface.Shape;
import Workshop2.AbstractClass.ShapeCreator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Main class

public class ShapesApp extends JFrame {

    private JPanel panelDibujo;
    private ShapeCreator creadorFormas;
    private Shape forma;

    public ShapesApp() {
        setTitle("Creador de Formas");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelBotones = new JPanel();
        JButton botonCirculo = new JButton("Círculo");
        JButton botonCuadrado = new JButton("Cuadrado");

        panelBotones.add(botonCirculo);
        panelBotones.add(botonCuadrado);

        panelDibujo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (forma != null) {
                    forma.dibujar(g);
                }
            }
        };

        botonCirculo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                creadorFormas = new CircleCreate();
                forma = creadorFormas.create();
                panelDibujo.repaint();
            }
        });

        botonCuadrado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                creadorFormas = new SquareCreate();
                forma = creadorFormas.create();
                panelDibujo.repaint();
            }
        });

        add(panelBotones, BorderLayout.NORTH);
        add(panelDibujo, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        new ShapesApp();
    }
}