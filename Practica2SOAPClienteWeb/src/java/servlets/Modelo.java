/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

/**
 *
 * @author david
 */
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import serviciosweb.IOException_Exception;
import serviciosweb.Receta.Ingrediente;
import serviciosweb.Receta;
import serviciosweb.Recetario;

import serviciosweb.ServicioWebRecetario;
import serviciosweb.ServicioWebRecetario_Service;
public class Modelo {

    ServicioWebRecetario_Service servicioWebRecetario_Service = new ServicioWebRecetario_Service();
      ServicioWebRecetario SWRPort = servicioWebRecetario_Service.getServicioWebRecetarioPort();
      
       private String sCarpAct = System.getProperty("user.dir");
    private File carpeta = new File(sCarpAct);
    private String ruta = carpeta.getPath();
    
    
    private Recetario recetario = new Recetario();
    //las funcionalidades obtenidas del servicio
    //tratamiento obj
    protected void crearRecetario(Recetario recetario) {
        SWRPort.crearRecetario(recetario);
    }

    protected void addReceta(Receta receta) {
      SWRPort.addReceta(receta);
    }

    protected void rmvReceta(String nombreReceta ) {
        SWRPort.rmvReceta(nombreReceta);
    }

    protected Receta obtenerReceta(String nombreReceta) {
     return  SWRPort.obtenerReceta(nombreReceta);
    }

    protected Recetario obtenerRecetario() {
        return SWRPort.obtenerRecetario();
    }
    
    
    //imports y exports
    
    protected  byte[]  exportarRecetario(String nombreFichero) throws IOException_Exception{
   
    return SWRPort.exportarRecetario(nombreFichero);
    }
       protected  void  importarRecetario(File fichero) throws IOException {
           SWRPort.importarRecetario(converterByte(fichero));
   
    }
    protected  byte[]  exportarReceta(String nombreFichero,String nombreReceta) throws IOException_Exception{
   
    return SWRPort.exportarReceta(nombreFichero, nombreReceta);
    }
    protected  void  importarReceta(File fichero) throws IOException {
           SWRPort.importarReceta(converterByte(fichero));
   
    }
    
    //validarXSD
     protected  String  validarXSD(File fichero) throws IOException {
          return SWRPort.validarXSD(converterByte(fichero));
   
    }
     
     
    //creador del entorno
    protected void start(){
       SWRPort.start();
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
        Ingrediente ing = new Ingrediente();
        ing.getIngrediente().addAll(ingredientes);
        receta.setIngrediente(ing);

        return receta;

    }
    //creacion de fichero a byte y al reves
     private  byte[] converterByte( File file ) throws FileNotFoundException, IOException {
       
 
        FileInputStream fis = new FileInputStream(file);
        //System.out.println(file.exists() + "!!");
        //InputStream in = resource.openStream();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        try {
            for (int readNum; (readNum = fis.read(buf)) != -1;) {
                bos.write(buf, 0, readNum); //no doubt here is 0
                //Writes len bytes from the specified byte array starting at offset off to this byte array output stream.
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
        //below is the different part
//        File someFile = new File("java2.pdf");
//        FileOutputStream fos = new FileOutputStream(someFile);
//        fos.write(bytes);
//        fos.flush();
//        fos.close();
    }
 protected void leerBytes(byte[] exportarRecetario,String nombreFichero){
        FileOutputStream fos = null;
        System.err.println(ruta);
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
