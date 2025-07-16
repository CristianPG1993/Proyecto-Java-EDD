package com.tiendacafe;

import java.util.Scanner;

public class MenuCafes {

    public static void mostrarMenuCafes(GestorCafes gestorCafes){

        Scanner scanner = new Scanner(System.in);

        int opcion;

        do {

            System.out.println("\n=== MENU DE GESTIÓN DE CAFÉS ===");
            System.out.println("1. Dar de alta ");
            System.out.println("2. Listar cafés");
            System.out.println("3. Buscar cafés por variedad");
            System.out.println("4. Volver al menú principal");
            System.out.println("Elige una opción(1 - 4): ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion){
                case 1:
                    gestorCafes.darAltaCafe();
                    break;
                case 2:
                    gestorCafes.listarCafes();
                    break;
                case 3:
                    gestorCafes.buscarCafePorVariedad();
                    break;
                case 4:
                    System.out.println("Volviendo al menú principal....");
                    break;
                default:
                    System.out.println("Opción no válida.Inténtalo de nuevo:");

            }

        }while(opcion != 4);
    }
}
