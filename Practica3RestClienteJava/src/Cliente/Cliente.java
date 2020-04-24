/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import Recursos.Receta;
import Recursos.Recetario;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:ServicioRestResource
 * [servicioRest]<br>
 * USAGE:
 * <pre>
 *        Cliente client = new Cliente();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author david
 */
public class Cliente {
    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/Practica3RestClase/webresources";

    public Cliente() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("servicioRest");
    }

   
    public void validarFicheroPut(Object requestEntity) throws ClientErrorException {
        webTarget.path("validarFicheroPut").request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

   
    public String validarFichero() throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("validarFicheroGet");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(String.class);
    }


 public byte[] exportarReceta( String nombreFichero, String nombreReceta) throws ClientErrorException {
        WebTarget resource = webTarget;  
        resource = resource.queryParam("nombreFichero", nombreFichero);
        resource = resource.queryParam("nombreReceta", nombreReceta);
        resource = resource.path("exportarReceta");
        
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(byte[].class);
    }


    public void importarReceta(byte[] bytes)  throws ClientErrorException {
        webTarget.path("importarReceta").request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(bytes, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public byte[] exportarRecetario(String nombreFichero) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("exportarRecetario");
          resource = resource.queryParam("nombreFichero", nombreFichero);
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(byte[].class);
    }



    public void importarRecetario(byte[] bytes) throws ClientErrorException {
        webTarget.path("importarRecetario").request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(bytes, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }
public Receta  obtenerReceta(String nombreReceta) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("obtenerReceta");
        resource = resource.queryParam("nombreReceta", nombreReceta);
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(Receta.class);
    }

      public Recetario obtenerRecetario() throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("obtenerRecetario");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(Recetario.class);
    }

    public void rmvReceta(String requestEntity) throws ClientErrorException {
          WebTarget resource = webTarget;
        resource = resource.path("rmvReceta");
         resource = resource.queryParam("nombreReceta", requestEntity);
        resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).delete(String.class);
    }

    public void crearRecetario(Object requestEntity) throws ClientErrorException {
        webTarget.path("crearRecetario").request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void addReceta(Object requestEntity) throws ClientErrorException {
        webTarget.path("addReceta").request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

 
    public void close() {
        client.close();
    }
}
