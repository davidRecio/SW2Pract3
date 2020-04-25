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

/**
 *
 * @author david
 */
public class AccesoBBDD {

    //refactor para q sea unica
    public ArrayList<Usuario> conexionBBDDListarUsuarios() {
        ArrayList<Usuario> ArrayListUser = new ArrayList();
       
        try {

            String url = "jdbc:mysql://localhost:3306/pruebausuario";
            String username = "root";
            String password = "1234a";

            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM usuario");

            while (rs.next()) {
                Usuario user = new Usuario();
                user.setNombre(rs.getString("nombre"));
                user.setPassword(rs.getString("contraseña"));

                ArrayListUser.add(user);
          
            }

            rs.close();
            statement.close();
            connection.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            System.out.println("Error, no se ha podido cargar MySQL JDBC Driver");
        }
        return ArrayListUser;

    }

    public void conexionBBDDCrearUsuarios(String nombreApellido, String pass) {

        try {

            String url = "jdbc:mysql://localhost:3306/pruebausuario";
            String username = "root";
            String password = "1234a";

            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("insert into usuario value('6', '" + nombreApellido + "', '" + pass + "');");

            rs.close();
            statement.close();
            connection.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            System.out.println("Error, no se ha podido cargar MySQL JDBC Driver");
        }

    }

    public void conexionBBDDBorrarUsuarios(String nombreApellido) {

        try {

            String url = "jdbc:mysql://localhost:3306/pruebausuario";
            String username = "root";
            String password = "1234a";

            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("delete from ususario where usuario = '" + nombreApellido + "';");

            rs.close();
            statement.close();
            connection.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            System.out.println("Error, no se ha podido cargar MySQL JDBC Driver");
        }

    }

}
