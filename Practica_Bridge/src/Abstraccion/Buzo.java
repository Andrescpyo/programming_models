/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Abstraccion;

import Implementador.Seleccion_color; //importa la interfase

/**
 *
 * @author jorge malaver
 */
public class Buzo extends Abstract_prenda{
    
    public Buzo(Seleccion_color tono){
     super(tono);   
    }
    
    @Override
    public void prenda(){//implementaion del metodo abstracto
        tono.Seleccionar_color();//llamado a la referencia del implementador
    }
}
