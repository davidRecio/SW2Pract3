/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalidad;

import Cliente.Cliente;
import Recursos.Receta;
import Recursos.Recetario;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author david
 */
public class Modelo {
    Cliente cli = new Cliente();
    
    
    public void crearRecetario(Recetario recetario){
    cli.crearRecetario(recetario);
    }
    
    public Recetario obtenerRecetario(){
       
    return cli.obtenerRecetario();
    }
    public void addReceta(Receta receta){
    cli.addReceta(receta);
    }
      public Receta obtenerReceta(String nombreReceta){
       
    return cli.obtenerReceta(nombreReceta);
    }
      public void rmvReceta(String nombreReceta){
      cli.rmvReceta(nombreReceta);
      
      }
      public byte[] exportarRecetario(String nombreFichero){
        return  cli.exportarRecetario(nombreFichero);
      
      }
   
       protected  void  importarRecetario(File fichero) throws IOException {
           cli.importarRecetario(converterByte(fichero));
   
    }
      
        //crea los objetos segun sus estructuras
   protected Recetario crearRecetarioEsructura(String nombreRecetario, Double precio) {
        Recetario recetario = new Recetario();
        recetario.setNombre(nombreRecetario);
        recetario.setPrecio(precio);
        return recetario;

    }
    protected Receta crearRecetaEsructura(String nombreReceta,String dificultad, Double precio,ArrayList<String> ingredientes) {
     
        Receta receta = new Receta();
        receta.setNombre(nombreReceta);
        receta.setDificultad(dificultad);
        receta.setPrecio(precio);
        receta.setIngrediente(ingredientes);

        return receta;

    }
    //creacion de fichero a byte y al reves
     private  byte[] converterByte( File file ) throws FileNotFoundException, IOException {
       
 
        FileInputStream fis = new FileInputStream(file);
    
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        try {
            for (int readNum; (readNum = fis.read(buf)) != -1;) {
                bos.write(buf, 0, readNum); 
                
                System.out.println("read " + readNum + " bytes,");
            }
        } catch (IOException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        byte[] bytes = bos.toByteArray();
         bos.close();
         File fileAux=new File(file.getPath().substring(0, file.getPath().length()-4));
         fileAux.delete();
        return bytes;

    }
 protected void leerBytes(byte[] exportarRecetario,String nombreFichero){
        FileOutputStream fos = null;
        try {
            File someFile = new File("./files/xml/"+nombreFichero+".xml");
            fos = new FileOutputStream(someFile);
            fos.write(exportarRecetario);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fos.close();
            } catch (IOException ex) {
                Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    byte[] exportarReceta(String string, String respuesta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void importarReceta(File file) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    boolean validarXSD(File file) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
