package Workshop2.ConcreteCreator;
import Workshop2.ConcreteImplementation.Circle;
import Workshop2.Interface.Shape;
import Workshop2.AbstractClass.ShapeCreator;

// Concrete class

public class CircleCreate extends ShapeCreator {

    @Override
    public Shape create() {
        return new Circle();
    }
    
}
