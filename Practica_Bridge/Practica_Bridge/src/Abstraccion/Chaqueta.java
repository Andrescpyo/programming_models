/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Abstraccion;

/**
 *
 * @author jorge malaver
 */
import Implementador.*;

public class Chaqueta extends Abstract_prenda{
    
    public Chaqueta(Seleccion_color tono){
     super(tono);   
    }
    
    @Override
    public void prenda(){
        tono.Seleccionar_color();
    }
}
