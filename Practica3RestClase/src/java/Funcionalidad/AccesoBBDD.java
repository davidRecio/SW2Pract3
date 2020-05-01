/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalidad;

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
    
    
    DataSource datasource;
    
    //For this example you need to create the Mysql Database and the table
    //CREATE TABLE PERSONAS (         NOMBRE VARCHAR(100),          EDAD INT); 
    
    public void init() {
        try {
            InitialContext initialContext = new InitialContext();
            datasource = (DataSource) initialContext.lookup("jdbc/DatasourcePrueba");
            Connection connection = datasource.getConnection();
            Statement createStatement = connection.createStatement();
            createStatement.execute("CREATE TABLE IF NOT EXISTS PERSONAS (NOMBRE VARCHAR(100),EDAD INT)");
            createStatement.close();
            connection.close();            
            
   
    }   catch (NamingException ex) {
            Logger.getLogger(AccesoBBDD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
//    public ArrayList<Usuario> conexionBBDDListarUsuarios() {
//        ArrayList<Usuario> ArrayListUser = new ArrayList();
//       
//        try {
//
//            String url = "jdbc:mysql://localhost:3306/pruebausuario";
//            String username = "root";
//            String password = "1234a";
//
//            Connection connection = DriverManager.getConnection(url, username, password);
//
//            Statement statement = connection.createStatement();
//            ResultSet rs = statement.executeQuery("SELECT * FROM usuario");
//
//            while (rs.next()) {
//                Usuario user = new Usuario();
//                user.setNombre(rs.getString("nombre"));
//                user.setPassword(rs.getString("contraseña"));
//
//                ArrayListUser.add(user);
//          
//            }
//
//            rs.close();
//            statement.close();
//            connection.close();
//
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//
//        try {
//            Class.forName("com.mysql.jdbc.Driver").newInstance();
//        } catch (Exception ex) {
//            System.out.println("Error, no se ha podido cargar MySQL JDBC Driver");
//        }
//        return ArrayListUser;
//
//    }
//
//    public void conexionBBDDCrearUsuarios(String nombreApellido, String pass) {
//
//        try {
//
//            String url = "jdbc:mysql://localhost:3306/pruebausuario";
//            String username = "root";
//            String password = "1234a";
//
//            Connection connection = DriverManager.getConnection(url, username, password);
//
//            Statement statement = connection.createStatement();
//           statement.executeUpdate("insert into usuario value('6', '" + nombreApellido + "', '" + pass + "');");
//
//            
//            statement.close();
//            connection.close();
//
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//
//        try {
//            Class.forName("com.mysql.jdbc.Driver").newInstance();
//        } catch (Exception ex) {
//            System.out.println("Error, no se ha podido cargar MySQL JDBC Driver");
//        }
//
//    }
//
//    public void conexionBBDDBorrarUsuarios(String nombreApellido) {
//
//        try {
//
//            String url = "jdbc:mysql://localhost:3306/pruebausuario";
//            String username = "root";
//            String password = "1234a";
//
//            Connection connection = DriverManager.getConnection(url, username, password);
//
//            Statement statement = connection.createStatement();
//            ResultSet rs = statement.executeQuery("delete from ususario where usuario = '" + nombreApellido + "';");
//
//            rs.close();
//            statement.close();
//            connection.close();
//
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//
//        try {
//            Class.forName("com.mysql.jdbc.Driver").newInstance();
//        } catch (Exception ex) {
//            System.out.println("Error, no se ha podido cargar MySQL JDBC Driver");
//        }
//
//    }

}
