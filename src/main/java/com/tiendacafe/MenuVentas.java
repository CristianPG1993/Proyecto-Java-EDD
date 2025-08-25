package com.tiendacafe;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase encargada de mostrar y gestionar el submenú de opciones relacionadas
 * con la gestión de ventas en la tienda de café.
 *
 * Incluye opciones para visualizar todas las ventas, filtrar por cliente
 * y consultar los importes totales.
 *
 * Esta clase actúa como controlador de interacción de usuario
 * para las funcionalidades ofrecidas por la clase GestorVentas.
 *
 * @author Cristian
 * @version 1.0
 */

public class MenuVentas {

    /**
     * Muestra el submenú de gestión de ventas y gestiona la interacción
     * con el usuario para mostrar todas las ventas, buscar por cliente
     * o visualizar importes totales por cliente.
     *
     * Permanece en un bucle hasta que el usuario selecciona la opción de volver.
     *
     * @param gestorVentas Objeto que contiene la lógica de gestión de ventas.
     */

    public static void mostrarMenuVentas(GestorVentas gestorVentas){

        Scanner scanner = new Scanner(System.in);

        int opcion = 0;

        do {
            System.out.println("\n=== GESTIÓN DE VENTAS ===");
            System.out.println("1. Mostrar todas las ventas");
            System.out.println("2. Mostrar ventas por cliente");
            System.out.println("3. Mostrar importe de ventas por cliente");
            System.out.println("4. Volver al menú principal");
            System.out.println("Elige una opción (1 - 4):");

            try{
                opcion = Integer.parseInt(scanner.nextLine());
                switch (opcion){
                    case 1:
                        gestorVentas.mostrarTodasLasVentas();
                        break;
                    case 2:
                        gestorVentas.mostrarVentasPorCliente();
                        break;
                    case 3:
                        System.out.println("Introduce el DNI del cliente: ");
                        String dni = scanner.nextLine().trim().toUpperCase();
                        gestorVentas.mostrarImportesPorCliente(dni);
                        break;
                    case 4:
                        System.out.println("Volviendo al menú principal...");
                        break;
                    default:
                        System.out.println("Opción no válida. ");
                }

            }catch(NumberFormatException e){
                    System.out.println("\nEntrada inválida. Debes introducir un número del 1 al 4.");
            }

        }while (opcion != 4);


    }

    public static void mostrarRealizarVenta(GestorVentas gestorVentas) {

        Scanner scanner = new Scanner(System.in);

        int opcion = 0;

        do {
            System.out.println("\n=== MENÚ DE VENTA ===");
            System.out.println("1. Relizar venta");
            System.out.println("2. Volver al menú principal");
            System.out.println("Elige una opción (1  ó 2):");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
                switch (opcion) {
                    case 1:
                        System.out.println("Introduce el dni:");
                        String dniCliente = scanner.nextLine();
                        ArrayList<String> cafesSeleccionados = new ArrayList<>();
                        gestorVentas.crearVenta(dniCliente, cafesSeleccionados);
                        break;
                    case 2:
                        System.out.println("Volviendo al menú principal...");
                        break;
                    default:
                        System.out.println("Opción no válida. ");
                }

            } catch (NumberFormatException e) {
                System.out.println("\nEntrada inválida. Debes introducir 1 ó 2.");
            }

        } while (opcion != 2);
    }
}
