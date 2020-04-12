/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviciosWeb;


import Funcionalidad.ValidarXSD;
import Funcionalidad.Marsalling;
import Recursos.Receta;
import Recursos.Recetario;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author david
 */
@WebService(serviceName = "servicioWebRecetario")
public class servicioWebRecetario {

   
    private Recetario recetario = new Recetario();
    private Marsalling mrs = new Marsalling();
    private ValidarXSD vXSD = new ValidarXSD();
    private String sCarpAct = System.getProperty("user.dir");
    private File carpeta = new File(sCarpAct);
    private String ruta = carpeta.getPath();
    private ArrayList<Receta> recetas = new ArrayList();
//Clases del modelo
    
    @WebMethod(operationName = "crearRecetario")
    public void crearRecetario(@WebParam(name = "recetario") Recetario recetario) {
        this.recetario=recetario;

    }
    @WebMethod(operationName = "addReceta")
    public void addReceta(@WebParam(name = "receta")Receta receta) {
      
       recetas.add(receta);
        recetario.setRecetas(recetas);

    }
    @WebMethod(operationName = "rmvReceta")
    public void rmvReceta(@WebParam(name = "nombreReceta")String nombreReceta) {
      recetario.getRecetas().remove(obtenerReceta(nombreReceta));

    }
    @WebMethod(operationName = "obtenerReceta")
    public Receta obtenerReceta(@WebParam(name = "nombreReceta")String nombreReceta) {
        Receta resultado = null;
        for (Receta ele : recetario.getRecetas()) {

            if (ele.getNombre().equals(nombreReceta)) {
                resultado = ele;
            }

        }
        return resultado;

    }
    @WebMethod(operationName = "obtenerRecetario")
    public Recetario obtenerRecetario() { 
        return recetario;
    }

 //exportar e importar
    //el servicio te exporta el xmlen el servidor y luego lo muueve al cliente, por tanto la funcion tiene un return de fichero
    @WebMethod(operationName = "exportarRecetario")
    public  byte[]  exportarRecetario(@WebParam(name = "nombreFichero") String nombreFichero) throws IOException {
        mrs.crearXMLRecetario(nombreFichero+".xml", recetario, ruta);
         File file = new File(ruta+"/files/xml/"+ nombreFichero+".xml");
         return converterByte(file);
    }
//parametro de entrada que sea unchero
    @WebMethod(operationName = "importarRecetario")
    public void importarRecetario(@WebParam(name = "bytes") byte[] bytes) {
       File file= new File( leerBytes(bytes).getPath());
        recetario = mrs.importarRecetario(file);
        recetas=recetario.getRecetas();
        file.delete();

    }

    @WebMethod(operationName = "exportarReceta")
    public byte[]  exportarReceta(@WebParam(name = "nombreFichero") String nombreFichero,
            @WebParam(name = "nombreReceta") String nombreReceta) throws IOException {
        mrs.crearXMLReceta(nombreFichero, obtenerReceta(nombreReceta), ruta);
         File file = new File(ruta+"/files/xml/"+ nombreFichero);
         return converterByte(file);
    }

    @WebMethod(operationName = "importarReceta")
    public void importarReceta(@WebParam(name = "bytes") byte[] bytes) {
         File file= new File( leerBytes(bytes).getPath());
         Receta receta=mrs.importarReceta(file);
        addReceta(receta);
         file.delete();

    }
    
    
    
    
    
    //validar fichero

    @WebMethod(operationName = "validarXSD")
    public String validarXSD(@WebParam(name = "bytes") byte[] bytes){
         File file= new File( leerBytes(bytes).getPath());
        return "¿Es valido el xml con su xsd? " + vXSD.validarXSD(ruta + "/files/xsd/recetario.xsd",file );
    }


    //creacion de ficheros necesarios
    @WebMethod(operationName = "start")
    public void start() {
        crearEntorno();
    }
    //crea ficheros necesarios

    private void crearEntorno() {
        File directorio = new File(ruta + "/files/xml");
        if (!directorio.exists()) {
            if (directorio.mkdirs()) {
                System.out.println("Directorio creado");
            } else {
                System.out.println("Error al crear directorio");
            }
        }
        directorio = new File(ruta + "/files/xsd");
        if (!directorio.exists()) {
            if (directorio.mkdirs()) {
                System.out.println("Directorio creado");
            } else {
                System.out.println("Error al crear directorio");
            }
        }
        crearXSD();
        //crearRecetario1();
    }

