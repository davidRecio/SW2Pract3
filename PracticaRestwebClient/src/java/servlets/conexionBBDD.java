/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 *
 * @author darth
 */
@WebServlet(name = "conexionBBDD", urlPatterns = {"/conexionBBDD"})
public class conexionBBDD extends HttpServlet {

    DataSource datasource;
    
     // Hay que crear la base de datos y la tabla USUARIO en mysql
    //CREATE TABLE USUARIO (         USUARIO_ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL,           NOMBRE VARCHAR(100),          CONTRASEÑA VARCHAR(8); 
    
    @Override
    public void init() throws ServletException {
        try {
            InitialContext initialContext = new InitialContext();
            datasource = (DataSource) initialContext.lookup("jdbc/EjemploDatabase"); //CAMBIAR
            Connection connection = datasource.getConnection();
            Statement createStatement = connection.createStatement();
            createStatement.execute("CREATE TABLE IF NOT EXISTS USUARIO (USUARIO_ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL, NOMBRE VARCHAR(100), CONTRASEÑA VARCHAR(8))");
            createStatement.close();
            connection.close();            
            
        } catch (NamingException | SQLException ex) {
            Logger.getLogger(conexionBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Listar Usuarios</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Lista de los usuarios en la base de datos:</h1>");
            out.println("<ul>");

            String query = null;
            query = "select *" + "from USUARIO";
            ResultSet resultSet = null;
            Statement statement = null;
            Connection connection = null;
            try {

                connection = datasource.getConnection();
                statement = connection.createStatement();
                resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    out.println("<li>"+ resultSet.getInt("ID USUARIO")
                            + "nombre: " + resultSet.getString("NOMBRE")
                            + " contraseña: " + resultSet.getString("CONTRASEÑA") + "</li>");
                }

            } catch (SQLException ex) {
                gestionarErrorEnConsultaSQL(ex, request, response);
            } finally {
                if (resultSet != null) {
                    try {
                        resultSet.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(conexionBBDD.class.getName()).log(Level.SEVERE,
                                "No se pudo cerrar el Resulset", ex);
                    }
                }
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(conexionBBDD.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(conexionBBDD.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
            out.println("</ul>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int usuario_id;
        try { 
            usuario_id = Integer.parseInt(request.getParameter("usuario_id"));
        } catch (NumberFormatException e) {
            usuario_id = -1;
        }
        String nombre = request.getParameter("nombre");
         String contraseña = request.getParameter("contraseña");
        
        ServletContext contexto = request.getServletContext();
        String query = null;
        
        query = "insert into USUARIO values('" + usuario_id + "',"
                + nombre + "'," + contraseña + ")";
        Statement statement = null;
        Connection connection = null;
        try {
            connection = datasource.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(query);

            request.setAttribute("nextPage", this.getServletContext().getContextPath() + "/conexionBBDD"); //CAMBIAR SEGURAMENTE SEA //conexionBBDD antes era /PoolDatabase
            RequestDispatcher paginaAltas
                    = contexto.getRequestDispatcher("/servlets/amigoInsertado.jsp"); // CAMBIAR SI QUEREMOS METER ESA JSP
            paginaAltas.forward(request, response);
        } catch (SQLException ex) {
            gestionarErrorEnConsultaSQL(ex, request, response);
        } finally {

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(conexionBBDD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(conexionBBDD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    private void gestionarErrorEnConsultaSQL(SQLException ex, HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        ServletContext contexto = request.getServletContext();
        Logger
                .getLogger(conexionBBDD.class
                        .getName()).log(Level.SEVERE, "No se pudo ejecutar la consulta contra la base de datos", ex);
        request.setAttribute("nextPage", this.getServletContext().getContextPath() + "/servlets/crearUsuario.html");
        request.setAttribute("error", ex);
        request.setAttribute("errorMessage", ex.getMessage());
        Logger
                .getLogger(conexionBBDD.class
                        .getName()).log(Level.INFO, "Set " + request.getAttribute("errorMessage"));

        RequestDispatcher paginaError = contexto.getRequestDispatcher("/servlets/errorSQL.jsp");
        paginaError.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
