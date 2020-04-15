/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Recursos.Recetario;
import funcionalidad.Modelo;

/**
 *
 * @author david
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       Modelo modelo = new Modelo();
       
       Recetario recetario = new Recetario();
       recetario.setNombre("libro1");
       recetario.setPrecio(10.2);
       
       modelo.crearRecetario(recetario);
      Recetario rece= modelo.obtenerRecetario();
      System.out.println(rece.getNombre());
    }
    
}
