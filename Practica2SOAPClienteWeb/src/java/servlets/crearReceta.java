/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import serviciosweb.Receta;
import serviciosweb.ServicioWebRecetario;
import serviciosweb.ServicioWebRecetario_Service;

/**
 *
 * @author david
 */
public class crearReceta extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
         
        response.setContentType("text/html;charset=UTF-8");
        String nombre = request.getParameter("nombre"); 
        String dificultad = request.getParameter("dificultad");
         String ingredientes =request.getParameter("ingredientes");
         Double precio = Double.parseDouble(request.getParameter("precio"));
         
         Modelo mod = new Modelo();
         
        String[] split = ingredientes.split(",");
       ArrayList<String> ar =new ArrayList();
       List<String> listaCadenas=Arrays.asList(split);
       ar.addAll(listaCadenas);
      
        mod.addReceta(mod.crearRecetaEsructura(nombre, dificultad, precio, ar) );
        try (PrintWriter out = response.getWriter()) {
            
             
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet crearReceta</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>La receta  " +mod.obtenerReceta(nombre).getNombre()+" fue creada </h1>");
            out.println("</body>");
            out.println("</html>");
            
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        processRequest(request, response);
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
        processRequest(request, response);
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
