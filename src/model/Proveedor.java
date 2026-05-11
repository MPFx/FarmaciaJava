package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un proveedor de la farmacia.
 * 
 * @author ISC Israel de Jesus Mar Parada
 * @version 1.0
 * @see Producto
 */
public class Proveedor {
    
    // ==================== ATRIBUTOS ====================
    
    /** Identificador unico del proveedor. */
    private int idProveedor;
    
    /** Nombre del proveedor. */
    private String nombre;
    
    /** Telefono de contacto. */
    private String telefono;
    
    /** Direccion del proveedor. */
    private String direccion;
    
    /** Lista de productos que suministra. */
    private List<Producto> productos;
    
    /** Contador estatico para generar IDs. */
    private static int contadorIds = 1;
    
    /**
     * Constructor para crear un proveedor.
     * 
     * @param nombre Nombre
     * @param telefono Telefono
     * @param direccion Direccion
     */
    public Proveedor(String nombre, String telefono, String direccion) {
        this.idProveedor = contadorIds++;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.productos = new ArrayList<>();
    }
    
    /**
     * Agrega un producto al proveedor.
     * 
     * @param producto Producto a agregar
     */
    public void agregarProducto(Producto producto) {
        if (!productos.contains(producto)) {
            productos.add(producto);
        }
    }
    
    // ==================== GETTERS ====================
    
    /** @return Identificador */
    public int getIdProveedor() {
        return idProveedor;
    }
    
    /** @return Nombre */
    public String getNombre() {
        return nombre;
    }
    
    /** @param nombre Nuevo nombre */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /** @return Telefono */
    public String getTelefono() {
        return telefono;
    }
    
    /** @param telefono Nuevo telefono */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    /** @return Direccion */
    public String getDireccion() {
        return direccion;
    }
    
    /** @param direccion Nueva direccion */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    /** @return Lista de productos */
    public List<Producto> getProductos() {
        return productos;
    }
    
    /**
     * Devuelve una representacion textual del proveedor.
     * 
     * @return Cadena con informacion
     */
    @Override
    public String toString() {
        return "[" + idProveedor + "] " + nombre + " - " + telefono + " - " + direccion;
    }
    
}//fin de la clase