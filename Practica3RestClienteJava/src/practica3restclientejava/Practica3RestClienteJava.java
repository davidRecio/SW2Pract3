/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3restclientejava;

import Funcionalidad.Modelo;
import Recursos.Receta;
import Recursos.Recetario;
import static java.lang.Thread.sleep;
import java.util.ArrayList;

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
       
       Receta receta = new Receta();
       receta.setNombre("pap2a");
       receta.setDificultad("Facil");
       receta.setPrecio(10.2);
        ArrayList<String> ingredientes = new ArrayList();
        ingredientes.add("papa");
        receta.setIngrediente(ingredientes);
       
       //modelo.crearRectario(recetario);
         modelo.crearRecta(receta);
     // modelo.rmvReceta("pap2a");
       //sleep(1500);
       System.err.println(modelo.obtenerRecetario().getNombre());
        for (Receta recetas : modelo.obtenerRecetario().getRecetas()) {
            System.out.println(recetas.getNombre());
            
        }
        
        
     
       // System.err.println(modelo.obtenerReceta("papa").getNombre());
        
    }
    
}
