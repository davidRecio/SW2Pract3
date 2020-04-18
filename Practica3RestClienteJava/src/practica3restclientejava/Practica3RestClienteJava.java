/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3restclientejava;

import Funcionalidad.Modelo;
import Recursos.Recetario;
import static java.lang.Thread.sleep;

/**
 *
 * @author david
 */
public class Practica3RestClienteJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        Modelo modelo = new Modelo();
       
       Recetario recetario = new Recetario();
       recetario.setNombre("libro1");
       recetario.setPrecio(10.2);
       
       modelo.crearRectario(recetario);
       sleep(1500);
        System.err.println(modelo.obtenerRecetario().getNombre());
    }
    
}
