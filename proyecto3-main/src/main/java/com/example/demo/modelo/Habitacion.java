package com.example.demo.modelo;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "habitaciones")
public class Habitacion {

    @Id
    private String id;

    @Field("tipo")
    private TipoHabitacionEmbedded tipo;

    @Field("reservas")
    @DBRef
    private List<ReservaHabitacion> reservas;

    public Habitacion() {
    }

    public Habitacion(String id, TipoHabitacionEmbedded tipo, List<ReservaHabitacion> reservas) {

        this.id = id;
        this.tipo = tipo;
        this.reservas = reservas;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the tipo
     */
    public TipoHabitacionEmbedded getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(TipoHabitacionEmbedded tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the reservas
     */
    public List<ReservaHabitacion> getReservas() {
        return reservas;
    }

    /**
     * @param reservas the reservas to set
     */
    public void setReservas(List<ReservaHabitacion> reservas) {
        this.reservas = reservas;
    }

    /**
     * @param reserva the reserva to add
     */
    public void addReserva(ReservaHabitacion reserva) {
        this.reservas.add(reserva);
    }

}
