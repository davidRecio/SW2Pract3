/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basededatospruebapersona;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author darth
 */
public class BaseDeDatosPruebaPersona {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       

try {

    String url = "jdbc:mysql://localhost:3306/prueba";
    String username = "root";
    String password = "1234a";

    Connection connection = DriverManager.getConnection(url, username, password);

    Statement statement = connection.createStatement();
    ResultSet rs = statement.executeQuery("SELECT * FROM persona");

    while (rs.next()) {

        int id = rs.getInt("id");
        String nombre = rs.getString("nombre");
        String apellido = rs.getString("apellido");
        Date fecha = rs.getDate("fecha");

        System.out.println(String.format("%d, %s %s, %s", id, nombre, apellido, fecha));
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

    }
    
}
