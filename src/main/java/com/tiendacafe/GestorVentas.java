package com.tiendacafe;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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

    /**
     * Devuelve la lista de ventas registradas.
     *
     * @return Lista de ventas.
     */

    public ArrayList<Venta> getListaVentas() {
        return listaVentas;
    }

    public GestorVentas(ArrayList<Cliente> listaClientes, ArrayList<Cafe> listaCafes){

        this.listaClientes = listaClientes;
        this.listaCafes = listaCafes;
        this.listaVentas = new ArrayList<>();
    }

    /**
     * Devuelve una lista de ventas asociadas a un cliente específico según su DNI.
     *
     * Recorre todas las ventas registradas y selecciona aquellas que pertenezcan
     * al cliente con el DNI proporcionado (ignorando mayúsculas/minúsculas).
     *
     * @param dni DNI del cliente del cual se quieren obtener las ventas.
     * @return Lista de objetos {@link Venta} correspondientes al cliente. Si no hay ventas, la lista estará vacía.
     */
    public List<Venta> getVentasPorCliente(String dni) {
        List<Venta> ventasCliente = new ArrayList<>();
        for (Venta venta : listaVentas) {
            if (venta.getCliente().getDni().equalsIgnoreCase(dni)) {
                ventasCliente.add(venta);
            }
        }
        return ventasCliente;
    }


    /**
     * Crea una nueva venta para un cliente existente.
     *
     * Muestra el catálogo de cafés disponibles y permite al usuario seleccionar productos
     * por nombre o por variedad. Por cada café seleccionado, se solicita la cantidad deseada.
     *
     * Si hay stock suficiente, se añaden las unidades solicitadas a la venta.
     * Si el stock es insuficiente, pero mayor que cero, se añaden únicamente las unidades disponibles.
     * Si el stock es cero, el producto no se añade y se muestra un aviso.
     *
     * La venta se registra con la fecha actual y se almacena en la lista de ventas.
     * Si el cliente no está registrado, se cancela la operación.
     *
     * @param dniCliente DNI del cliente que realiza la compra.
     * @param nombresCafes Lista de nombres o variedades (no se usa directamente si se gestiona por consola).
     */
    public void crearVenta(String dniCliente, ArrayList<String> nombresCafes){

        Cliente cliente = buscarClientePorDni(dniCliente);

        if(cliente == null){
            System.out.println("\nEl cliente con DNI " + dniCliente + " no existe.");
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



        do {
            System.out.print("\nIntroduce el nombre o variedad del café (o escribe 'fin' para terminar): ");
            String entrada = scanner.nextLine().trim();

            if (entrada.equalsIgnoreCase("fin")) break;

            System.out.println("\n¿Cuántas unidades quieres comprar de ese café?");
            int cantidadSolicitada = scanner.nextInt();
            scanner.nextLine();

            Cafe cafe = null;

            if (opcion == 1) {
                cafe = buscarCafePorNombre(entrada);
            } else if (opcion == 2) {
                cafe = buscarCafePorVariedad(entrada);
            }

            if (cafe != null) {
                if (cafe.getStock() == 0) {
                    System.out.println("No hay stock disponible de " + cafe.getNombre());
                }else {
                    int cantidadReal = Math.min(cantidadSolicitada, cafe.getStock());

                    for (int i = 0; i < cantidadReal; i++) {
                        cafesSeleccionados.add(cafe);

                    }

                    cafe.setStock(cafe.getStock() - cantidadReal);
                    System.out.println("Añadidas " + cantidadReal + " unidades de " + cafe.getNombre());
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
     * Solicita el DNI de un cliente por consola y muestra todas sus ventas registradas.
     *
     * Utiliza el mé_todo {@link #getVentasPorCliente(String)} para obtener las ventas.
     * Si existen ventas, se muestran por consola. Si no hay ninguna, se informa al usuario.
     */
    public void mostrarVentasPorCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nIntroduce el DNI del cliente: ");
        String dni = scanner.nextLine().trim().toUpperCase();

        List<Venta> ventasDelCliente = getVentasPorCliente(dni);

        System.out.println("\n=== VENTAS DEL CLIENTE CON DNI: " + dni + " ===");

        if (ventasDelCliente.isEmpty()) {
            System.out.println("No hay ventas registradas para este cliente.");
            return;
        }

        for (Venta venta : ventasDelCliente) {
            System.out.println(venta);
            System.out.println("----------------------------------------");
        }
    }


    /**
     * Muestra por consola los importes de todas las ventas realizadas por un cliente específico.
     *
     * Recorre la lista de ventas y filtra aquellas asociadas al DNI proporcionado.
     * Para cada venta encontrada, se imprime:
     * - El número de la venta
     * - La fecha en la que se realizó
     * - El total de la venta
     *
     * Si no se encuentran ventas registradas para ese cliente, se muestra un mensaje informativo.
     *
     * @param dni DNI del cliente cuyas ventas se desean consultar.
     */
    public void mostrarImportesPorCliente(String dni) {

        dni = dni.trim().toUpperCase();
        boolean ventasEncontradas = false;
        int contador = 1;

        System.out.println("\n=== IMPORTES DE VENTAS PARA EL CLIENTE CON DNI: " + dni + " ===");

        for (Venta venta : listaVentas) {
            if (venta.getCliente().getDni().equalsIgnoreCase(dni)) {
                System.out.println("Venta " + contador + ":");
                System.out.println("Fecha: " + venta.getFecha());
                System.out.println("Total: " + venta.calcularTotal() + " €");
                System.out.println("------------------------------------------");
                ventasEncontradas = true;
                contador++;
            }
        }

        if (!ventasEncontradas) {
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
