/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursos;

import java.util.ArrayList;

/**
 *
 * @author david
 */
public class ConjuntoRecetarios {
   private int idUsuario;
   private String nombreConjRecetarios;
   private ArrayList <Recetario> arrayRecetarios= new ArrayList();

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public ArrayList <Recetario> getArrayRecetarios() {
        return arrayRecetarios;
    }

    public void setArrayRecetarios(ArrayList <Recetario> arrayRecetarios) {
        this.arrayRecetarios = arrayRecetarios;
    }

    public String getNombreConjRecetarios() {
        return nombreConjRecetarios;
    }

    public void setNombreConjRecetarios(String nombreConjRecetarios) {
        this.nombreConjRecetarios = nombreConjRecetarios;
    }
    
    
}
