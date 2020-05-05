/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalidad;

import Recursos.Receta;
import Recursos.Recetario;
import Recursos.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author david
 */
public class AccesoBBDD {

    //refactor para q sea unica
    //import y export son a partir de leer o crear , falta el init
    
    DataSource datasource;
    
    //For this example you need to create the Mysql Database and the table
    //CREATE TABLE PERSONAS (         NOMBRE VARCHAR(100),          EDAD INT); 
    
    public void init() {
        ArrayList<String> queryBBDD = new ArrayList<>();
        
        conexionBBDD(queryBBDD);
    
    
    }

       public void crearRecetario(Recetario recetario, String userName) {//añadir a conjRece
        ArrayList<String> queryBBDD = new ArrayList<>();
        queryBBDD.add("insert into recetario value('" + recetario.getNombre() + "', '" + recetario.getPrecio() + "');");
        conexionBBDD(queryBBDD);
        addRelacionConjRecetarioRecetario(userName,obtenerIdRecetario(recetario.getNombre()));
    
    }
      public void crearReceta(Receta receta, String nombreRecetario) {
          //crea una receta por cada ing
        ArrayList<String> queryBBDD = new ArrayList<>();
         
          queryBBDD.add("insert into receta value('" + receta.getNombre() + "', '" + receta.getDificultad()  + 
                       "', '" + receta.getPrecio()+ "');");  
           conexionBBDD(queryBBDD);
          addIngrediente(receta.getIngrediente()); 
          addRelacionRecetaIng(receta);
          addRelacionRecetarioReceta(receta, nombreRecetario );
       
    
    
    }
      //borrar
       public void borrarRecetario(String nombreRecetario) {
        ArrayList<String> queryBBDD = new ArrayList<>();
        queryBBDD.add("delete from recetario where usuario = '" + nombreRecetario + "';");
         queryBBDD.add("delete conjunto_recetario where nombre_rectario = '" + nombreRecetario + "';");
         ArrayList<String> idReceta =obtenerIdRecetaArray(obtenerIdRecetario(nombreRecetario));
            conexionBBDD(queryBBDD);

         
           for (int i = 0; i < idReceta.size(); i++) {
            try {
                String queryBBDD2="select nombre_receta from receta where id_receta = '"+idReceta.get(i)+"';";
                ResultSet rS=conexionBBDDConResulset(queryBBDD2);
                borrarReceta(rS.getString("nombre_receta"));
            } catch (SQLException ex) {
                Logger.getLogger(AccesoBBDD.class.getName()).log(Level.SEVERE, null, ex);
            }
           }
           
           
         
     
    
    
    }
        public void borrarReceta(String recetaNombre) {
        ArrayList<String> queryBBDD = new ArrayList<>();
        queryBBDD.add("delete from receta where recetaNombre = '" + recetaNombre + "';");
        rmvRelacionRecetarioReceta(recetaNombre);
        conexionBBDD(queryBBDD);
    
    
    }
         //leer      
          public Recetario leerRecetario(String recetarioNombre) {
                Recetario recetario= new Recetario();
        try {
            String queryBBDD = "";
         
            queryBBDD="select * from receta where nombre_recetario = '"+recetarioNombre+"';";
            ResultSet rS=conexionBBDDConResulset(queryBBDD);
            recetario.setNombre(rS.getString("nombre_recetario"));
            recetario.setPrecio(Double.parseDouble(rS.getString("precio_receta")));
            
            
            ArrayList<String> idReceta =obtenerIdRecetaArray(obtenerIdRecetario(recetarioNombre));
            ArrayList<String> receta = new ArrayList();
            for (String id : idReceta) {
                queryBBDD="select nobre_receta from receta where receta_id= '"+id+"';";
                rS=conexionBBDDConResulset(queryBBDD);
                idReceta.add(rS.getString("nobre_receta"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return recetario;
    }
      
           public Receta leerReceta(String recetaNombre) {
                Receta receta= new Receta();
        try {
            String queryBBDD = "";
         
            queryBBDD="select * from receta where nombre_receta = '"+recetaNombre+"';";            
              InitialContext initialContext = new InitialContext();
            datasource = (DataSource) initialContext.lookup("jdbc/myDatasource");
            Connection connection = datasource.getConnection();
            Statement createStatement = connection.createStatement();
           ResultSet resultSet = createStatement.executeQuery(queryBBDD);
            if (resultSet.next()) {
            receta.setNombre(resultSet.getString("nombre_receta"));
            receta.setDificultad(resultSet.getString("dificultad_receta"));
            receta.setPrecio(Double.parseDouble(resultSet.getString("precio")));
            }
            createStatement.close();
            connection.close();
        
            
            
//            
//            ArrayList<String> idIngrediente =obtenerIdIngrediente(obtenerIdReceta(recetaNombre));
//            ArrayList<String> ingrediente = new ArrayList();
//            for (String id : idIngrediente) {
//                queryBBDD="select * from ingrediente where ingrediente_id= '"+id+"';";
//                
//           
//             connection = datasource.getConnection();
//           createStatement = connection.createStatement();
//           resultSet = createStatement.executeQuery(queryBBDD);
//                ingrediente.add(resultSet.getString("nobre_ingrediente"));
//                 createStatement.close();
//            connection.close();
//            }
//            receta.setIngrediente(ingrediente);
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBBDD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(AccesoBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return receta;
    }
        
//         public Receta leerReceta(String recetaNombre) {
//                Receta receta= new Receta();
//        try {
//            String queryBBDD = "";
//         
//            queryBBDD="select * from receta where nombre_receta = '"+recetaNombre+"';";
//            ResultSet rS=conexionBBDDConResulset(queryBBDD);
//            receta.setNombre(rS.getString("nombre_receta"));
//            receta.setDificultad(rS.getString("dificultad_receta"));
//            receta.setPrecio(Double.parseDouble(rS.getString("precio")));
//            
//            
//            ArrayList<String> idIngrediente =obtenerIdIngrediente(obtenerIdReceta(recetaNombre));
//            ArrayList<String> ingrediente = new ArrayList();
//            for (String id : idIngrediente) {
//                queryBBDD="select * from ingrediente where ingrediente_id= '"+id+"';";
//                rS=conexionBBDDConResulset(queryBBDD);
//                ingrediente.add(rS.getString("nobre_ingrediente"));
//                
//            }
//            receta.setIngrediente(ingrediente);
//        } catch (SQLException ex) {
//            Logger.getLogger(AccesoBBDD.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return receta;
//    }
//        
        
    //para autentificacion
          public ArrayList<String> ObtenerRecetarioConjRecetarios(String idUsuario) {
                ArrayList<String> recetarios= new ArrayList();
                 ArrayList<String> idRecetario = new ArrayList();
        try {
            String queryBBDD = "";
         
            queryBBDD="select recetario_id from conjunto_recetario where usuario_id = "+idUsuario+";";
            ResultSet rS=conexionBBDDConResulset(queryBBDD);
              while (rS.next()) {
                idRecetario.add(rS.getString("id_recetario"));
            
            }
            for (int i = 0; i < idRecetario.size(); i++) {
                 queryBBDD="select nombre_recetario from recetario where id_recetario = '"+ idRecetario.get(i)+"';";
                 rS=conexionBBDDConResulset(queryBBDD);
                 recetarios.add(rS.getString("nombre_recetario"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return recetarios;
        }
        public ArrayList<Usuario> leerUsuarios() {
                ArrayList<Usuario> usuario= new ArrayList();
                Usuario user =  new Usuario();
        try {
            String queryBBDD = "";
         
            queryBBDD="select * from usuario;";
            ResultSet rS=conexionBBDDConResulset(queryBBDD);
              while (rS.next()) {
                user.setNombre(rS.getString("nombre_usuario"));
            user.setPassword(rS.getString("password_usuario"));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
        }
        
 
    private void conexionBBDD(ArrayList<String> queryBBDD) {
        try {
            InitialContext initialContext = new InitialContext();
            datasource = (DataSource) initialContext.lookup("jdbc/myDatasource");
            Connection connection = datasource.getConnection();
            Statement createStatement = connection.createStatement();
            
            for (String query : queryBBDD) {
                 createStatement.execute(query);
            }
 
           
            createStatement.close();
            connection.close();            
            
   
    }   catch (NamingException ex) {
            Logger.getLogger(AccesoBBDD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
     private ResultSet conexionBBDDConResulset(String queryBBDD) {

        ResultSet resultSet = null;
            //objeto que tiene el cuerpo q son los atributos de la tabla
        //Ej Persona persona = Resulset;
        try {
            InitialContext initialContext = new InitialContext();
            datasource = (DataSource) initialContext.lookup("jdbc/myDatasource");
            Connection connection = datasource.getConnection();
            Statement createStatement = connection.createStatement();

            resultSet = createStatement.executeQuery(queryBBDD);

            createStatement.close();
            connection.close();

        } catch (NamingException ex) {
            Logger.getLogger(AccesoBBDD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultSet;

    }
     
//accesos necesarios     
    private void addIngrediente(ArrayList<String> ingrediente) {
          ArrayList<String> queryBBDD = new ArrayList<>();
          for (String ing : ingrediente) {
              queryBBDD.add("insert into ingrediente value('" + ing + "');");
        }
          
      
        conexionBBDD(queryBBDD);
    }
//addRelaciones
    private void addRelacionRecetaIng(Receta receta) {
        //id receta y id ing
         ArrayList<String> queryBBDD = new ArrayList<>();
         int i = 0;
         String idReceta =obtenerIdReceta(receta.getNombre());
         ArrayList<String> idIngrediente =obtenerIdIngrediente(obtenerIdReceta(receta.getNombre()));
          for (String ing : receta.getIngrediente()) {
              queryBBDD.add("insert into receta_ingrediente value('" + idReceta + "', '" + idIngrediente.get(i)  + "');");
              i++;
        }
          
      
        conexionBBDD(queryBBDD);
        
    }
   private void addRelacionRecetarioReceta(Receta receta, String nombreRecetario) {
         ArrayList<String> queryBBDD = new ArrayList<>();
          int i = 0;
          String idRecetario =obtenerIdRecetario(nombreRecetario);
         String idReceta =obtenerIdReceta(receta.getNombre());
         
          
              queryBBDD.add("insert into recetario_receta value('" + idReceta + "', '" + idRecetario + "');");
               
        
          
      
        conexionBBDD(queryBBDD);
    }
   private void addRelacionConjRecetarioRecetario(String userName, String obtenerIdRecetario) {
        ArrayList<String> queryBBDD = new ArrayList<>();
          int i = 0;
          String idUser =obtenerIdUser(userName);
         String nombreConj="conj5";
         
          
              queryBBDD.add("insert into conjunto_recetario value('" + nombreConj + "', '"+ idUser + "', '" + obtenerIdRecetario + "');");
               
        
          
      
        conexionBBDD(queryBBDD);
        
    }
   //rmvRelaciones
    private void rmvRelacionRecetarioReceta(String recetaNombre) {
         ArrayList<String> queryBBDD = new ArrayList<>();
        String idReceta =obtenerIdReceta(recetaNombre);
      
          
              queryBBDD.add("delete from recetario_receta where recetario_id = '" + idReceta + "';");
             
              
        
    }
//obtener id
    private String obtenerIdReceta(String recetaNombre) {
        String respuesta="";
        try {
            String queryBBDD = "select receta_id from receta where receta_nombre = '"+recetaNombre +"';";
            
            ResultSet rS=conexionBBDDConResulset(queryBBDD);
            
            
            
                respuesta=rS.getString("receta_id");
                
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }
    private  ArrayList<String>  obtenerIdIngrediente(String receta_id) {
      
         ArrayList<String> respuesta=new ArrayList();
         
           
             try {
            String queryBBDD = "select ingrediente_id from receta_ingrediente where receta_id = "+receta_id+";";
            
            ResultSet rS=conexionBBDDConResulset(queryBBDD);
            
            
            while (rS.next()) {
                respuesta.add(rS.getString("ingrediente_id"));
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        return respuesta;
    }

 

   
    private String obtenerIdRecetario(String nombreRecetario) {
          String respuesta="";
        try {
            String queryBBDD = "select recetario_id from recetario where recetario_nombre = '"+ nombreRecetario+"';";
            
            ResultSet rS=conexionBBDDConResulset(queryBBDD);
            
            
            
                respuesta=rS.getString("recetario_id");
                
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

   
    private ArrayList<String> obtenerIdRecetaArray(String idRecetario) {
        
         ArrayList<String> respuesta=new ArrayList();
         
           
             try {
            String queryBBDD = "select receta_id from recetario_receta where recetario_id = "+idRecetario+";";
            
            ResultSet rS=conexionBBDDConResulset(queryBBDD);
            
            
            while (rS.next()) {
                respuesta.add(rS.getString("ingrediente_id"));
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        return respuesta;
    }

    private String obtenerIdUser(String userName) {
      String respuesta="";
        try {
            String queryBBDD = "select usuario_id from usuario where usuario_nombre = '"+ userName+"';";
            
            ResultSet rS=conexionBBDDConResulset(queryBBDD);
            
            
            
                respuesta=rS.getString("usuario_id");
                
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    

}
