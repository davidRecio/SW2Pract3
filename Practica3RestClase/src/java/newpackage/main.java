/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import Funcionalidad.AccesoBBDD;



/**
 *
 * @author david
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
AccesoBBDD bbdd= new AccesoBBDD();
        System.err.println(bbdd.leerReceta("bocadillo").getNombre());
            
        
        
        
     
       // System.err.println(modelo.obtenerReceta("papa").getNombre());
        
    }
    
}
