package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa una receta medica.
 * Contiene informacion del medico, paciente, diagnostico y medicamentos recetados.
 * 
 * @author ISC Israel de Jesus Mar Parada
 * @version 1.0
 * @see Medicamento
 */
public class RecetaMedica {
    
    // ==================== ATRIBUTOS ====================
    
    /** Identificador unico de la receta. */
    private int idReceta;
    
    /** Nombre del medico. */
    private String medico;
    
    /** Nombre del paciente. */
    private String paciente;
    
    /** Fecha de la receta. */
    private LocalDate fecha;
    
    /** Diagnostico. */
    private String diagnostico;
    
    /** Lista de medicamentos recetados. */
    private List<Medicamento> medicamentos;
    
    /** Contador estatico para generar IDs. */
    private static int contadorIds = 1;
    
    /**
     * Constructor para crear una receta medica.
     * 
     * @param medico Nombre del medico
     * @param paciente Nombre del paciente
     */
    public RecetaMedica(String medico, String paciente) {
        this.idReceta = contadorIds++;
        this.medico = medico;
        this.paciente = paciente;
        this.fecha = LocalDate.now();
        this.medicamentos = new ArrayList<>();
        this.diagnostico = "";
    }
    
    /**
     * Agrega un medicamento a la receta.
     * 
     * @param medicamento Medicamento a agregar
     */
    public void agregarMedicamento(Medicamento medicamento) {
        if (!medicamentos.contains(medicamento)) {
            medicamentos.add(medicamento);
        }
    }
    
    // ==================== GETTERS ====================
    
    /** @return Identificador */
    public int getIdReceta() {
        return idReceta;
    }
    
    /** @return Medico */
    public String getMedico() {
        return medico;
    }
    
    /** @return Paciente */
    public String getPaciente() {
        return paciente;
    }
    
    /** @return Fecha */
    public LocalDate getFecha() {
        return fecha;
    }
    
    /** @return Diagnostico */
    public String getDiagnostico() {
        return diagnostico;
    }
    
    /** @param diagnostico Nuevo diagnostico */
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
    
    /** @return Lista de medicamentos */
    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }
    
    /**
     * Devuelve una representacion textual de la receta.
     * 
     * @return Cadena con informacion
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Receta #" + idReceta + " - Dr. " + medico + " - Paciente: " + paciente +
               " - Fecha: " + fecha.format(formatter) + " - " + medicamentos.size() + " medicamentos";
    }
    
}//fin de la clase