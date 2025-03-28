package Workshop4;

public class HamburguesaBuilder {
    String pan;
    String carne;
    String queso;
    String salsa;
    String vegetales;
    String extras;

    public HamburguesaBuilder(String pan, String carne) {
        this.pan = pan;
        this.carne = carne;
    }

    public HamburguesaBuilder queso(String queso) {
        this.queso = queso;
        return this;
    }

    public HamburguesaBuilder salsa(String salsa) {
        this.salsa = salsa;
        return this;
    }

    public HamburguesaBuilder vegetales(String vegetales) {
        this.vegetales = vegetales;
        return this;
    }

    public HamburguesaBuilder extras(String extras) {
        this.extras = extras;
        return this;
    }

    public Hamburguesa build() {
        return new Hamburguesa(this);
    }
}