package com.tiendacafe;


/**
 * Representa un cliente de la tienda de café.
 * Contiene información personal como nombre, DNI, teléfono y correo electrónico.
 *
 * @author Cristian
 * @version 1.0
 */
public class Cliente {

    // Atributos
    private String nombre;
    private String dni;
    private String telefono;
    private String email;

    /**
     * Constructor para crear un cliente con todos sus datos.
     *
     * @param nombreCliente Nombre del cliente
     * @param dniCliente DNI del cliente
     * @param telefonoCliente Teléfono del cliente
     * @param emailCliente Correo electrónico del cliente
     */
    public Cliente(String nombreCliente, String dniCliente, String telefonoCliente, String emailCliente){
        this.nombre = nombreCliente;
        this.dni = dniCliente;
        this.telefono = telefonoCliente;
        this.email = emailCliente;
    }

    // Getters

    /**
     * Devuelve el nombre del cliente.
     * @return Nombre del cliente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve el DNI del cliente.
     *
     * @return DNI del cliente
     */
    public String getDni() {
        return dni;
    }

    /**
     * Devuelve el teléfono del cliente.
     * @return Teléfono del cliente
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Devuelve el correo electrónico del cliente.
     * @return Email del cliente
     */
    public String getEmail() {
        return email;
    }

    // Setters

    /**
     * Establece un nuevo nombre para el cliente.
     * @param nombre Nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece un nuevo DNI para el cliente.
     * @param dni Nuevo DNI
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Establece un nuevo teléfono para el cliente.
     * @param telefono Nuevo teléfono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Establece un nuevo correo electrónico para el cliente.
     * @param email Nuevo correo electrónico
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Devuelve una representación en texto del cliente.
     * @return Cadena con los datos del cliente
     */
    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
