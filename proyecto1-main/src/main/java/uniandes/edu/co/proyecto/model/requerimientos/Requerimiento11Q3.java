package uniandes.edu.co.proyecto.model.requerimientos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "habitaciones_mas_solicitadas")
public class Requerimiento11Q3 {

    @Id
    @Column(name = "semana")
    private int semana;

    @Column(name = "habitacion_mas_solicitada")
    private String idHabitacion;

    @Column(name = "reservaciones")
    private int reservaciones;

    /**
     * @return the semana
     */
    public int getSemana() {
        return semana;
    }

    /**
     * @param semana the semana to set
     */
    public void setSemana(int semana) {
        this.semana = semana;
    }

    /**
     * @return the idHabitacion
     */
    public String getIdHabitacion() {
        return idHabitacion;
    }

    /**
     * @param idHabitacion the idHabitacion to set
     */
    public void setIdHabitacion(String idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    /**
     * @return the reservaciones
     */
    public int getReservaciones() {
        return reservaciones;
    }

    /**
     * @param reservaciones the reservaciones to set
     */
    public void setReservaciones(int reservaciones) {
        this.reservaciones = reservaciones;
    }

}
