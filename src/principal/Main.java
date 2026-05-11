package principal;

import ui.MenuConsola;

/**
 * Clase principal del Sistema de Farmacia.
 * 
 * @author ISC Israel de Jesus Mar Parada
 * @version 1.0
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("   BIENVENIDO AL SISTEMA DE");
        System.out.println("          FARMACIA");
        System.out.println("========================================");
        System.out.println("Gestiona clientes, proveedores, productos,");
        System.out.println("recetas medicas, inventario y ventas.");
        System.out.println("========================================\n");
        
        MenuConsola menu = new MenuConsola();
        menu.iniciar();
    }
    
}//fin de la clase