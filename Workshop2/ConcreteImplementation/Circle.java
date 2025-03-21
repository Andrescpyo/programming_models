package Workshop2.ConcreteImplementation;
import java.awt.Graphics;
import Workshop2.Interface.Shape;

// Concrete class

public class Circle implements Shape {
    @Override
    public void dibujar(Graphics g) {
        g.drawOval(50, 50, 100, 100);
    }
}