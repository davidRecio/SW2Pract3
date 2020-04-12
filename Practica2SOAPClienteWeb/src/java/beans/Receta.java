/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.ArrayList;

/**
 *
 * @author darth
 */
public class Receta {
   
     private String nombre;
     private String dificultad;
     private ArrayList<String> ingrediente = new ArrayList<>();
     private Double precio;

    public Receta(String nombre, String dificultad, Double precio) {
        this.nombre = nombre;
        this.dificultad = dificultad;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) { 
        this.nombre = nombre;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public ArrayList<String> getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(ArrayList<String> ingrediente) {
        this.ingrediente = ingrediente;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
     
     
}
