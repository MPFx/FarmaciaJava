package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Clase que representa una venta en la farmacia.
 * 
 * @author ISC Israel de Jesus Mar Parada
 * @version 1.0
 * @see Cliente
 * @see Producto
 */
public class Venta {
    
    // ==================== ATRIBUTOS ====================
    
    /** Identificador unico de la venta. */
    private int idVenta;
    
    /** Cliente que realiza la compra. */
    private Cliente cliente;
    
    /** Lista de productos comprados. */
    private List<Producto> productos;
    
    /** Mapa de cantidades por producto. */
    private Map<Integer, Integer> cantidades;
    
    /** Fecha de la venta. */
    private LocalDateTime fecha;
    
    /** Subtotal (sin descuento). */
    private double subtotal;
    
    /** Total a pagar. */
    private double total;
    
    /** Contador estatico para generar IDs. */
    private static int contadorIds = 1;
    
    /**
     * Constructor para crear una venta.
     * 
     * @param cliente Cliente
     */
    public Venta(Cliente cliente) {
        this.idVenta = contadorIds++;
        this.cliente = cliente;
        this.productos = new ArrayList<>();
        this.cantidades = new HashMap<>();
        this.fecha = LocalDateTime.now();
        this.subtotal = 0;
        this.total = 0;
    }
    
    /**
     * Agrega un producto a la venta.
     * 
     * @param producto Producto
     * @param cantidad Cantidad
     * @return true si se pudo agregar
     */
    public boolean agregarProducto(Producto producto, int cantidad) {
        if (producto.getStock() >= cantidad) {
            productos.add(producto);
            cantidades.put(producto.getIdProducto(), cantidad);
            producto.reducirStock(cantidad);
            calcularTotal();
            return true;
        }
        System.out.println("Stock insuficiente para " + producto.getNombre() +
                           " (Disponible: " + producto.getStock() + ")");
        return false;
    }
    
    /**
     * Calcula el subtotal y total.
     */
    private void calcularTotal() {
        subtotal = 0;
        for (Producto p : productos) {
            int cantidad = cantidades.getOrDefault(p.getIdProducto(), 1);
            subtotal += p.getPrecio() * cantidad;
        }
        total = subtotal;
    }
    
    // ==================== GETTERS ====================
    
    /** @return Identificador */
    public int getIdVenta() {
        return idVenta;
    }
    
    /** @return Cliente */
    public Cliente getCliente() {
        return cliente;
    }
    
    /** @return Lista de productos */
    public List<Producto> getProductos() {
        return productos;
    }
    
    /** @return Fecha */
    public LocalDateTime getFecha() {
        return fecha;
    }
    
    /** @return Subtotal */
    public double getSubtotal() {
        return subtotal;
    }
    
    /** @return Total */
    public double getTotal() {
        return total;
    }
    
    /**
     * Devuelve una representacion textual de la venta.
     * 
     * @return Cadena con informacion
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return "Venta #" + idVenta + " - " + cliente.getNombre() +
               " - Subtotal: $" + subtotal + " - Total: $" + total +
               " - " + fecha.format(formatter);
    }
    
}//fin de la clase