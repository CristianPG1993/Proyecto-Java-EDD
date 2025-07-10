package com.tiendacafe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;

/**
 * Clase de prueba unitaria para la clase {@link Venta}
 * Verifica que los métodos calcularTotal, addCafe y toString funcionan correctamente.
 *
 */


public class VentaTest {

    private Cliente cliente;
    private Cafe cafe1;
    private Cafe cafe2;
    private ArrayList<Cafe> listaCafes;
    private Venta venta;


    @BeforeEach
    void prepararDatos(){
        cliente = new Cliente("Laura", "09034502V",
                "612345678", "laura@email.com");

        cafe1 = new Cafe("Don Pedro", "Caturra",
                "Guatemala", 10.50);
        cafe2 = new Cafe("Monte Azul", "Bourbon",
                "El Salvador", 12);

        listaCafes = new ArrayList<>();
        listaCafes.add(cafe1);
        listaCafes.add(cafe2);

        venta = new Venta(cliente, listaCafes, "10-08-2025");

    }

    /**
     * Verifica que getCliente() devuelve el cliente correcto.
     */

    @Test
    public void testGetCliente(){

        assertEquals(cliente, venta.getCliente());
    }

    /**
     * Verifica que getLineasDeVenta() devuelve la lista correctamente.
     */

    @Test
    public void testGetLineasDeVenta(){

        assertEquals(listaCafes, venta.getLineasDeVenta());

    }

    /**
     * Verifica que getFecha() devuelve la fecha correcta.
     */

    @Test
    public void testGetFecha(){

        assertEquals("10-08-2025", venta.getFecha());

    }

    /**
     * Verifica que addCafe() añade correctamente un nuevo café a la lista.
     */

    @Test
    public void testAddCafe(){

        Cafe nuevoCafe = new Cafe("Geisha", "tostado",
                "Japón", 15);

        venta.addCafe(nuevoCafe);

        assertTrue(venta.getLineasDeVenta().contains(nuevoCafe));

    }

    /**
     * Verifica que calcularTotal() devuelve el valor correctamente.
     */

    @Test
    public void testCalcularTotal(){

        assertEquals(22.50, venta.calcularTotal());


    }

    /**
     * Verifica que toString() devuelve el formato esperado.
     */

    @Test
    public void testToString(){
        String esperado = venta.toString();

        assertTrue(esperado.contains("Laura"));
        assertTrue(esperado.contains("10-08-2025"));
        assertTrue(esperado.contains("Don Pedro"));
        assertTrue(esperado.contains("22.5"));
    }
}
