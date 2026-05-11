package model;

/**
 * Clase que representa un producto de cuidado personal.
 * Hereda de Producto e incluye tipo, uso y si es hipoalergenico.
 * 
 * @author ISC Israel de Jesus Mar Parada
 * @version 1.0
 * @see Producto
 */
public class CuidadoPersonal extends Producto {
    
    // ==================== ATRIBUTOS ====================
    
    /** Tipo de producto (Shampoo, Crema, Jabon, Desodorante). */
    private String tipoProducto;
    
    /** Uso especifico (Cabello, Piel, Corporal, Facial). */
    private String uso;
    
    /** Indica si es hipoalergenico. */
    private boolean hipoalergenico;
    
    /**
     * Constructor para crear un producto de cuidado personal.
     * 
     * @param codigo Codigo del producto
     * @param nombre Nombre del producto
     * @param precio Precio
     */
    public CuidadoPersonal(String codigo, String nombre, double precio) {
        super(codigo, nombre, precio);
        this.categoria = CategoriaProducto.CUIDADO_PERSONAL;
        this.tipoProducto = "";
        this.uso = "";
        this.hipoalergenico = false;
    }
    
    /**
     * Obtiene el tipo de producto.
     * 
     * @return "Cuidado Personal"
     */
    @Override
    public String getTipoProducto() {
        return "Cuidado Personal";
    }
    
    /**
     * Obtiene informacion adicional del producto.
     * 
     * @return Informacion de tipo, uso e hipoalergenico
     */
    @Override
    public String getInformacionAdicional() {
        String info = "Tipo: " + tipoProducto + " - Uso: " + uso;
        if (hipoalergenico) {
            info += " - HIPOALERGENICO";
        }
        return info;
    }
    
    // ==================== GETTERS ====================
    
    /** @return Tipo de producto */
    public String getTipoProductoPersonal() {
        return tipoProducto;
    }
    
    /** @param tipoProducto Nuevo tipo */
    public void setTipoProductoPersonal(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
    
    /** @return Uso del producto */
    public String getUso() {
        return uso;
    }
    
    /** @param uso Nuevo uso */
    public void setUso(String uso) {
        this.uso = uso;
    }
    
    /** @return true si es hipoalergenico */
    public boolean isHipoalergenico() {
        return hipoalergenico;
    }
    
    /** @param hipoalergenico Nueva condicion */
    public void setHipoalergenico(boolean hipoalergenico) {
        this.hipoalergenico = hipoalergenico;
    }
    
    /**
     * Devuelve una representacion textual del producto.
     * 
     * @return Cadena con informacion
     */
    @Override
    public String toString() {
        return super.toString() + " - " + tipoProducto + " - " + uso;
    }
    
}//fin de la clase