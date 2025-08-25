package com.tiendacafe;

import com.tiendacafe.DatosIniciales;
import java.util.ArrayList;

/**
 * Clase principal de la aplicación.
 *
 * Se encarga de inicializar las listas de clientes y cafés,
 * cargar los datos de prueba mediante la clase {@link DatosIniciales}
 * y lanzar el menú principal de interacción con el usuario.
 *
 * Esta clase actúa como punto de entrada del sistema.
 *
 * @author Cristian
 * @version 1.0
 */

public class App {


    public static void main(String[] args) {

        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Cafe> cafes = new ArrayList<>();

        DatosIniciales.cargarClientes(clientes);
        DatosIniciales.cargarCafes(cafes);
        MenuPrincipal.mostrarMenuPrincipal(clientes, cafes);
    }

    
}
