/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Abstraccion;

import Implementador.Seleccion_color;

/**
 *
 * @author jorge malaver
 */
public class Pantalon extends Abstract_prenda {
 
    
    public Pantalon(Seleccion_color tono){
     super(tono);   
    }
    
    @Override
    public void prenda(){
        tono.Seleccionar_color();
    }
}
