package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Clase que representa el inventario de la farmacia.
 * Gestiona los productos, stock y busquedas.
 * 
 * @author ISC Israel de Jesus Mar Parada
 * @version 1.0
 * @see Producto
 */
public class Inventario {
    
    // ==================== ATRIBUTOS ====================
    
    /** Lista de productos. */
    private List<Producto> productos;
    
    /**
     * Constructor del inventario.
     */
    public Inventario() {
        this.productos = new ArrayList<>();
    }
    
    /**
     * Agrega un producto al inventario.
     * 
     * @param producto Producto a agregar
     */
    public void agregarProducto(Producto producto) {
        productos.add(producto);
        System.out.println("Producto agregado: " + producto.getNombre());
    }
    
    /**
     * Elimina un producto por ID.
     * 
     * @param idProducto ID del producto
     * @return true si fue eliminado
     */
    public boolean eliminarProducto(int idProducto) {
        boolean eliminado = productos.removeIf(p -> p.getIdProducto() == idProducto);
        if (eliminado) {
            System.out.println("Producto eliminado del inventario");
        }
        return eliminado;
    }
    
    /**
     * Busca un producto por ID.
     * 
     * @param idProducto ID del producto
     * @return Producto encontrado o null
     */
    public Producto buscarProducto(int idProducto) {
        return productos.stream()
                .filter(p -> p.getIdProducto() == idProducto)
                .findFirst()
                .orElse(null);
    }
    
    /**
     * Busca un producto por codigo.
     * 
     * @param codigo Codigo del producto
     * @return Producto encontrado o null
     */
    public Producto buscarPorCodigo(String codigo) {
        return productos.stream()
                .filter(p -> p.getCodigo().equalsIgnoreCase(codigo))
                .findFirst()
                .orElse(null);
    }
    
    /**
     * Busca productos por nombre (coincidencia parcial).
     * 
     * @param nombre Nombre a buscar
     * @return Lista de productos
     */
    public List<Producto> buscarPorNombre(String nombre) {
        return productos.stream()
                .filter(p -> p.getNombre().toLowerCase().contains(nombre.toLowerCase()))
                .collect(Collectors.toList());
    }
    
    /**
     * Busca productos por categoria.
     * 
     * @param categoria Categoria
     * @return Lista de productos
     */
    public List<Producto> buscarPorCategoria(CategoriaProducto categoria) {
        return productos.stream()
                .filter(p -> p.getCategoria() == categoria)
                .collect(Collectors.toList());
    }
    
    /**
     * Lista productos con stock bajo.
     * 
     * @return Lista de productos con stock bajo
     */
    public List<Producto> listarBajoStock() {
        return productos.stream()
                .filter(Producto::isBajoStock)
                .collect(Collectors.toList());
    }
    
    /**
     * Lista productos disponibles (stock > 0).
     * 
     * @return Lista de productos con stock
     */
    public List<Producto> listarDisponibles() {
        return productos.stream()
                .filter(p -> p.getStock() > 0)
                .collect(Collectors.toList());
    }
    
    /**
     * Obtiene todos los productos.
     * 
     * @return Lista completa
     */
    public List<Producto> getTodosLosProductos() {
        return new ArrayList<>(productos);
    }
    
    /**
     * Muestra el inventario completo.
     */
    public void mostrarInventario() {
        System.out.println("\n=== INVENTARIO ===");
        if (productos.isEmpty()) {
            System.out.println("El inventario esta vacio");
            return;
        }
        
        for (Producto p : productos) {
            System.out.println(p);
            System.out.println("   " + p.getInformacionAdicional());
        }
        
        List<Producto> bajoStock = listarBajoStock();
        if (!bajoStock.isEmpty()) {
            System.out.println("\n⚠️ PRODUCTOS CON STOCK BAJO:");
            for (Producto p : bajoStock) {
                System.out.println("   " + p.getNombre() + " - Stock: " + p.getStock());
            }
        }
    }
    
}//fin de la clase