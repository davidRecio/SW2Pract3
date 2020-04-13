/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicioRest;

import Recursos.Receta;
import Recursos.Recetario;
import java.io.File;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;

/**
 * REST Web Service
 *
 * @author david
 */
@Path("/servicioRest/")
public class servicioRestResource {
    
private Recetario recetario = new Recetario();
private ArrayList<Receta> recetas = new ArrayList();
private String sCarpAct = System.getProperty("user.dir");
private File carpeta = new File(sCarpAct);
private String ruta = carpeta.getPath();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public servicioRestResource() {
        System.out.println(ruta);
    }

    /**
     * Retrieves representation of an instance of servicioRest.servicioRestResource
     * @param recetario
     * @return an instance of java.lang.String
     */
    @GET
    @Path("crearRecetario")
    @Produces("application/xml")
    public void crearRecetario(@QueryParam("recetario") Recetario recetario) {    
       this.recetario=recetario;
    }
    @GET
    @Path("addReceta")
    @Produces("application/xml")
    public void addReceta(@QueryParam("receta") Receta receta) {    
        recetas.add(receta);
        recetario.setRecetas(recetas);
    }
    @GET
    @Path("rmvReceta")
    @Produces("application/xml")
    public void rmvReceta(@QueryParam("nombreReceta") String nombreReceta) {    
       recetario.getRecetas().remove(obtenerReceta(nombreReceta));
    }
     @GET
    @Path("obtenerReceta")
    @Produces("application/xml")
    public Receta obtenerReceta(@QueryParam("nombreReceta") String nombreReceta) {    
        Receta resultado = null;
        for (Receta ele : recetario.getRecetas()) {

            if (ele.getNombre().equals(nombreReceta)) {
                resultado = ele;
            }

        }
        return resultado;

    }
     @GET
    @Path("obtenerRecetario")
    @Produces("application/xml")
    public Recetario obtenerRecetario() {    
         return recetario;
    }
    /**
     * PUT method for updating or creating an instance of servicioRestResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(String content) {
    }
}
