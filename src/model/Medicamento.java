package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Clase que representa un medicamento.
 * Hereda de Producto e incluye principio activo, dosis, si requiere receta y fecha de vencimiento.
 * 
 * @author ISC Israel de Jesus Mar Parada
 * @version 1.0
 * @see Producto
 */
public class Medicamento extends Producto {
    
    // ==================== ATRIBUTOS ====================
    
    /** Principio activo del medicamento. */
    private String principioActivo;
    
    /** Dosis recomendada. */
    private String dosis;
    
    /** Indica si requiere receta medica. */
    private boolean requiereReceta;
    
    /** Fecha de vencimiento. */
    private LocalDate fechaVencimiento;
    
    /**
     * Constructor para crear un medicamento.
     * 
     * @param codigo Codigo del producto
     * @param nombre Nombre del producto
     * @param precio Precio
     */
    public Medicamento(String codigo, String nombre, double precio) {
        super(codigo, nombre, precio);
        this.categoria = CategoriaProducto.MEDICAMENTO;
        this.principioActivo = "";
        this.dosis = "";
        this.requiereReceta = false;
        this.fechaVencimiento = LocalDate.now().plusYears(2);
    }
    
    /**
     * Obtiene el tipo de producto.
     * 
     * @return "Medicamento"
     */
    @Override
    public String getTipoProducto() {
        return "Medicamento";
    }
    
    /**
     * Obtiene informacion adicional del medicamento.
     * 
     * @return Informacion de principio activo, dosis y receta
     */
    @Override
    public String getInformacionAdicional() {
        String info = "Principio activo: " + principioActivo + " - Dosis: " + dosis;
        if (requiereReceta) {
            info += " - REQUIERE RECETA";
        }
        if (estaVencido()) {
            info += " - ⚠️ VENCIDO";
        }
        return info;
    }
    
    /**
     * Verifica si el medicamento esta vencido.
     * 
     * @return true si la fecha actual es posterior a la de vencimiento
     */
    public boolean estaVencido() {
        return LocalDate.now().isAfter(fechaVencimiento);
    }
    
    // ==================== GETTERS ====================
    
    /** @return Principio activo */
    public String getPrincipioActivo() {
        return principioActivo;
    }
    
    /** @param principioActivo Nuevo principio activo */
    public void setPrincipioActivo(String principioActivo) {
        this.principioActivo = principioActivo;
    }
    
    /** @return Dosis */
    public String getDosis() {
        return dosis;
    }
    
    /** @param dosis Nueva dosis */
    public void setDosis(String dosis) {
        this.dosis = dosis;
    }
    
    /** @return true si requiere receta */
    public boolean isRequiereReceta() {
        return requiereReceta;
    }
    
    /** @param requiereReceta Nueva condicion */
    public void setRequiereReceta(boolean requiereReceta) {
        this.requiereReceta = requiereReceta;
    }
    
    /** @return Fecha de vencimiento */
    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }
    
    /** @param fechaVencimiento Nueva fecha */
    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
    
    /**
     * Devuelve una representacion textual del medicamento.
     * 
     * @return Cadena con informacion
     */
    @Override
    public String toString() {
        String vencido = estaVencido() ? " [VENCIDO]" : "";
        return super.toString() + " - " + principioActivo + vencido;
    }
    
}//fin de la clase