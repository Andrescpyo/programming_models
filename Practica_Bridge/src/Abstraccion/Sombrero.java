package Abstraccion;

import Implementador.Seleccion_color;

public class Sombrero extends Abstract_prenda {

    public Sombrero(Seleccion_color tono) {
        super(tono);
    }

    @Override
    public void prenda() {
        tono.Seleccionar_color();
    }
}