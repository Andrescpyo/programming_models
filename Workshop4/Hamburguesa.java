package Workshop4;

public class Hamburguesa {
    private String pan;
    private String carne;
    private String queso;
    private String salsa;
    private String vegetales;
    private String extras;

    Hamburguesa(HamburguesaBuilder builder) {
        this.pan = builder.pan;
        this.carne = builder.carne;
        this.queso = builder.queso;
        this.salsa = builder.salsa;
        this.vegetales = builder.vegetales;
        this.extras = builder.extras;
    }

    public String getPan() {
        return pan;
    }

    public String getCarne() {
        return carne;
    }

    public String getQueso() {
        return queso;
    }

    public String getSalsa() {
        return salsa;
    }

    public String getVegetales() {
        return vegetales;
    }

    public String getExtras() {
        return extras;
    }

    public static HamburguesaBuilder builder(String pan, String carne) {
        return new HamburguesaBuilder(pan, carne);
    }
}