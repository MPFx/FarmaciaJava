package ui;

import service.*;
import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase que implementa la interfaz de usuario por consola para la Farmacia.
 * 
 * @author ISC Israel de Jesus Mar Parada
 * @version 1.0
 */
public class MenuConsola {
    
    private Scanner scanner;
    private Inventario inventario;
    private List<Cliente> clientes;
    private List<Proveedor> proveedores;
    private List<RecetaMedica> recetas;
    private List<Venta> ventas;
    private FarmaciaService farmaciaService;
    private VentaService ventaService;
    private Cliente clienteActual;
    
    public MenuConsola() {
        this.scanner = new Scanner(System.in);
        this.inventario = new Inventario();
        this.clientes = new ArrayList<>();
        this.proveedores = new ArrayList<>();
        this.recetas = new ArrayList<>();
        this.ventas = new ArrayList<>();
        this.ventaService = new VentaService(ventas);
        this.farmaciaService = new FarmaciaService(inventario, clientes, proveedores, recetas, ventaService);
        this.clienteActual = null;
        cargarDatosPrueba();
    }
    
    private void cargarDatosPrueba() {
        // Medicamentos
        Medicamento acetaminofen = new Medicamento("MED001", "Acetaminofen 500mg", 15000);
        acetaminofen.setPrincipioActivo("Acetaminofen");
        acetaminofen.setDosis("1 tableta cada 6 horas");
        acetaminofen.setRequiereReceta(false);
        acetaminofen.setStock(100);
        inventario.agregarProducto(acetaminofen);
        
        // Suplementos
        Suplemento vitaminaC = new Suplemento("SUP001", "Vitamina C 1000mg", 25000);
        vitaminaC.setTipoSuplemento("Vitaminas");
        vitaminaC.setPresentacion("Tabletas");
        vitaminaC.setSabor("Naranja");
        vitaminaC.setStock(50);
        inventario.agregarProducto(vitaminaC);
        
        // Cuidado Personal
        CuidadoPersonal shampoo = new CuidadoPersonal("CUI001", "Shampoo Anticaspa", 20000);
        shampoo.setTipoProductoPersonal("Shampoo");
        shampoo.setUso("Cabello");
        shampoo.setHipoalergenico(false);
        shampoo.setStock(30);
        inventario.agregarProducto(shampoo);
        
        // Clientes
        clientes.add(new Cliente("Juan Perez", "12345678", "555-1234", "juan@email.com"));
        clientes.add(new Cliente("Maria Gomez", "87654321", "555-5678", "maria@email.com"));
        
        // Proveedores
        proveedores.add(new Proveedor("Lab Farmaceutico SA", "555-9012", "Calle 123"));
    }
    
    public void iniciar() {
        boolean salir = false;
        
        while (!salir) {
            mostrarMenuPrincipal();
            int opcion = leerOpcion();
            
            switch (opcion) {
                case 1 -> farmaciaService.registrarCliente(scanner);
                case 2 -> farmaciaService.registrarProveedor(scanner);
                case 3 -> farmaciaService.registrarProducto(scanner);
                case 4 -> farmaciaService.registrarReceta(scanner);
                case 5 -> inventario.mostrarInventario();
                case 6 -> farmaciaService.listarClientes();
                case 7 -> farmaciaService.listarProveedores();
                case 8 -> farmaciaService.listarRecetas();
                case 9 -> clienteActual = farmaciaService.seleccionarCliente(scanner);
                case 10 -> ventaService.realizarVenta(scanner, inventario, clienteActual, recetas);
                case 11 -> ventaService.listarVentas();
                case 12 -> ventaService.mostrarVentasPorCliente(clienteActual);
                case 13 -> {
                    System.out.println("\n¡Gracias por usar el Sistema de Farmacia!");
                    System.out.println("¡Hasta pronto!");
                    salir = true;
                }
                default -> System.out.println("Opcion no valida");
            }
            
            if (!salir) pausa();
        }
        scanner.close();
    }
    
    private void mostrarMenuPrincipal() {
        System.out.println("\n========================================");
        System.out.println("        SISTEMA DE FARMACIA");
        System.out.println("========================================");
        System.out.println("1. Registrar cliente");
        System.out.println("2. Registrar proveedor");
        System.out.println("3. Registrar producto");
        System.out.println("4. Registrar receta medica");
        System.out.println("5. Ver inventario");
        System.out.println("6. Listar clientes");
        System.out.println("7. Listar proveedores");
        System.out.println("8. Listar recetas");
        System.out.println("9. Seleccionar cliente");
        System.out.println("10. Realizar venta");
        System.out.println("11. Ver ventas");
        System.out.println("12. Ver ventas por cliente");
        System.out.println("13. Salir");
        System.out.println("========================================");
        
        if (clienteActual != null) {
            System.out.println("Cliente actual: " + clienteActual.getNombre());
        } else {
            System.out.println("Cliente actual: NINGUNO");
        }
        System.out.println("========================================");
        System.out.print("Seleccione una opcion: ");
    }
    
    private int leerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
    
    private void pausa() {
        System.out.println("\nPresione Enter para continuar...");
        scanner.nextLine();
    }
    
}//fin de la clase