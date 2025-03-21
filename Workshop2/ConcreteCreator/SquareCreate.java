package Workshop2.ConcreteCreator;
import Workshop2.ConcreteImplementation.Square;
import Workshop2.Interface.Shape;
import Workshop2.AbstractClass.ShapeCreator;

// Concrete class

public class SquareCreate extends ShapeCreator {

    @Override
    public Shape create() {
        return new Square();
    }
    
}
