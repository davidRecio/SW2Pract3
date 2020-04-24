/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebabdusuario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author darth
 */
public class PruebaBDUsuario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {

    String url = "jdbc:mysql://localhost:3306/pruebausuario";
    String username = "root";
    String password = "1234a";

    Connection connection = DriverManager.getConnection(url, username, password);

    Statement statement = connection.createStatement();
    ResultSet rs = statement.executeQuery("SELECT * FROM usuario");

    while (rs.next()) {

        int usuario_id = rs.getInt("usuario_id");
        String nombre = rs.getString("nombre");
        String contraseña = rs.getString("contraseña");
        

        System.out.println(String.format("%d, %s, %s", usuario_id, nombre, contraseña));
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
    

