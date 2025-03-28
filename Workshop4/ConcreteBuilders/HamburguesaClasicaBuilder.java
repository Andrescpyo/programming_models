package Workshop4.ConcreteBuilders;
import Workshop4.HamburguesaBuilder;

public class HamburguesaClasicaBuilder extends HamburguesaBuilder {
    public HamburguesaClasicaBuilder() {
        super("Pan con ajonjolí", "Carne de res");
        queso("Queso americano");
        salsa("Ketchup y mostaza");
        vegetales("Lechuga, tomate y cebolla");
        extras("Ninguno");
    }
}