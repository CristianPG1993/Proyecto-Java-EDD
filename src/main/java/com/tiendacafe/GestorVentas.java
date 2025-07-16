package com.tiendacafe;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase que gestiona las operaciones relacionadas con las ventas en la tienda de café.
 * Permite crear nuevas ventas, buscar cafés por nombre o variedad, controlar stock,
 * y almacenar las ventas realizadas.
 *
 * Utiliza listas internas de clientes, cafés disponibles y ventas registradas.
 *
 * @author Cristian
 * @version 1.0
 */

public class GestorVentas {

    private ArrayList<Venta> listaVentas;
    private ArrayList<Cafe> listaCafes;
    private ArrayList<Cliente> listaClientes;

    public GestorVentas(ArrayList<Cliente> listaClientes, ArrayList<Cafe> listaCafes){

        this.listaClientes = listaClientes;
        this.listaCafes = listaCafes;
        this.listaVentas = new ArrayList<>();
    }

    /**
     * Crea una nueva venta para un cliente existente, permitiendo seleccionar cafés del catálogo
     * por nombre o variedad. Controla el stock de cada café y guarda la venta con la fecha actual.
     *
     * Si el cliente no existe, la operación se cancela. El usuario puede añadir múltiples cafés
     * escribiendo su nombre o variedad uno por uno hasta finalizar.
     *
     * @param dniCliente DNI del cliente que realiza la compra.
     * @param nombresCafes Lista de nombres o variedades introducidos por el usuario (no se usa directamente si se gestiona por consola).
     */

    public void crearVenta(String dniCliente, ArrayList<String> nombresCafes){

        Cliente cliente = buscarClientePorDni(dniCliente);

        if(cliente == null){
            System.out.println("\nEl cliente con DNI " + dniCliente + "no existe.");
            return;

        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("\nCátalogo de cafés disponible:");
        for (Cafe cafe:listaCafes){
            System.out.println(cafe);
        }

        System.out.println("\n¿Cómo quieres seleccionar los cafés?");
        System.out.println("\n1. Por nombre");
        System.out.println("\n2. Por variedad");
        System.out.println("\nOpción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Cafe> cafesSeleccionados = new ArrayList<>();

        String entrada;
        do {
            System.out.print("\nIntroduce el nombre o variedad del café (o escribe 'fin' para terminar): ");
            entrada = scanner.nextLine().trim();

            if (entrada.equalsIgnoreCase("fin")) break;

            Cafe cafe = null;

            if (opcion == 1) {
                cafe = buscarCafePorNombre(entrada);
            } else if (opcion == 2) {
                cafe = buscarCafePorVariedad(entrada);
            }

            if (cafe != null) {
                if (cafe.getStock() > 0) {
                    cafesSeleccionados.add(cafe);
                    cafe.setStock(cafe.getStock() - 1);
                    System.out.println("Añadido: " + cafe.getNombre());
                } else {
                    System.out.println("Sin stock: " + cafe.getNombre());
                }
            } else {
                System.out.println("Café no encontrado.");
            }

        } while (true);


        String fechaActual = LocalDate.now().toString();

        Venta nuevaVenta = new Venta(cliente, cafesSeleccionados, fechaActual);

        listaVentas.add(nuevaVenta);

        System.out.println("Venta realizada correctamente: ");
        System.out.println(nuevaVenta);

    }

    /**
     * Muestra por consola todas las ventas registradas en el sistema.
     *
     * Recorre la lista de ventas y muestra los datos de cada una de ellas,
     * incluyendo cliente, fecha, cafés vendidos y total.
     *
     * Si no hay ventas registradas, se informa al usuario.
     */
    public void mostrarTodasLasVentas(){
        if(listaVentas.isEmpty()){

            System.out.println("\nNo hay ventas registradas.");
            return;
        }

        System.out.println("\n=== LISTADO DE TODAS LAS VENTAS ===");

        for (Venta venta:listaVentas){
            System.out.println(venta);
            System.out.println("----------------------------------");
        }
    }

    /**
     * Solicita el DNI de un cliente por consola y muestra todas las ventas
     * registradas asociadas a ese cliente.
     *
     * Recorre la lista de ventas y compara el DNI ingresado con el DNI de cada cliente.
     * Muestra los datos completos de cada venta, incluyendo fecha, cafés y total.
     *
     * Si no se encuentran ventas asociadas, informa al usuario.
     */

    public void mostrarVentasPorCliente(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nIntroduce el DNI del cliente: ");
        String dni = scanner.nextLine().trim().toUpperCase();

        boolean ventasEncontradas = false;

        System.out.println("\n=== VENTAS DEL CLIENTE CON DNI: " + dni + " ===");

        for (Venta venta:listaVentas){
            if(venta.getCliente().getDni().equalsIgnoreCase(dni)){
                System.out.println(venta);
                System.out.println("----------------------------------------");
                ventasEncontradas = true;
            }
        }

        if(!ventasEncontradas){
            System.out.println("No hay ventas registradas para este cliente.");
        }

    }

    /**
     * Solicita el DNI de un cliente por consola y muestra el importe total
     * de cada una de sus ventas registradas.
     *
     * Para cada venta asociada al cliente, se muestra la fecha y el total calculado
     * sumando los precios de los cafés vendidos.
     *
     * Si no se encuentran ventas para el cliente, se informa por consola.
     */
    public void mostrarImportesPorCliente(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el DNI para mostrar el importe de las ventas:");
        String dni = scanner.nextLine().trim().toUpperCase();

        boolean ventasEncontradas = false;
        int contador = 1;

        System.out.println("\n=== IMPORTES DE VENTAS PARA EL CLIENTE CON DNI: " + dni + " ===");


        for (Venta venta:listaVentas){

            if(venta.getCliente().getDni().equalsIgnoreCase(dni)){
                System.out.println("Venta " + contador + ":");
                System.out.println("Fecha " + venta.getFecha());
                System.out.println("Total: " + venta.calcularTotal() + " €");
                System.out.println("------------------------------------------");
                ventasEncontradas = true;
                contador++;
            }

        }
        if(!ventasEncontradas){
            System.out.println("No hay ventas registradas para este cliente.");
        }
    }

    //Mé_todos privados

    /**
     * Busca un cliente en la lista de clientes registrados a partir de su DNI.
     *
     * @param dni DNI del cliente que se desea buscar.
     * @return El objeto Cliente si se encuentra; null si no existe en la lista.
     */

    private Cliente buscarClientePorDni(String dni) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getDni().equalsIgnoreCase(dni)) {
                return cliente;
            }
        }
        return null;
    }

    /**
     * Busca un café en el catálogo a partir de su nombre.
     * La comparación no distingue entre mayúsculas y minúsculas.
     *
     * @param nombre Nombre del café a buscar.
     * @return El objeto Cafe si se encuentra; null si no existe.
     */

    private Cafe buscarCafePorNombre(String nombre){
        for (Cafe cafe:listaCafes) {
            if (cafe.getNombre().equalsIgnoreCase(nombre)) {
                return cafe;
            }
        }
        return null;
    }

    /**
     * Busca un café en el catálogo a partir de su variedad.
     * La comparación no distingue entre mayúsculas y minúsculas.
     *
     * @param variedad Variedad del café a buscar.
     * @return El objeto Cafe si se encuentra; null si no existe.
     */

    private Cafe buscarCafePorVariedad(String variedad){
        for (Cafe cafe:listaCafes){
            if(cafe.getVariedad().equalsIgnoreCase(variedad)){
                return cafe;
            }
        }
        return null;
    }


}
