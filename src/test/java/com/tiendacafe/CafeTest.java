package com.tiendacafe;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de prueba unitaria para la clase {@link Cafe}.
 * Verifica que los métodos get, set y toString funcionan correctamente.
 *
 * @author Cristian
 * @version 1.0
 */


public class CafeTest {


    /**
     * Se genera un elemento cafe con parámetros de la clase Cafe.java.
     *
     */

    private Cafe cafe;

    @BeforeEach
    void pruebaCafe(){
        cafe = new Cafe("Café Don Pedro",
                "Caturra", "Guatemala",10.50, 3);

    }

    /**
     * Verifica que getNombre() devuelve el nombre correcto.
     */

    @Test
    public void testGetNombre(){

        assertEquals("Café Don Pedro", cafe.getNombre());

    }

    /**
     * Verifica que getVariedad() devuelve la variedad correcta.
     */

    @Test
    public void testGetVariedad(){

        assertEquals("Caturra", cafe.getVariedad());

    }

    /**
     * Verifica que getOrigen() devuelve el origen correcto.
     */

    @Test
    public void testGetOrigen(){

        assertEquals("Guatemala", cafe.getOrigen());

    }

    /**
     * Verifica que getPrecio() devuelve el precio correcto.
     */

    @Test
    public void testGetPrecio(){

        assertEquals(10.50, cafe.getPrecio());

    }

    @Test
    public void testGetStock(){

        assertEquals(3, cafe.getStock());
    }

    /**
     * Verifica que setPrecio() funciona correctamente y actualiza el precio.
     */

    @Test
    public void testSetPrecio(){

        cafe.setPrecio(8.50);

        assertEquals(8.50, cafe.getPrecio());

    }

    @Test
    public void testSetStock(){
        cafe.setStock(6);

        assertEquals(6, cafe.getStock());
    }

    /**
     * Verifica que toString() se devuelve correctamente.
     */

    @Test
    public void testToString(){

        String resultado = cafe.toString();

        assertTrue(resultado.contains("Caturra"));
        assertTrue(resultado.contains("Guatemala"));

    }




}