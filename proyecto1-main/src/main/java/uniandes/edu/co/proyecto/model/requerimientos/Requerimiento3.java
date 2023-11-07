package uniandes.edu.co.proyecto.model.requerimientos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "habitaciones")
public class Requerimiento3 {

    @Id
    @Column(name = "ID_Habitacion")
    private String idHabitacion;

    @Column(name = "Dias_Ocupados")
    private int diasOcupados;

    @Column(name = "Tasa_Ocupacion")
    private double tasaOcupacion;

    public String getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(String idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public int getDiasOcupados() {
        return diasOcupados;
    }

    public void setDiasOcupados(int diasOcupados) {
        this.diasOcupados = diasOcupados;
    }

    public double getTasaOcupacion() {
        return tasaOcupacion;
    }

    public void setTasaOcupacion(double tasaOcupacion) {
        this.tasaOcupacion = tasaOcupacion;
    }
}