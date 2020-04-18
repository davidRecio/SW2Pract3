/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import Recursos.Recetario;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:servicioRestResource
 * [/servicioRest/]<br>
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
    private static final String BASE_URI = "http://localhost:8080/Practica3RESTClass/webresources";

    public Cliente() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("servicioRest");
    }

    public <T> T obtenerReceta(Class<T> responseType, String nombreReceta) throws ClientErrorException {
        WebTarget resource = webTarget;
        if (nombreReceta != null) {
            resource = resource.queryParam("nombreReceta", nombreReceta);
        }
        resource = resource.path("obtenerReceta");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public Recetario  obtenerRecetario() throws ClientErrorException {
        WebTarget resource = webTarget;
        resource= resource.path("obtenerRecetario");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(Recetario.class);
    }

    public <T> T rmvReceta(Class<T> responseType, String nombreReceta) throws ClientErrorException {
        WebTarget resource = webTarget;
        if (nombreReceta != null) {
            resource = resource.queryParam("nombreReceta", nombreReceta);
        }
        resource = resource.path("rmvReceta");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

   public void crearRecetario(Object requestEntity) throws ClientErrorException {
      WebTarget resource = webTarget;
      resource= resource.path("crearRecetario");
       resource = resource.queryParam("recetario", requestEntity);
      resource.request().put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
        //webTarget.path("crearRecetario").request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public <T> T addReceta(Class<T> responseType, String receta) throws ClientErrorException {
        WebTarget resource = webTarget;
        if (receta != null) {
            resource = resource.queryParam("receta", receta);
        }
        resource = resource.path("addReceta");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public void close() {
        client.close();
    }
    
}
