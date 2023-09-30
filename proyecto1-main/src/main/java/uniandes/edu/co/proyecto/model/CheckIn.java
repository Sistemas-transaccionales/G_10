package uniandes.edu.co.proyecto.model;

import java.sql.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "check_ins")
public class CheckIn {

    @Id
    @OneToOne
    @JoinColumn(name = "id_reserva", referencedColumnName = "id")
    private ReservaHabitacion id_reserva;

    private Time hora_llegada;

    public CheckIn() {
        ;
    }

    public CheckIn(ReservaHabitacion id_reserva, Time hora_llegada) {
        this.id_reserva = id_reserva;
        this.hora_llegada = hora_llegada;
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
     * @return the hora_llegada
     */
    public Time getHora_llegada() {
        return hora_llegada;
    }

    /**
     * @param hora_llegada the hora_llegada to set
     */
    public void setHora_llegada(Time hora_llegada) {
        this.hora_llegada = hora_llegada;
    }

}
