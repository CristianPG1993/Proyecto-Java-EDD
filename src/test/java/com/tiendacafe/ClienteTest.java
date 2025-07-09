package com.tiendacafe;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de prueba unitaria para la clase {@link Cliente}
 * Verifica que los métodos get, set y toString funcionan correctamente.
 *
 */

public class ClienteTest {

    /**
     * Configura un cliente antes de cada test.
     */

    private Cliente cliente;

    @BeforeEach
    void prepararCliente(){
        cliente = new Cliente("Laura", "09034502V",
                "612345678", "laura@email.com");
    }

    /**
     * Verifica que getNombre() devuelve el nombre correcto.
     */

    @Test
    public void testGetNombre(){

        assertEquals("Laura", cliente.getNombre());

    }

    /**
     * Verifica que getDni() devuelve el DNI correcto.
     */



    @Test
    public void testGetDni(){

        assertEquals("09034502V", cliente.getDni());
    }

    /**
     * Verifica que getTelefono() devuelve el teléfono correcto.
     */

    @Test
    public void testGetTelefono(){

        assertEquals("612345678", cliente.getTelefono());
    }

    /**
     * Verifica que getEmail() devuelve el email correcto.
     */

    @Test
    public void testGetEmail(){

        assertEquals("laura@email.com", cliente.getEmail());
    }

    /**
     * Verifica que setNombre() cambia el nombre correctamente.
     */

    @Test
    public void testSetNombre(){
        cliente.setNombre("Carlos");
        assertEquals("Carlos", cliente.getNombre());

    }

    /**
     * Verifica que setDni() cambia el DNI correctamente.
     */

    @Test
    public void testSetDni(){
        cliente.setDni("34234212J");
        assertEquals("34234212J",cliente.getDni());

    }

    /**
     * Verifica que setTelefono cambia el teléfono correctamente.
     */

    @Test
    public void testSetTelefono(){
        cliente.setTelefono("912896966");
        assertEquals("912896966", cliente.getTelefono());

    }

    /**
     * Verifica que setEmail() cambia correctamente el email.
     */

    @Test
    public void testSetEmail(){
        cliente.setEmail("carlos@email.com");
        assertEquals("carlos@email.com", cliente.getEmail());
    }

    /**
     * Verifica que toString() devuelve el formato esperado.
     */

    @Test
    public void testToString() {
        String esperado = "Cliente{nombre='Laura', dni='09034502V', " +
                "telefono='612345678', email='laura@email.com'}";
        assertEquals(esperado, cliente.toString());
    }

}
