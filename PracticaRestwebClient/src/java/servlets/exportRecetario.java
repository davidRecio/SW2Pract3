///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// String nombre = request.getParameter("nombre"); 
//        Modelo mod = new Modelo();
//        
//         try {
//            mod.leerBytes(mod.exportarRecetario(nombre), nombre);
//        } catch (IOException_Exception ex) {
//            Logger.getLogger(exportRecetario.class.getName()).log(Level.SEVERE, null, ex);
//        }
// */
//package servlets;
//import javax.servlet.*;
//import javax.servlet.http.*;
//import java.io.*;
//import java.util.*;
//import java.net.*;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import serviciosweb.IOException_Exception;
//
//
///**
//*
//
//This class handles Streaming Data Content
//
//**/
//public class exportRecetario extends HttpServlet {
//
//    public void init(ServletConfig config) throws ServletException {
//        super.init(config);
//    }
//
//    /*
//    * This Method Handles Post
//    *
//    * @param HttpServletRequest request
//    * @param HttpServletResponse response
//    */
//    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doGet(request, response);
//    }
//
//    /*
//    * This Method Handles Get
//    *
//    * @param HttpServletRequest request
//    * @param HttpServletResponse response
//    */
//    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String urlstr = null;
//                 
//        String nombre = request.getParameter("nombre"); 
//        Modelo mod = new Modelo();
//        
//         try {
//            mod.leerBytes(mod.exportarRecetario(nombre), nombre);
//        } catch (IOException_Exception ex) {
//            Logger.getLogger(exportRecetario.class.getName()).log(Level.SEVERE, null, ex);
//        } 
//        
//        try {
//            response.reset();
//            urlstr = request.getParameter("nombre");
//            ServletOutputStream sOutStream = response.getOutputStream();
//            streamBinaryData(urlstr, sOutStream, response);
//              File someFile = new File("./files/xml/"+nombre+".xml");
//             someFile.delete();
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    private void streamBinaryData(String file, ServletOutputStream outstr, HttpServletResponse resp) throws IOException{
//        String ErrorStr = null;
//
//        try {
//        BufferedInputStream bis = null;
//        BufferedOutputStream bos = null;
//        String inFile = "./files/xml/" + file+".xml";
//        int tam = (int) new File(inFile).length();
//        bis = new BufferedInputStream(new FileInputStream(inFile));
//
//        try {
//            //Asignamos el tipo de fichero zip
//            resp.setContentType("application/x-zip-compressed"); //Cualquier mime type
//            //Seteamos el tamaño de la respuesta
//            resp.setContentLength(tam);
//            resp.setHeader("Content-Disposition", "attachment;filename=\"" + file + ".xml\"");
//
//            bos = new BufferedOutputStream(outstr);
//
//            // Bucle para leer de un fichero y escribir en el otro.
//            byte[] array = new byte[1000];
//            int leidos = bis.read(array);
//            while (leidos > 0) {
//                bos.write(array, 0, leidos);
//                leidos = bis.read(array);
//            }
//
//
//            } catch (Exception e) {
//                e.printStackTrace();
//                ErrorStr = "Error Streaming the Data";
//                outstr.print(ErrorStr);
//            } finally {
//                if (bis != null) {
//                    bis.close();
//                }
//                if (bos != null) {
//                    bos.close();
//                }
//                if (outstr != null) {
//                    outstr.flush();
//                    outstr.close();
//                }
//            }
//
//            } catch (Exception e) {
//                System.out.println("Fichero no encontrado");
//                resp.sendRedirect("fileNotFound.jsp");
//
//            }
//
//        }
//    }