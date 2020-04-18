/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalidad;

import Cliente.Cliente;
import Recursos.Recetario;

/**
 *
 * @author david
 */
public class Modelo {
    Cliente cli = new Cliente();
    
    
    public void crearRectario(Recetario recetario){
    cli.crearRecetario(recetario);
    }
    
    public Recetario obtenerRecetario(){
       
    return cli.obtenerRecetario();
    }
}
