package service;

import model.*;
import java.util.List;
import java.util.Scanner;

/**
 * Clase de servicio que gestiona las operaciones generales de la farmacia.
 * 
 * @author ISC Israel de Jesus Mar Parada
 * @version 1.0
 */
public class FarmaciaService {
    
    private Inventario inventario;
    private List<Cliente> clientes;
    private List<Proveedor> proveedores;
    private List<RecetaMedica> recetas;
    private VentaService ventaService;
    
    public FarmaciaService(Inventario inventario, List<Cliente> clientes,
                           List<Proveedor> proveedores, List<RecetaMedica> recetas,
                           VentaService ventaService) {
        this.inventario = inventario;
        this.clientes = clientes;
        this.proveedores = proveedores;
        this.recetas = recetas;
        this.ventaService = ventaService;
    }
    
    public void registrarCliente(Scanner scanner) {
        System.out.println("\n=== REGISTRAR CLIENTE ===");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Documento: ");
        String documento = scanner.nextLine();
        System.out.print("Telefono: ");
        String telefono = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        
        Cliente cliente = new Cliente(nombre, documento, telefono, email);
        clientes.add(cliente);
        System.out.println("✅ Cliente registrado: " + cliente.getNombre());
    }
    
    public void registrarProveedor(Scanner scanner) {
        System.out.println("\n=== REGISTRAR PROVEEDOR ===");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Telefono: ");
        String telefono = scanner.nextLine();
        System.out.print("Direccion: ");
        String direccion = scanner.nextLine();
        
        Proveedor proveedor = new Proveedor(nombre, telefono, direccion);
        proveedores.add(proveedor);
        System.out.println("✅ Proveedor registrado: " + proveedor.getNombre());
    }
    
    public void registrarProducto(Scanner scanner) {
        System.out.println("\n=== REGISTRAR PRODUCTO ===");
        System.out.println("Tipo de producto:");
        System.out.println("1. Medicamento");
        System.out.println("2. Suplemento");
        System.out.println("3. Cuidado Personal");
        System.out.print("Seleccione: ");
        int tipo = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Codigo: ");
        String codigo = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Precio: ");
        double precio = Double.parseDouble(scanner.nextLine());
        
        Producto producto = null;
        
        switch (tipo) {
            case 1:
                Medicamento medicamento = new Medicamento(codigo, nombre, precio);
                System.out.print("Principio activo: ");
                medicamento.setPrincipioActivo(scanner.nextLine());
                System.out.print("Dosis: ");
                medicamento.setDosis(scanner.nextLine());
                System.out.print("Fecha vencimiento (YYYY-MM-DD): ");
                medicamento.setFechaVencimiento(java.time.LocalDate.parse(scanner.nextLine()));
                System.out.print("Requiere receta? (S/N): ");
                medicamento.setRequiereReceta(scanner.nextLine().equalsIgnoreCase("S"));
                producto = medicamento;
                break;
            case 2:
                Suplemento suplemento = new Suplemento(codigo, nombre, precio);
                System.out.print("Tipo de suplemento: ");
                suplemento.setTipoSuplemento(scanner.nextLine());
                System.out.print("Presentacion: ");
                suplemento.setPresentacion(scanner.nextLine());
                System.out.print("Sabor: ");
                suplemento.setSabor(scanner.nextLine());
                producto = suplemento;
                break;
            case 3:
                CuidadoPersonal cuidado = new CuidadoPersonal(codigo, nombre, precio);
                System.out.print("Tipo de producto: ");
                cuidado.setTipoProductoPersonal(scanner.nextLine());
                System.out.print("Uso: ");
                cuidado.setUso(scanner.nextLine());
                System.out.print("Hipoalergenico? (S/N): ");
                cuidado.setHipoalergenico(scanner.nextLine().equalsIgnoreCase("S"));
                producto = cuidado;
                break;
        }
        
        if (producto != null) {
            System.out.print("Stock inicial: ");
            producto.setStock(Integer.parseInt(scanner.nextLine()));
            System.out.print("Stock minimo: ");
            producto.setStockMinimo(Integer.parseInt(scanner.nextLine()));
            inventario.agregarProducto(producto);
        }
    }
    
    public void registrarReceta(Scanner scanner) {
        System.out.println("\n=== REGISTRAR RECETA MEDICA ===");
        System.out.print("Nombre del medico: ");
        String medico = scanner.nextLine();
        System.out.print("Nombre del paciente: ");
        String paciente = scanner.nextLine();
        
        RecetaMedica receta = new RecetaMedica(medico, paciente);
        
        System.out.print("Diagnostico: ");
        receta.setDiagnostico(scanner.nextLine());
        
        System.out.println("Agregar medicamentos recetados:");
        boolean agregando = true;
        while (agregando) {
            System.out.print("Codigo del medicamento (ENTER para terminar): ");
            String codigo = scanner.nextLine();
            if (codigo.isEmpty()) {
                agregando = false;
                continue;
            }
            Producto producto = inventario.buscarPorCodigo(codigo);
            if (producto instanceof Medicamento) {
                receta.agregarMedicamento((Medicamento) producto);
                System.out.println("Medicamento agregado a la receta");
            } else {
                System.out.println("Producto no encontrado o no es un medicamento");
            }
        }
        
        recetas.add(receta);
        System.out.println("✅ Receta registrada: " + receta);
    }
    
    public void listarClientes() {
        System.out.println("\n=== LISTA DE CLIENTES ===");
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados");
            return;
        }
        for (Cliente c : clientes) {
            System.out.println(c);
        }
    }
    
    public void listarProveedores() {
        System.out.println("\n=== LISTA DE PROVEEDORES ===");
        if (proveedores.isEmpty()) {
            System.out.println("No hay proveedores registrados");
            return;
        }
        for (Proveedor p : proveedores) {
            System.out.println(p);
        }
    }
    
    public void listarRecetas() {
        System.out.println("\n=== LISTA DE RECETAS ===");
        if (recetas.isEmpty()) {
            System.out.println("No hay recetas registradas");
            return;
        }
        for (RecetaMedica r : recetas) {
            System.out.println(r);
        }
    }
    
    public Cliente seleccionarCliente(Scanner scanner) {
        System.out.print("ID del cliente: ");
        int id = Integer.parseInt(scanner.nextLine());
        Cliente cliente = clientes.stream()
                .filter(c -> c.getIdCliente() == id)
                .findFirst().orElse(null);
        if (cliente == null) {
            System.out.println("Cliente no encontrado");
        }
        return cliente;
    }
    
    public Inventario getInventario() {
        return inventario;
    }
    
    public List<Cliente> getClientes() {
        return clientes;
    }
    
    public List<RecetaMedica> getRecetas() {
        return recetas;
    }
    
}//fin de la clase