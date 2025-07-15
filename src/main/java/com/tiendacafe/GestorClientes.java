package com.tiendacafe;

import java.util.*;

/**
 * Clase que gestiona las operaciones relacionadas con los clientes de la tienda de café.
 * Permite dar de alta, baja, modificar, buscar y listar clientes.
 *
 * @author Cristian
 * @version 1.0
 */


public class GestorClientes {



    private ArrayList<Cliente> listaClientes;

    /**
     * Constructor que inicializa la lista de clientes vacía.
     */

    public GestorClientes(){

        this.listaClientes = new ArrayList<>();

    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    /**
     * Añade un nuevo cliente a la lista si el DNI no está ya registrado.
     * Solicita por consola el resto de datos del cliente (nombre, teléfono y email),
     * validando que todos los campos sean correctos antes de crear el objeto.
     *
     * @return true si el cliente se añadió correctamente, false si ya existía.
     */
    public boolean agregarCliente(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("\nIntroduce el DNI: ");
        String dni = scanner.nextLine().toUpperCase();


        for (int i = 0; i < listaClientes.size(); i++) {

            if (listaClientes.get(i).getDni().equals(dni)) {
                System.out.println("\nEl DNI introducido ya está registrado.");
                return false;
            }

        }

        System.out.println("\nDatos usuario nuevo: ");


        System.out.println("\nIntroduce nombre del cliente: ");
        String nombre = scanner.nextLine().toUpperCase();

        while (nombre.isEmpty() || !nombre.matches("^[A-Za-zÁÉÍÓÚáéíóúÑñ\\\\s]+$")){

            System.out.println("\nIntroduce un nombre correcto(El campo no puede" +
                    " estar vacío ni tener letras o símbolos): ");
            nombre = scanner.nextLine().toUpperCase();

        }

        System.out.println("\nIntroduce un número de teléfono: ");
        String telefono = scanner.nextLine();

        while (telefono.isEmpty() || !telefono.matches("\\d{9}")){

            System.out.println("\nIntroduce un número de teléfono válido (9 cifras): ");
            telefono = scanner.nextLine();

        }


        System.out.println("\nIntroduce un email: ");
        String email = scanner.nextLine();

        while(email.isEmpty() || !email.contains("@") || email.indexOf("@") == 0 ||
                email.endsWith("@") || !email.contains(".")){

            System.out.println("\nIntroduce un email válido ( debe tener @ y .): ");
            email = scanner.nextLine();

        }

        Cliente nuevoCliente = new Cliente(nombre, dni, telefono, email);
        listaClientes.add(nuevoCliente);

        return true;

    }


    /**
     * Elimina un cliente de la lista según el DNI introducido por el usuario.
     * Si se encuentra un cliente con ese DNI, se elimina de la lista.
     * Muestra mensajes informativos durante el proceso.
     *
     * @return true si el cliente fue eliminado correctamente, false si no se encontró.
     */
    public boolean eliminarCliente(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("\nIntroduce el DNI: ");
        String dni = scanner.nextLine().toUpperCase();

        for (int i = 0; i < listaClientes.size(); i++) {

            if (listaClientes.get(i).getDni().equals(dni)) {

                listaClientes.remove(i);
                System.out.println("\nEl usuario con DNI: " + dni +
                        " ha sido eliminado correctamente. ");
                return true;
            }

        }

        System.out.println("El DNI introducido no está registrado y no se puede eliminar.");
        return false;

    }

    /**
     * Modifica los datos de un cliente existente, identificado por su DNI.
     * Si se encuentra el cliente, se ofrece un menú para modificar nombre, teléfono o email.
     * Cada campo es validado antes de ser actualizado. El menú se repite hasta que se elige salir.
     *
     * @return true si el cliente existe y se accede al menú de modificación, false si no se encuentra.
     */
    public boolean modificarCliente(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce el DNI: ");
        String dni = scanner.nextLine().toUpperCase();

        Cliente clienteEncontrado = null;

        for (int i = 0; i < listaClientes.size(); i++) {

            if (listaClientes.get(i).getDni().equals(dni)) {

                clienteEncontrado = listaClientes.get(i);
                break;
            }

        }

        if(clienteEncontrado == null){

            System.out.println("El cliente con el DNI indicado no existe.");
            return false;
        }


        int opcion = 0;

        do {

            System.out.println("\n¿Que desea modificar? Seleccione un número: ");
            System.out.println("\n1. Nombre");
            System.out.println("\n2. Teléfono");
            System.out.println("\n3. Email");
            System.out.println("\n4. Salir");
            System.out.println("Opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion){
                case 1:
                    System.out.println("Introduce el nuevo nombre:");
                    String nuevoNombre = scanner.nextLine().toUpperCase();

                    while (nuevoNombre.isEmpty() || !nuevoNombre.matches("^[A-Za-zÁÉÍÓÚáéíóúÑñ\\s]+$")) {
                        System.out.println("Nombre inválido. Introduce solo letras y espacios:");
                        nuevoNombre = scanner.nextLine().toUpperCase();
                    }

                    clienteEncontrado.setNombre(nuevoNombre);
                    System.out.println("Nombre actualizado correctamente.");
                    break;

                case 2:
                    System.out.println("Introduce el teléfono nuevo: ");
                    String nuevoTelefono = scanner.nextLine();

                    while (nuevoTelefono.isEmpty() || !nuevoTelefono.matches("\\d{9}")){

                        System.out.println("Introduce un teléfono válido.");
                        nuevoTelefono = scanner.nextLine();
                    }

                    clienteEncontrado.setTelefono(nuevoTelefono);
                    System.out.println("Teléfono actualizado correctamente.");
                    break;
                case 3:
                    System.out.println("Introduce el nuevo email: ");
                    String nuevoEmail = scanner.nextLine();

                    while(nuevoEmail.isEmpty() || !nuevoEmail.contains("@") || nuevoEmail.indexOf("@") == 0 ||
                            nuevoEmail.endsWith("@") || !nuevoEmail.contains(".")){

                        System.out.println("\nIntroduce un email válido ( debe tener @ y .): ");
                        nuevoEmail = scanner.nextLine();

                    }

                    clienteEncontrado.setEmail(nuevoEmail);
                    System.out.println("Email actualizado correctamente.");
                    break;

                case 4:
                    System.out.println("Has seleccionado salir del menú de modificación.");
                    break;

                default:
                    System.out.println("Introduce un número válido.");


            }

        }while(opcion != 4);

        System.out.println("Menú de modificación cerrado correctamente. ");
        return true;
    }

    /**
     * Busca un cliente en la lista a partir del DNI introducido por el usuario.
     * Si el cliente existe, muestra sus datos por consola y lo devuelve.
     * En caso contrario, muestra un mensaje y devuelve null.
     *
     * @return el cliente encontrado o null si no existe.
     */
    public Cliente buscarClientePorDni(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce el DNI: ");
        String dni = scanner.nextLine().toUpperCase();

        Cliente clienteEncontrado = null;


        for (int i = 0; i < listaClientes.size(); i++) {

            if (listaClientes.get(i).getDni().equals(dni)){

                clienteEncontrado = listaClientes.get(i);

                System.out.println("Cliente encontrado:");
                System.out.println("Nombre: " + clienteEncontrado.getNombre());
                System.out.println("DNI: " + clienteEncontrado.getDni());
                System.out.println("Teléfono: " + clienteEncontrado.getTelefono());
                System.out.println("Email: " + clienteEncontrado.getEmail());

                return clienteEncontrado;

            }

        }
        System.out.println("No se ha encontrado el cliente. ");
        return null;

    }

    /**
     * Muestra por consola la lista completa de clientes registrados,
     * ordenados alfabéticamente por nombre.
     * Si no hay clientes, se muestra un mensaje informativo.
     */

    public void listarClientes(){

        if (listaClientes.isEmpty()){

            System.out.println("No hay clientes registrados. ");
        }else {

            listaClientes.sort(Comparator.comparing(Cliente::getNombre));

            for (int i = 0; i < listaClientes.size(); i++) {

                System.out.println("\n Cliente " + (i + 1) + ":");
                System.out.println("Nombre: " + listaClientes.get(i).getNombre());
                System.out.println("DNI: " + listaClientes.get(i).getDni());
                System.out.println("Teléfono: " + listaClientes.get(i).getTelefono());
                System.out.println("Email: " + listaClientes.get(i).getEmail());
            }
        }
    }

}