    private void crearXSD() {

        File archivo = new File(ruta + "/files/xsd/recetario.xsd");
        BufferedWriter bw = null;
        if (archivo.exists() != true) {

            try {
                bw = new BufferedWriter(new FileWriter(archivo));
            } catch (IOException ex) {
                Logger.getLogger(servicioWebRecetario.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                bw.write("<xs:schema attributeFormDefault=\"unqualified\" elementFormDefault=\"qualified\" xmlns:xs=\"http://www.w3.org/2001/XMLSchema\">\n"
                        + "  <xs:element name=\"Recetario\">\n"
                        + "    <xs:complexType>\n"
                        + "      <xs:sequence>\n"
                        + "        <xs:element type=\"xs:string\" name=\"nombre\"/>\n"
                        + "        <xs:element name=\"recetas\">\n"
                        + "          <xs:complexType>\n"
                        + "            <xs:sequence>\n"
                        + "              <xs:element name=\"recetas\" maxOccurs=\"unbounded\" minOccurs=\"0\">\n"
                        + "                <xs:complexType>\n"
                        + "                  <xs:sequence>\n"
                        + "                    <xs:element type=\"xs:string\" name=\"nombre\"/>\n"
                        + "                    <xs:element name=\"ingrediente\">\n"
                        + "                      <xs:complexType>\n"
                        + "                        <xs:sequence>\n"
                        + "                          <xs:element type=\"xs:string\" name=\"ingrediente\" maxOccurs=\"unbounded\" minOccurs=\"0\"/>\n"
                        + "                        </xs:sequence>\n"
                        + "                      </xs:complexType>\n"
                        + "                    </xs:element>\n"
                        + "                    <xs:element type=\"xs:float\" name=\"precio\"/>\n"
                        + "                  </xs:sequence>\n"
                        + "                  <xs:attribute type=\"xs:string\" name=\"dificultad\" use=\"optional\"/>\n"
                        + "                </xs:complexType>\n"
                        + "              </xs:element>\n"
                        + "            </xs:sequence>\n"
                        + "          </xs:complexType>\n"
                        + "        </xs:element>\n"
                        + "        <xs:element type=\"xs:float\" name=\"precio\"/>\n"
                        + "      </xs:sequence>\n"
                        + "    </xs:complexType>\n"
                        + "  </xs:element>\n"
                        + "</xs:schema>\n"
                        + "");
            } catch (IOException ex) {
                Logger.getLogger(servicioWebRecetario.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                bw.close();
            } catch (IOException ex) {
                Logger.getLogger(servicioWebRecetario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void crearRecetario1() {

        File archivo = new File(ruta + "/files/xml/recetario1.xml");
        BufferedWriter bw = null;
        if (archivo.exists() != true) {

            try {
                bw = new BufferedWriter(new FileWriter(archivo));
            } catch (IOException ex) {
                Logger.getLogger(servicioWebRecetario.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
                        + "<Recetario>\n"
                        + "    <nombre>Recetario1</nombre>\n"
                        + "    <recetas>\n"
                        + "        <recetas dificultad=\"Dificil\">\n"
                        + "            <nombre>Lasanna</nombre>\n"
                        + "            <ingrediente>\n"
                        + "                <ingrediente>Tomate</ingrediente>\n"
                        + "                <ingrediente>Carne</ingrediente>\n"
                        + "                <ingrediente>Pasta</ingrediente>\n"
                        + "                <ingrediente>Queso</ingrediente>\n"
                        + "                <ingrediente>Aceite</ingrediente>\n"
                        + "                <ingrediente>Sal</ingrediente>\n"
                        + "                <ingrediente>Bechamel</ingrediente>\n"
                        + "            </ingrediente>\n"
                        + "            <precio>12.0</precio>\n"
                        + "        </recetas>\n"
                        + "        <recetas dificultad=\"Facil\">\n"
                        + "            <nombre>Sandwich de pavo</nombre>\n"
                        + "            <ingrediente>\n"
                        + "                <ingrediente>Pavo</ingrediente>\n"
                        + "                <ingrediente>Pan</ingrediente>\n"
                        + "            </ingrediente>\n"
                        + "            <precio>1.5</precio>\n"
                        + "        </recetas>\n"
                        + "        <recetas dificultad=\"Facil\">\n"
                        + "            <nombre>Filete de ternera</nombre>\n"
                        + "            <ingrediente>\n"
                        + "                <ingrediente>Carne de ternera</ingrediente>\n"
                        + "                <ingrediente>Aceite</ingrediente>\n"
                        + "                <ingrediente>Sal</ingrediente>\n"
                        + "            </ingrediente>\n"
                        + "            <precio>1.0</precio>\n"
                        + "        </recetas>\n"
                        + "    </recetas>\n"
                        + "    <precio>20.0</precio>\n"
                        + "</Recetario>");
            } catch (IOException ex) {
                Logger.getLogger(servicioWebRecetario.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                bw.close();
            } catch (IOException ex) {
                Logger.getLogger(servicioWebRecetario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    //creacion de fichero a byte y al reves
      private  byte[] converterByte( File file ) throws FileNotFoundException, IOException {
       
 
        FileInputStream fiss = new FileInputStream(file);
        //System.out.println(file.exists() + "!!");
        //InputStream in = resource.openStream();
        ByteArrayOutputStream boss = new ByteArrayOutputStream();
        byte[] buff = new byte[1024];
        try {
            for (int readNum; (readNum = fiss.read(buff)) != -1;) {
                boss.write(buff, 0, readNum); //no doubt here is 0
                //Writes len bytes from the specified byte array starting at offset off to this byte array output stream.
                System.out.println("read " + readNum + " bytes,");
            }
           
        } catch (IOException ex) {
            Logger.getLogger(servicioWebRecetario.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        byte[] bytes = boss.toByteArray();
          boss.close();
          fiss.close();
         File fileAux=new File(file.getPath());
         System.err.println(file.getPath());
         fileAux.delete();
        return bytes;
        //below is the different part
//        File someFile = new File("java2.pdf");
//        FileOutputStream fos = new FileOutputStream(someFile);
//        fos.write(bytes);
//        fos.flush();
//        fos.close();
    }
 private File leerBytes(byte[] importarRecetario){
        FileOutputStream fos = null;
        File file = new File("./recetario.xml");
        try {
            
            fos = new FileOutputStream(file);
            fos.write(importarRecetario);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(servicioWebRecetario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(servicioWebRecetario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fos.close();
            } catch (IOException ex) {
                Logger.getLogger(servicioWebRecetario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return file;
    }
}
