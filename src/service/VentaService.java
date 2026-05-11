package service;

import model.*;
import java.util.List;
import java.util.Scanner;

/**
 * Clase de servicio que gestiona las ventas de la farmacia.
 * 
 * @author ISC Israel de Jesus Mar Parada
 * @version 1.0
 */
public class VentaService {
    
    private List<Venta> ventas;
    
    public VentaService(List<Venta> ventas) {
        this.ventas = ventas;
    }
    
    public void realizarVenta(Scanner scanner, Inventario inventario, Cliente cliente,
                              List<RecetaMedica> recetas) {
        if (cliente == null) {
            System.out.println("Primero debe seleccionar un cliente");
            return;
        }
        
        System.out.println("\n=== REALIZAR VENTA ===");
        Venta venta = new Venta(cliente);
        
        boolean agregando = true;
        while (agregando) {
            System.out.println("\n--- PRODUCTOS DISPONIBLES ---");
            for (Producto p : inventario.listarDisponibles()) {
                System.out.println(p.getIdProducto() + ". " + p.getNombre() + 
                                 " - $" + p.getPrecio() + " - Stock: " + p.getStock());
            }
            
            System.out.print("\nID del producto (0 para terminar): ");
            int id = Integer.parseInt(scanner.nextLine());
            if (id == 0) {
                agregando = false;
                continue;
            }
            
            Producto producto = inventario.buscarProducto(id);
            if (producto == null) {
                System.out.println("Producto no encontrado");
                continue;
            }
            
            // Verificar si es medicamento y requiere receta
            if (producto instanceof Medicamento && ((Medicamento) producto).isRequiereReceta()) {
                System.out.print("ID de la receta medica: ");
                int idReceta = Integer.parseInt(scanner.nextLine());
                RecetaMedica receta = recetas.stream()
                        .filter(r -> r.getIdReceta() == idReceta)
                        .findFirst().orElse(null);
                if (receta == null) {
                    System.out.println("Receta no encontrada. Venta de medicamento requiere receta");
                    continue;
                }
            }
            
            System.out.print("Cantidad: ");
            int cantidad = Integer.parseInt(scanner.nextLine());
            
            if (venta.agregarProducto(producto, cantidad)) {
                System.out.println("Producto agregado!");
            }
        }
        
        if (venta.getProductos().isEmpty()) {
            System.out.println("Venta cancelada");
            return;
        }
        
        System.out.println("\n=== RESUMEN DE VENTA ===");
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Subtotal: $" + venta.getSubtotal());
        System.out.println("Total: $" + venta.getTotal());
        
        System.out.print("\nConfirmar venta? (S/N): ");
        if (scanner.nextLine().equalsIgnoreCase("S")) {
            ventas.add(venta);
            System.out.println("✅ Venta realizada exitosamente!");
            System.out.println(venta);
        } else {
            System.out.println("Venta cancelada");
            // Revertir stock
            for (Producto p : venta.getProductos()) {
                p.setStock(p.getStock() + 1);
            }
        }
    }
    
    public void listarVentas() {
        System.out.println("\n=== LISTA DE VENTAS ===");
        if (ventas.isEmpty()) {
            System.out.println("No hay ventas registradas");
            return;
        }
        for (Venta v : ventas) {
            System.out.println(v);
            System.out.println("  Productos: " + v.getProductos().size());
            for (Producto p : v.getProductos()) {
                System.out.println("    - " + p.getNombre());
            }
        }
    }
    
    public void mostrarVentasPorCliente(Cliente cliente) {
        if (cliente == null) {
            System.out.println("No hay cliente seleccionado");
            return;
        }
        
        System.out.println("\n=== VENTAS DE " + cliente.getNombre().toUpperCase() + " ===");
        List<Venta> ventasCliente = ventas.stream()
                .filter(v -> v.getCliente().getIdCliente() == cliente.getIdCliente())
                .toList();
        
        if (ventasCliente.isEmpty()) {
            System.out.println("No hay ventas para este cliente");
            return;
        }
        
        double totalGastado = 0;
        for (Venta v : ventasCliente) {
            System.out.println(v);
            totalGastado += v.getTotal();
        }
        System.out.println("\nTotal gastado: $" + totalGastado);
    }
    
}//fin de la clase