/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServicioRest;

import Recursos.Receta;
import Recursos.Recetario;
import java.io.File;
import java.util.ArrayList;
import javax.inject.Singleton;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

/**
 * REST Web Service
 *
 * @author david
 */
@Singleton
@Path("servicioRest")
public class ServicioRestResource {   
private Recetario recetario = new Recetario();
    
private ArrayList<Receta> recetas = new ArrayList();
private String sCarpAct = System.getProperty("user.dir");
private File carpeta = new File(sCarpAct);
private String ruta = carpeta.getPath();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ServicioRestResource
     */
    public ServicioRestResource() {
        
    }
    private void bjkjb(){
        //recetario.setNombre("mierda");
      
    }
    /**
     * Retrieves representation of an instance of ServicioRest.ServicioRestResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("obtenerRecetario")
    @Produces("application/xml")
    public Recetario obtenerRecetario() {

       return recetario;
      
    }

    /**
     * PUT method for updating or creating an instance of ServicioRestResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Path("crearRecetario")
    @Consumes("application/xml")
    public void crearRecetario(Recetario e) {
        recetario= e;

    }
}
