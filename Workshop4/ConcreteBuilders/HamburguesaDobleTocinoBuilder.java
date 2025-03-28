package Workshop4.ConcreteBuilders;
import Workshop4.HamburguesaBuilder;

public class HamburguesaDobleTocinoBuilder extends HamburguesaBuilder{
    public HamburguesaDobleTocinoBuilder(){
        super("Pan brioche", "Doble carne de res");
        queso("Queso cheddar");
        salsa("Salsa barbacoa");
        vegetales("Lechuga y tomate");
        extras("Tocino crujiente");
    }
}