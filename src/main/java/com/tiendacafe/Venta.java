package com.tiendacafe;

import java.util.ArrayList;

/**
 * Representa una venta de la tienda de café.
 *
 * Cada venta está asociada a un cliente, contiene una lista de cafés vendidos y una fecha.
 *
 * @author Cristian
 * @version 1.0
 */

public class Venta {

    //Atributos
    private Cliente cliente;
    private ArrayList<Cafe> lineasDeVenta;
    private String fecha;

    /**
     * Constructor para crear una lista de ventas.
     *
     * @param cliente Nombre del cliente obtenido por la clase Cliente.
     * @param lineasDeVenta Listado de ventas realizadas al cliente.
     * @param fecha Fecha de cada venta realizada.
     */

    //Constructor
    public Venta(Cliente cliente, ArrayList<Cafe> lineasDeVenta, String fecha){

        this.cliente = cliente;
        this.lineasDeVenta = lineasDeVenta;
        this.fecha = fecha;

    }

    //Getters

    /**
     * Devuelve el nombre del cliente.
     *
     * @return Nombre del cliente.
     */
    public Cliente getCliente() { return cliente;}

    /**
     * Devuelve la lista de cafés de la venta.
     * @return Lista de cafés.
     */

    public ArrayList<Cafe> getLineasDeVenta(){return lineasDeVenta;}

    /**
     * Devuelve la fecha de la venta.
     * @return Fecha de la venta.
     */

    public String getFecha(){ return fecha;}


    /**
     * Añade un café a la lista de cafés vendidos en esta venta.
     *
     * @param cafe El objeto Cafe que se va a añadir a la venta.
     */

    public void addCafe(Cafe cafe){

        this.lineasDeVenta.add(cafe);

    }

    /**
     * Calcula el importe total de la venta sumando los precios de todos los cafés vendidos.
     *
     * @return El importe total de la venta como un valor double.
     */


    public double calcularTotal() {
        double sumaTotal = 0;

        for (Cafe cafe : lineasDeVenta) {

            sumaTotal += cafe.getPrecio();
        }
        return sumaTotal;

    }

    /**
     * Devuelve una representación textual de la venta,
     * incluyendo cliente, fecha, cafés vendidos y total.
     *
     * @return Detalles de la venta en formato texto.
     */




    @Override
    public String toString(){
        StringBuilder cafesTexto = new StringBuilder();

        for (Cafe cafe: lineasDeVenta){
            cafesTexto.append(" - ").append(cafe.getNombre()).append(" - ").append(cafe.getPrecio()).append(" €\n");
        }
        return "Venta realizada a: " + cliente.getNombre() + "\n"
                + "Fecha: " + fecha + "\n"
                + "Cafés vendidos:\n" + cafesTexto
                + "Total: " + calcularTotal() + " €";

    }
}
