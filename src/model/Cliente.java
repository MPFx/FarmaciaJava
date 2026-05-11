package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Clase que representa un cliente de la farmacia.
 * 
 * @author ISC Israel de Jesus Mar Parada
 * @version 1.0
 * @see Venta
 */
public class Cliente {
    
    // ==================== ATRIBUTOS ====================
    
    /** Identificador unico del cliente. */
    private int idCliente;
    
    /** Nombre completo. */
    private String nombre;
    
    /** Documento de identidad. */
    private String documento;
    
    /** Telefono de contacto. */
    private String telefono;
    
    /** Email de contacto. */
    private String email;
    
    /** Fecha de registro. */
    private LocalDate fechaRegistro;
    
    /** Contador estatico para generar IDs. */
    private static int contadorIds = 1;
    
    /**
     * Constructor para crear un cliente.
     * 
     * @param nombre Nombre
     * @param documento Documento
     * @param telefono Telefono
     * @param email Email
     */
    public Cliente(String nombre, String documento, String telefono, String email) {
        this.idCliente = contadorIds++;
        this.nombre = nombre;
        this.documento = documento;
        this.telefono = telefono;
        this.email = email;
        this.fechaRegistro = LocalDate.now();
    }
    
    // ==================== GETTERS ====================
    
    /** @return Identificador */
    public int getIdCliente() {
        return idCliente;
    }
    
    /** @return Nombre */
    public String getNombre() {
        return nombre;
    }
    
    /** @param nombre Nuevo nombre */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /** @return Documento */
    public String getDocumento() {
        return documento;
    }
    
    /** @param documento Nuevo documento */
    public void setDocumento(String documento) {
        this.documento = documento;
    }
    
    /** @return Telefono */
    public String getTelefono() {
        return telefono;
    }
    
    /** @param telefono Nuevo telefono */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    /** @return Email */
    public String getEmail() {
        return email;
    }
    
    /** @param email Nuevo email */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /** @return Fecha de registro */
    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }
    
    /**
     * Devuelve una representacion textual del cliente.
     * 
     * @return Cadena con informacion
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "[" + idCliente + "] " + nombre + " - " + documento + " - " + telefono +
               " - Registrado: " + fechaRegistro.format(formatter);
    }
    
}//fin de la clase