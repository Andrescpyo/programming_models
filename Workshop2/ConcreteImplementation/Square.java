package Workshop2.ConcreteImplementation;
import java.awt.Graphics;
import Workshop2.Interface.Shape;

// Concrete class

public class Square implements Shape {
    @Override
    public void dibujar(Graphics g) {
        g.drawRect(50, 50, 100, 100);
    }
}