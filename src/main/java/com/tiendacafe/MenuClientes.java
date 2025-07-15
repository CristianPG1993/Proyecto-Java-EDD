package com.tiendacafe;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;

/**
 * Clase que representa el submenú interactivo para la gestión de clientes en la tienda de café.
 *
 * Ofrece un menú en consola que permite al usuario acceder a las operaciones disponibles
 * del {@link GestorClientes}, como añadir, eliminar, modificar, buscar y listar clientes.
 *
 * Este menú forma parte de la estructura modular del sistema y está pensado para ser
 * llamado desde el menú principal de la aplicación.
 *
 * @author Cristian
 * @version 1.0
 */

public class MenuClientes {

    /**
     * Muestra el submenú de gestión de clientes por consola.
     *
     * Permite al usuario seleccionar entre diferentes opciones para:
     * - Añadir un nuevo cliente
     * - Eliminar un cliente existente
     * - Modificar los datos de un cliente
     * - Buscar un cliente por su DNI
     * - Listar todos los clientes registrados
     * - Volver al menú principal
     *
     * Las operaciones se realizan invocando métodos del {@link GestorClientes}.
     * El menú se repite hasta que el usuario selecciona la opción de salir (opción 6).
     *
     * @param gestorClientes instancia de {@link GestorClientes} que contiene la lógica y la lista de clientes
     */

    public static void mostrarMenu(GestorClientes gestorClientes){

        Scanner scanner = new Scanner(System.in);

        int opcion = 0;

        do {

            System.out.println("\n=== MENÚ CLIENTES ===");
            System.out.println("\n1. Añadir cliente");
            System.out.println("\n2. Eliminar cliente");
            System.out.println("\n3. Modificar cliente");
            System.out.println("\n4. Buscar cliente por DNI");
            System.out.println("\n5. Listar todos los clientes");
            System.out.println("\n6. Volver al menú principal");

            System.out.println("Introduce la opción que desea hacer(1 - 6): ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion){
                case 1:
                    gestorClientes.agregarCliente();
                    break;
                case 2:
                    gestorClientes.eliminarCliente();
                    break;
                case 3:
                    gestorClientes.modificarCliente();
                    break;
                case 4:
                    gestorClientes.buscarClientePorDni();
                    break;
                case 5:
                    gestorClientes.listarClientes();
                    break;
                case 6:
                    System.out.println("Volviendo al menú principal......");
                    break;
                default:
                    System.out.println("Opción no válida.");

            }
        }while(opcion != 6);


    }
}
