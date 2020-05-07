/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalidad;


import Cliente.Cliente;
import Recursos.Receta;
import Recursos.RecetaRecetario;
import Recursos.Recetario;
import Recursos.Usuario;
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
    
    
    protected void crearRecetario(Recetario recetario){
    cli.crearRecetario(recetario);
    }
    
    protected Recetario obtenerRecetario(String nombreRecetario){
       
    return cli.obtenerRecetario(nombreRecetario);
    }
    protected void crearReceta(Receta receta){
    cli.crearReceta(receta);
    }
      protected  void addReceta(String nombreRecetario, String nombreReceta) {
          RecetaRecetario rR= new RecetaRecetario();
          rR.setNombreRecetario(nombreRecetario);
          rR.setNombreReceta(nombreReceta);
        cli.addReceta(rR);
    }
      protected Receta obtenerReceta(String nombreReceta){
       
    return cli.obtenerReceta(nombreReceta);
    }
      protected void rmvReceta(String nombreReceta, String nombreRecetario){
      cli.rmvReceta(nombreReceta, nombreRecetario);
      
      }
      protected byte[] exportarRecetario(String nombreFichero, String nombreRecetario)throws IOException{
        return  cli.exportarRecetario(nombreFichero, nombreRecetario);
      
      }
   
       protected  void  importarRecetario(File fichero) throws IOException {
           cli.importarRecetario(converterByte(fichero));
   
    }
      protected   byte[] exportarReceta(String nombreFichero, String nombreReceta)throws IOException {
        return cli.exportarReceta(nombreFichero, nombreReceta);
    }

    protected void importarReceta(File fichero) throws IOException {
        cli.importarReceta(converterByte(fichero));
    }
    //validar fichero
       protected  String validarXSD(File fichero) throws IOException {
              
         return cli.validarFichero(converterByte(fichero));
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
    //ListarUsuario
    public Usuario leerUsuarios(){
    
    
    return cli.obtenerUsuario();
    } 
      public void crearUusario(Usuario user){
    
    
    cli.crearUsuarios(user);
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



  

 

}
