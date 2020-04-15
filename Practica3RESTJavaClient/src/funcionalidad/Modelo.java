/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcionalidad;

import Recursos.Receta;
import Recursos.Recetario;
import cliente.Cliente;

/**
 *
 * @author david
 */
public class Modelo {
   private Recetario recetario = new Recetario();
    private Receta receta = new Receta();
    private Cliente cliente = new Cliente();
    
    
    public void crearRecetario(Recetario recetario){
       cliente.crearRecetario(recetario.getNombre(),recetario.getPrecio().toString() );
    }
    public Recetario obtenerRecetario(){
   
    return cliente.obtenerRecetario(recetario.getClass());
    }
    
}
