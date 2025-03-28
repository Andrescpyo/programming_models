package Workshop4.ConcreteBuilders;
import Workshop4.HamburguesaBuilder;

public class HamburguesaVegetarianaBuilder extends HamburguesaBuilder {
    public HamburguesaVegetarianaBuilder(){
        super("Pan integral", "Hamburguesa de lentejas");
        queso("Queso provolone");
        salsa("Salsa de yogur");
        vegetales("Espinacas, aguacate y pimientos");
        extras("Ninguno");
    }
}