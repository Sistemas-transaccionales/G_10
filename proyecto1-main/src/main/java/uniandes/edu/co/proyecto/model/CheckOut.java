package uniandes.edu.co.proyecto.model;

import java.sql.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "check_outs")
public class CheckOut {

    @Id
    @OneToOne
    @JoinColumn(name = "id_reserva", referencedColumnName = "id")
    private ReservaHabitacion id_reserva;

    private Time hora_salida;
    private Integer ingresos_totales;

    public CheckOut() {
        ;
    }

    public CheckOut(ReservaHabitacion id_reserva, Time hora_salida, Integer ingresos_totales_hotel) {
        this.id_reserva = id_reserva;
        this.hora_salida = hora_salida;
        this.ingresos_totales = ingresos_totales_hotel;
    }

    /**
     * @return the id_reserva
     */
    public ReservaHabitacion getId_reserva() {
        return id_reserva;
    }

    /**
     * @param id_reserva the id_reserva to set
     */
    public void setId_reserva(ReservaHabitacion id_reserva) {
        this.id_reserva = id_reserva;
    }

    /**
     * @return the hora_salida
     */
    public Time getHora_salida() {
        return hora_salida;
    }

    /**
     * @param hora_salida the hora_salida to set
     */
    public void setHora_salida(Time hora_salida) {
        this.hora_salida = hora_salida;
    }

    /**
     * @return the ingresos_totales
     */
    public Integer getIngresos_totales() {
        return ingresos_totales;
    }

    /**
     * @param ingresos_totales the ingresos_totales to set
     */
    public void setIngresos_totales(Integer ingresos_totales) {
        this.ingresos_totales = ingresos_totales;
    }

}
