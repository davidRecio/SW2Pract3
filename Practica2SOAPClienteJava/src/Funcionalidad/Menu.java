package Funcionalidad;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import serviciosweb.IOException_Exception;
import serviciosweb.Receta;
import serviciosweb.Recetario;

/**
 *
 * @author david
 */
public class Menu {

    private Scanner scanner = new Scanner(System.in);
    private Integer opcion = -1;
    private Modelo modelo = new Modelo();
    private String respuesta, respuesta2, respuesta4;
    private String sCarpAct = System.getProperty("user.dir");
    private File carpeta = new File(sCarpAct);
    private String ruta = carpeta.getPath();

    public void menu() {
        modelo.start();
        while (opcion != 0) {
            try {
                System.out.println("-------------------------------------------------------------------Menú--------------------------------------------------------------------------------");
                System.out.println("Elige una opcion, pulsa 0 para salir");
                System.out.println("1= Importar recetario, 2=Exportar recetario, 3=Exportar Receta, 4=Importar Receta");
                System.out.println("5= crea el recetario, 6=crea recetas, 7=Borra receta, 8=Lista recetas,");
                System.out.println("9=Lista la información de la receta escogida, 10=Valida fichero con XSD ");
                opcion = Integer.parseInt(scanner.nextLine());
                switch (opcion) {
                    case 0:
                        System.out.println("Saliendo del programa");
                        break;
                    case 1:
                        // Importar recetario
                        System.out.println("Introduce el nombre del fichero sin la extensión del recetario");
                        respuesta = scanner.nextLine();
                        modelo.importarRecetario(new File(ruta + "/files/xml/" + respuesta + ".xml"));
                        break;
                    case 2:
                        //Exportar recetario
                        System.out.println("Introduce el nombre del fichero sin la extensión del recetario");
                        respuesta = scanner.nextLine();
                        modelo.leerBytes(modelo.exportarRecetario(respuesta), respuesta);
                        break;
                    case 3:
                        //exportar receta
                        System.out.println("En esta opcion creará el nombre del xml de la receta.");
                        System.out.println("Introduce el nombre de la receta a exportar");
                        respuesta = scanner.nextLine();
                        modelo.leerBytes(modelo.exportarReceta(respuesta + ".xml", respuesta), respuesta);
                        break;
                    case 4:
                        //importo receta
                        System.out.println("Introduce el nombre del fichero sin la extensión de la receta");
                        respuesta = scanner.nextLine();
                        modelo.importarReceta(new File(ruta + "/files/xml/" + respuesta + ".xml"));
                        break;
                    case 5:
                        //crear recetario
                        System.out.println("En esta opcion creará el recetario con las recetas introucidas o importadas");
                        System.out.println("Introduce el nombre del recetario");
                        respuesta = scanner.nextLine();
                        System.out.println("Introduce el precio del recetario");
                        respuesta2 = scanner.nextLine();
                        modelo.crearRecetario(modelo.crearRecetarioEsructura(respuesta, Double.parseDouble(respuesta2)));
                        break;
                    case 6:
                        //crear recetas
                        System.out.println("Introduce el nombre de la receta");
                        respuesta = scanner.nextLine();
                        System.out.println("Introduce la dificultad de la receta");
                        respuesta2 = scanner.nextLine();
                        System.out.println("Introduce el precio de la receta");
                        respuesta4 = scanner.nextLine();
                        modelo.addReceta(modelo.crearRecetaEsructura(respuesta, respuesta2, Double.parseDouble(respuesta4), pedirIngredientes()));
                        break;
                    case 7:
                        // Listar recetas
                        System.out.println("Introduce el nombre de la receta");
                        respuesta = scanner.nextLine();
                        modelo.rmvReceta(respuesta);
                        break;
                    case 8:
                        // Listar recetas
                        listarRecetario(modelo.obtenerRecetario());
                        break;
                    case 9:
                        // Lista la receta escogida
                        System.out.println("Introduce el nombre de la receta");
                        respuesta = scanner.nextLine();
                        listarReceta(modelo.obtenerReceta(respuesta));
                        break;

                    case 10:
                        // validar XSD
                        System.out.println("Introduce el nombre del XML a validar sin extension: ");
                        respuesta = scanner.nextLine();
                        System.out.println(modelo.validarXSD(new File(ruta + "/files/xml/" + respuesta + ".xml")));
                        break;
                    default:
                        System.out.println("Error, introduzca un numero del cero al 11");

                }
            } catch (IOException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException_Exception ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private ArrayList pedirIngredientes() {
        ArrayList<String> ingredientes = new ArrayList();
        System.out.println("Introduce los ingredientes, para finalizar introduce como ultimo ingrediente un 0");
        while (respuesta.equals("0") != true) {
            respuesta = scanner.nextLine();
            if (respuesta.equals("0") == false) {

                ingredientes.add(respuesta);
            }

        }
        return ingredientes;
    }

    private boolean listarRecetario(Recetario recetario) {
        if (recetario == null) {
            return false;
        } else {
            System.out.println("El recetario " + recetario.getNombre());
            System.out.println("Cuesta: " + recetario.getPrecio());
            try {
                System.out.println("Posee las siguientes recetas: ");
                for (Receta receta : recetario.getRecetas().getRecetas()) {
                    System.out.println(receta.getNombre());
                }
            } catch (Exception e) {
                System.out.println("No posee recetas");
            }

            return true;
        }

    }

    private boolean listarReceta(Receta receta) {
        if (receta.getNombre() == null) {
            return false;
        } else {
            System.out.println("Su nombre es: " + receta.getNombre());
            System.out.println("La dificultad es: " + receta.getDificultad());
            System.out.println("tiene los siguientes ingredientes: ");
            for (String ele : receta.getIngrediente().getIngrediente()) {
                System.out.println(ele);
            }
            System.out.println("Su precio es: " + receta.getPrecio());
            return true;
        }

    }

}
