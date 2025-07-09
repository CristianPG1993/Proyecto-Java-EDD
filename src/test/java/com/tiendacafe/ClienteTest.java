package com.tiendacafe;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de prueba unitaria para la clase {@link Cliente}
 * Verifica que los métodos get, set y toString funcionan correctamente.
 *
 */

public class ClienteTest {

    private Cliente cliente;

    @BeforeEach
    void prepararCliente(){
        cliente = new Cliente("Laura", "09034502V",
                "612345678", "laura@email.com");
    }

    @Test
    public void testGetNombre(){

        assertEquals("Laura", cliente.getNombre());

    }

    @Test
    public void testGetDni(){

        assertEquals("09034502V", cliente.getDni());
    }

    @Test
    public void testGetTelefono(){

        assertEquals("612345678", cliente.getTelefono());
    }

    @Test
    public void testGetEmail(){

        assertEquals("laura@email.com", cliente.getEmail());
    }
}
