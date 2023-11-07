package uniandes.edu.co.proyecto.model.requerimientos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "recoleccion")
public class Requerimiento1 {

    @Id
    @Column(name = "ID_Habitacion")
    private String idHabitacion;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Total_Ganancia")
    private int totalGanancia;

    public String getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(String idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre_habitacion) {
        this.nombre = nombre_habitacion;
    }

    public int getTotalGanancia() {
        return totalGanancia;
    }

    public void setTotalGanancia(int totalGanancia) {
        this.totalGanancia = totalGanancia;
    }
}