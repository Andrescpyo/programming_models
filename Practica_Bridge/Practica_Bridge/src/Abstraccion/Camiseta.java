package Abstraccion;

import Implementador.Seleccion_color;

public class Camiseta extends Abstract_prenda {

    public Camiseta(Seleccion_color tono) {
        super(tono);
    }

    @Override
    public void prenda() {
        tono.Seleccionar_color();
    }
}