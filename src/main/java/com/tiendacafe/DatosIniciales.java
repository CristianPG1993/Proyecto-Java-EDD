package com.tiendacafe;

import com.tiendacafe.Cliente;
import com.tiendacafe.Cafe;

import java.util.ArrayList;

/**
 * Clase encargada de proporcionar datos predefinidos de ejemplo
 * para facilitar las pruebas del sistema sin tener que introducirlos manualmente.
 *
 * Carga un conjunto de clientes y cafés en listas proporcionadas por el usuario.
 * Esta clase puede utilizarse al inicio de la aplicación para poblar las estructuras
 * de datos con información básica.
 *
 * @author Cristian
 * @version 1.0
 */

public class DatosIniciales {

    /**
     * Añade cinco clientes de ejemplo a la lista proporcionada.
     *
     * @param listaClientes Lista de clientes donde se agregarán los datos iniciales.
     */

    public static void cargarClientes(ArrayList<Cliente> listaClientes){

        listaClientes.add(new Cliente("Laura Sánchez", "12345678A", "600123456", "laura@example.com"));
        listaClientes.add(new Cliente("Pedro Ramírez", "23456789B", "600234567", "pedro@example.com"));
        listaClientes.add(new Cliente("Marta Gómez", "34567890C", "600345678", "marta@example.com"));
        listaClientes.add(new Cliente("Carlos Díaz", "45678901D", "600456789", "carlos@example.com"));
        listaClientes.add(new Cliente("Lucía Torres", "56789012E", "600567890", "lucia@example.com"));


    }

    /**
     * Añade quince cafés de ejemplo a la lista proporcionada.
     *
     * @param listaCafes Lista de cafés donde se agregarán los datos iniciales.
     */

    public static void cargarCafes(ArrayList<Cafe> listaCafes){

        listaCafes.add(new Cafe("Café Andes", "Arábica", "Colombia", 3.50, 20));
        listaCafes.add(new Cafe("Monte Verde", "Robusta", "Brasil", 2.80, 15));
        listaCafes.add(new Cafe("Noche Oscura", "Blend", "Guatemala", 4.20, 10));
        listaCafes.add(new Cafe("Sabor Intenso", "Robusta", "Vietnam", 2.90, 25));
        listaCafes.add(new Cafe("Dulce Aroma", "Arábica", "Honduras", 3.70, 18));
        listaCafes.add(new Cafe("Tierra Fértil", "Blend", "Etiopía", 4.00, 12));
        listaCafes.add(new Cafe("Río Negro", "Arábica", "Perú", 3.60, 14));
        listaCafes.add(new Cafe("Sol de Java", "Robusta", "Indonesia", 3.00, 22));
        listaCafes.add(new Cafe("Gran Altura", "Arábica", "México", 3.40, 19));
        listaCafes.add(new Cafe("Volcán", "Blend", "Costa Rica", 4.10, 11));
        listaCafes.add(new Cafe("Selva Negra", "Arábica", "Nicaragua", 3.80, 16));
        listaCafes.add(new Cafe("Despertar", "Robusta", "India", 2.70, 20));
        listaCafes.add(new Cafe("Amanecer", "Blend", "Tanzania", 4.00, 13));
        listaCafes.add(new Cafe("Clásico", "Arábica", "Kenia", 3.90, 17));
        listaCafes.add(new Cafe("Espresso Real", "Robusta", "Uganda", 2.60, 21));

    }
}
