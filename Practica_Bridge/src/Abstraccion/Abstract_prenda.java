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
public abstract class Abstract_prenda {//
    
   public Seleccion_color tono; //referencia hacia  objeto implementador
   
   public Abstract_prenda(Seleccion_color tono ){//referencia hacia la implementacion
    
       this.tono= tono; 
   }
   
   public abstract void prenda();//metodo a implementar n las clases concretas

}