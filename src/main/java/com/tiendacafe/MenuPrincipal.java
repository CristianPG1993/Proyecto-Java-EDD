package com.tiendacafe;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase principal que representa el menú de navegación de la aplicación.
 * Permite al usuario acceder a las distintas funcionalidades del sistema,
 * como la gestión de clientes, productos (cafés) y ventas.
 *
 * Esta clase actúa como punto de entrada del programa de consola.
 * Las opciones del menú están organizadas de forma estructurada para facilitar
 * la navegación y ejecución de las tareas disponibles.
 *
 * @author Cristian
 * @version 1.0
 */

public class MenuPrincipal {


    /**
     * Muestra el menú principal de la aplicación en consola.
     *
     * Ofrece al usuario un conjunto de opciones para gestionar clientes,
     * cafés, realizar ventas y visualizar las ventas existentes.
     *
     * Utiliza estructuras de control para ejecutar las acciones correspondientes
     * en función de la opción seleccionada. También incluye validación de entrada
     * para evitar errores por datos incorrectos.
     *
     * El menú se repite en bucle hasta que el usuario selecciona la opción de salir.
     */

    public static void mostrarMenuPrincipal(ArrayList<Cliente> listaClientes, ArrayList<Cafe> listaCafes){

        Scanner scanner = new Scanner(System.in);

        int opcion = 0;

        GestorClientes gestorClientes = new GestorClientes(listaClientes);
        GestorCafes gestorCafes = new GestorCafes(listaCafes);
        GestorVentas gestorVentas = new GestorVentas(listaClientes, listaCafes);

        do {


            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Gestión de clientes");
            System.out.println("2. Gestión de cafés");
            System.out.println("3. Realizar venta");
            System.out.println("4. Mostrar ventas");
            System.out.println("5. Salir");
            System.out.println("¿Que opción desea realizar(1 - 5)?");


            try{
                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion){
                    case 1:
                        System.out.println("Has elegido Gestión de clientes");
                        MenuClientes.mostrarMenu(gestorClientes);
                        break;
                    case 2:
                        System.out.println("Has elegido Gestión de cafés");
                        MenuCafes.mostrarMenuCafes(gestorCafes);
                        break;
                    case 3:
                        System.out.println("Has elegido Realizar venta");
                        MenuVentas.mostrarRealizarVenta(gestorVentas);
                        break;
                    case 4:
                        System.out.println("Has elegido Mostrar ventas");
                        MenuVentas.mostrarMenuVentas(gestorVentas);
                        break;
                    case 5:
                        System.out.println("Saliendo del menú principal");
                        break;
                    default:
                        System.out.println("Opción no válida. Vuelve a intentarlo.");

                }

            } catch (NumberFormatException e) {
                System.out.println("Error: Debe introducir un número del al 5.");
            }


        }while(opcion != 5);
    }
}
