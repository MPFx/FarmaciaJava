package model;

/**
 * Clase abstracta que representa un producto de la farmacia.
 * Contiene los atributos y comportamientos comunes a medicamentos,
 * suplementos y productos de cuidado personal.
 * 
 * @author ISC Israel de Jesus Mar Parada
 * @version 1.0
 * @see Medicamento
 * @see Suplemento
 * @see CuidadoPersonal
 * @see CategoriaProducto
 */
public abstract class Producto {
    
    // ==================== ATRIBUTOS ====================
    
    /** Identificador unico del producto. */
    protected int idProducto;
    
    /** Codigo de barras o referencia del producto. */
    protected String codigo;
    
    /** Nombre del producto. */
    protected String nombre;
    
    /** Precio del producto. */
    protected double precio;
    
    /** Cantidad en stock. */
    protected int stock;
    
    /** Stock minimo para generar alerta. */
    protected int stockMinimo;
    
    /** Categoria del producto. */
    protected CategoriaProducto categoria;
    
    /** Contador estatico para generar IDs. */
    private static int contadorIds = 1;
    
    /**
     * Constructor para crear un producto.
     * 
     * @param codigo Codigo del producto
     * @param nombre Nombre del producto
     * @param precio Precio del producto
     */
    public Producto(String codigo, String nombre, double precio) {
        this.idProducto = contadorIds++;
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = 0;
        this.stockMinimo = 5;
    }
    
    /**
     * Reduce el stock del producto.
     * 
     * @param cantidad Cantidad a reducir
     * @return true si se pudo reducir
     */
    public boolean reducirStock(int cantidad) {
        if (stock >= cantidad) {
            stock -= cantidad;
            return true;
        }
        return false;
    }
    
    /**
     * Verifica si el producto tiene stock bajo.
     * 
     * @return true si el stock es menor al minimo
     */
    public boolean isBajoStock() {
        return stock <= stockMinimo;
    }
    
    /**
     * Obtiene el tipo de producto.
     * Metodo abstracto implementado por las subclases.
     * 
     * @return Tipo de producto
     */
    public abstract String getTipoProducto();
    
    /**
     * Obtiene informacion adicional del producto.
     * Metodo abstracto implementado por las subclases.
     * 
     * @return Informacion adicional
     */
    public abstract String getInformacionAdicional();
    
    // ==================== GETTERS ====================
    
    /** @return Identificador */
    public int getIdProducto() {
        return idProducto;
    }
    
    /** @return Codigo */
    public String getCodigo() {
        return codigo;
    }
    
    /** @param codigo Nuevo codigo */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    /** @return Nombre */
    public String getNombre() {
        return nombre;
    }
    
    /** @param nombre Nuevo nombre */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /** @return Precio */
    public double getPrecio() {
        return precio;
    }
    
    /** @param precio Nuevo precio */
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    /** @return Stock actual */
    public int getStock() {
        return stock;
    }
    
    /** @param stock Nuevo stock */
    public void setStock(int stock) {
        this.stock = stock;
    }
    
    /** @return Stock minimo */
    public int getStockMinimo() {
        return stockMinimo;
    }
    
    /** @param stockMinimo Nuevo stock minimo */
    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }
    
    /** @return Categoria */
    public CategoriaProducto getCategoria() {
        return categoria;
    }
    
    /** @param categoria Nueva categoria */
    public void setCategoria(CategoriaProducto categoria) {
        this.categoria = categoria;
    }
    
    /**
     * Devuelve una representacion textual del producto.
     * 
     * @return Cadena con informacion
     */
    @Override
    public String toString() {
        return "[" + idProducto + "] " + codigo + " - " + nombre + 
               " - $" + precio + " - Stock: " + stock +
               (isBajoStock() ? " ⚠️ STOCK BAJO" : "");
    }
    
}//fin de la clase