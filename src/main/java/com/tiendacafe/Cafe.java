package com.tiendacafe;

/**
 * Representa un tipo de café de la tienda.
 * Contiene información de cada café(nombre, variedad, origen, precio).
 *
 * @author Cristian
 * @version 1.0
 */

public class Cafe {

    //Atributos
    private String nombre;
    private String variedad;
    private String origen;
    private double precio;
    private int stock;

    //Constructor

    /**
     * Constructor para crear un café con todos sus datos.
     *
     * @param nombreCafe Nombre del café
     * @param variedadCafe Variedad de café
     * @param origenCafe País de origen del café
     * @param precioCafe Precio bolsa 250 grs de café
     */

    public Cafe(String nombreCafe, String variedadCafe, String origenCafe, double precioCafe, int stock){

        this.nombre = nombreCafe;
        this.variedad = variedadCafe;
        this.origen = origenCafe;
        this.precio = precioCafe;
        this.stock = stock;

    }

    //Getters

    /**
     * Devuelve el nombre del café
     * @return Nombre del café
     */

    public String getNombre() { return nombre;}

    /**
     * Devuelve la variedad de café
     * @return Variedad de café
     */

    public String getVariedad() { return variedad;}

    /**
     * Devuelve el país de origen del café
     * @return País de origen del café
     */

    public String getOrigen() {return origen;}

    /**
     * Devuelve el precio de 250 grs de café
     * @return Precio bolsa 250 grs de café
     */

    public double getPrecio() {return precio;}

    /**
     * Devuelve el stock de café disponible
     * @return Unidades de bolsas de café
     */
    public int getStock() {
        return stock;
    }

    //Setters

    /**
     * Establece un nuevo precio para el café
     * @param precioNuevo Nuevo precio
     */

    public void setPrecio(double precioNuevo) {
        this.precio = precioNuevo;
    }

    /**
     * Establece un nuevo valor al stock del café
     * @param stock Nuevo stock
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Devuelve una representación en forma de cadena del objeto Cafe.
     * Incluye el nombre, la variedad, el origen y el precio del café.
     *
     * @return Cadena con la información completa del café.
     */


    @Override
    public String toString(){
        return "Cafe{" +
                "nombre='" + nombre + '\'' +
                ", variedad='" + variedad + '\'' +
                ", origen='" + origen + '\'' +
                ", precio='" + precio + '\'' +
                ", stock=" + stock +
                '}';
    }
}
