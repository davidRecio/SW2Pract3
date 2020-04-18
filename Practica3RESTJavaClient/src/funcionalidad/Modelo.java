/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcionalidad;

import Recursos.Receta;
import Recursos.Recetario;
import cliente.Cliente;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author david
 */
public class Modelo {
   private Recetario recetario = new Recetario();
    private Receta receta = new Receta();
    private Cliente cliente = new Cliente();
     JSONObject myObject2 = new JSONObject();
    
    public void crearRecetario(Recetario recetario) throws JSONException{
        
         
      // cliente.crearRecetario(recetario.getClass(), recetario.getNombre(), recetario.getPrecio().toString());
      cliente.crearRecetario(recetario);
    }
    public Recetario obtenerRecetario(){
        
   System.out.print(cliente.obtenerRecetario().getNombre());
    return cliente.obtenerRecetario();
    }
    public JSONObject parsearRecetarioJSON (Recetario recetario){
         JSONObject myObject = new JSONObject();
       try {
             myObject.put("precio", recetario.getPrecio());
           myObject.put("nombre", recetario.getNombre());
         
       } catch (JSONException ex) {
           Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
       }
       return myObject;
    }
       
}
//public void crearRecetario(Object requestEntity) throws ClientErrorException {
//        webTarget.path("crearRecetario").request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
//    }