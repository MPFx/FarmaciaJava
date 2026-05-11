package model;

/**
 * Clase que representa un suplemento alimenticio.
 * Hereda de Producto e incluye tipo de suplemento, presentacion y sabor.
 * 
 * @author ISC Israel de Jesus Mar Parada
 * @version 1.0
 * @see Producto
 */
public class Suplemento extends Producto {
    
    // ==================== ATRIBUTOS ====================
    
    /** Tipo de suplemento (Vitaminas, Proteinas, Minerales). */
    private String tipoSuplemento;
    
    /** Presentacion (Tabletas, Polvo, Liquido). */
    private String presentacion;
    
    /** Sabor (Fresa, Vainilla, Chocolate, Natural). */
    private String sabor;
    
    /**
     * Constructor para crear un suplemento.
     * 
     * @param codigo Codigo del producto
     * @param nombre Nombre del producto
     * @param precio Precio
     */
    public Suplemento(String codigo, String nombre, double precio) {
        super(codigo, nombre, precio);
        this.categoria = CategoriaProducto.SUPLEMENTO;
        this.tipoSuplemento = "";
        this.presentacion = "Tabletas";
        this.sabor = "Natural";
    }
    
    /**
     * Obtiene el tipo de producto.
     * 
     * @return "Suplemento"
     */
    @Override
    public String getTipoProducto() {
        return "Suplemento";
    }
    
    /**
     * Obtiene informacion adicional del suplemento.
     * 
     * @return Informacion de tipo, presentacion y sabor
     */
    @Override
    public String getInformacionAdicional() {
        return "Tipo: " + tipoSuplemento + " - Presentacion: " + presentacion + 
               " - Sabor: " + sabor;
    }
    
    // ==================== GETTERS ====================
    
    /** @return Tipo de suplemento */
    public String getTipoSuplemento() {
        return tipoSuplemento;
    }
    
    /** @param tipoSuplemento Nuevo tipo */
    public void setTipoSuplemento(String tipoSuplemento) {
        this.tipoSuplemento = tipoSuplemento;
    }
    
    /** @return Presentacion */
    public String getPresentacion() {
        return presentacion;
    }
    
    /** @param presentacion Nueva presentacion */
    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }
    
    /** @return Sabor */
    public String getSabor() {
        return sabor;
    }
    
    /** @param sabor Nuevo sabor */
    public void setSabor(String sabor) {
        this.sabor = sabor;
    }
    
    /**
     * Devuelve una representacion textual del suplemento.
     * 
     * @return Cadena con informacion
     */
    @Override
    public String toString() {
        return super.toString() + " - " + tipoSuplemento + " - " + presentacion;
    }
    
}//fin de la clase