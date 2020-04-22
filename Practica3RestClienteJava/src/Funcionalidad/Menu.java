package Funcionalidad;

import Recursos.Receta;
import Recursos.Recetario;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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

        while (opcion != 0) {

            System.out.println("-------------------------------------------------------------------Menú--------------------------------------------------------------------------------");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("Para acceder al Menú Recetario introduzca 1");
            System.out.println();
            System.out.println("Para acceder al Menú Receta introduzca 2");
            System.out.println();
            System.out.println("Para validar un fichero XSD introduzca 3");
            System.out.println();
            System.out.println("Para salir del Menú  introduzca 0");
            System.out.println();
            System.out.print("respuesta: ");

            opcion = Integer.parseInt(scanner.nextLine());
            switch (opcion) {
                case 0:
                    System.out.println("Saliendo del programa");
                    break;

                case 1:
                    limpiarTerminal(20);
                    while (opcion != 0) {

                        try {
                            System.out.println("-----------------------Menú Recetario-------------------------------");
                            System.out.println("Para crear el recetario introduzca 1");
                            System.out.println();
                            System.out.println("Para leer el recetario introduzca 2");
                            System.out.println();
                            System.out.println("Para importar el recetario introduzca 3");
                            System.out.println();
                            System.out.println("Para exportar el recetario introduzca 4");
                            System.out.println();
                            System.out.println("Para salir del Menú Recetario introduzca 0");
                            System.out.println();
                            System.out.print("respuesta: ");
                            opcion = Integer.parseInt(scanner.nextLine());
                            switch (opcion) {
                                case 1:
                                    //crear recetario
                                    System.out.println("En esta opcion creará el recetario con las recetas introucidas o importadas");
                                    System.out.println("Introduce el nombre del recetario");
                                    respuesta = scanner.nextLine();
                                    System.out.println("Introduce el precio del recetario");
                                    respuesta2 = scanner.nextLine();
                                    modelo.crearRecetario(modelo.crearRecetarioEsructura(respuesta, Double.parseDouble(respuesta2)));

                                    break;

                                case 2:
                                    //leer recetario
                                    listarRecetario(modelo.obtenerRecetario());
                                    break;
                                case 3:
                                    // Importar recetario
                                    System.out.println("Introduce el nombre del fichero sin la extensión del recetario");
                                    respuesta = scanner.nextLine();
                                    modelo.importarRecetario(new File(ruta + "/files/xml/" + respuesta + ".xml"));
                                    break;
                                case 4:
                                    //Exportar recetario
                                    System.out.println("Introduce el nombre del fichero sin la extensión del recetario");
                                    respuesta = scanner.nextLine();
                                    modelo.leerBytes(modelo.exportarRecetario(respuesta), respuesta);
                                    break;

                                default:
                                    System.out.println("Error, introduzca un numero del 0 al 4");

                            }
                        } catch (IOException ex) {
                            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                    opcion = -1;
                    limpiarTerminal(20);
                    break;
                case 2:
                    limpiarTerminal(10);
                    while (opcion != 0) {

                        try {
                            System.out.println("-----------------------Menú Receta-------------------------------");
                            System.out.println();
                            System.out.println();
                            System.out.println("Para crear la receta introduzca 1");

                            System.out.println("Para leer la receta introduzca 2");

                            System.out.println("Para borrar la receta introduzca 3");

                            System.out.println("Para importar la receta introduzca 4");

                            System.out.println("Para exportar la receta introduzca 5");

                            System.out.println("Para salir del Menú Receta introduzca 0");
                            System.out.println();
                            System.out.print("respuesta: ");
                            opcion = Integer.parseInt(scanner.nextLine());
                            switch (opcion) {
                                case 1:
                                    //crear recetas
                                    System.out.println("Introduce el nombre de la receta");
                                    respuesta = scanner.nextLine();
                                    System.out.println("Introduce la dificultad de la receta");
                                    respuesta2 = scanner.nextLine();
                                    System.out.println("Introduce el precio de la receta");
                                    respuesta4 = scanner.nextLine();
                                    modelo.addReceta(modelo.crearRecetaEsructura(respuesta, respuesta2, Double.parseDouble(respuesta4), pedirIngredientes()));
                                    limpiarTerminal(10);
                                    break;

                                case 2:
                                    // Lee la receta escogida
                                    System.out.println("Introduce el nombre de la receta");
                                    respuesta = scanner.nextLine();
                                    listarReceta(modelo.obtenerReceta(respuesta));
                                    break;
                                case 3:
                                    // Borra la receta escogida
                                    System.out.println("Introduce el nombre de la receta");
                                    respuesta = scanner.nextLine();
                                    modelo.rmvReceta(respuesta);
                                    limpiarTerminal(10);
                                    break;
                                case 4:
                                    //importar receta
                                    System.out.println("Introduce el nombre del fichero sin la extensión de la receta");
                                    respuesta = scanner.nextLine();
                                    modelo.importarReceta(new File(ruta + "/files/xml/" + respuesta + ".xml"));
                                    limpiarTerminal(10);
                                    break;
                                case 5:
                                    //exportar receta
                                    System.out.println("En esta opcion creará el nombre del xml de la receta.");
                                    System.out.println("Introduce el nombre de la receta a exportar");
                                    respuesta = scanner.nextLine();
                                    modelo.leerBytes(modelo.exportarReceta(respuesta + ".xml", respuesta), respuesta);
                                    limpiarTerminal(10);
                                    break;

                                default:
                                    System.out.println("Error, introduzca un numero del 0 al 5");

                            }
                        } catch (IOException ex) {
                            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    opcion = -1;
                    limpiarTerminal(20);
                    break;
                case 3:
                    limpiarTerminal(20);
                    System.out.println("-----------------------Menú Validar XML-------------------------------");
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println("Introduce el nombre del XML a validar sin extension: ");
                    respuesta = scanner.nextLine();
                    try {
                        System.out.println();
                        System.out.println(modelo.validarXSD(new File(ruta + "/files/xml/" + respuesta + ".xml")));
                    } catch (IOException ex) {
                        Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                default:
                    System.out.println("Error, introduzca un numero del 0 al 3");

            }
        }

    }

    private void limpiarTerminal(int valor) {
        for (int i = 0; i < valor; i++) {
            System.out.println();
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

                String recetas = " ";
                for (Receta receta : recetario.getRecetas()) {
                    recetas = recetas + receta.getNombre() + ", ";
                }
                System.out.println("Posee las siguientes recetas:" + recetas);
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

            String ing = " ";
            for (String ele : receta.getIngrediente()) {
                ing = ing + ele + ", ";
            }
            System.out.println("tiene los siguientes ingredientes:" + ing);
            System.out.println("Su precio es: " + receta.getPrecio());
            return true;
        }

    }

}
