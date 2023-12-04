package com.example.demo.modelo;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "reservas_servicios")
public class ReservaServicio {

    @Id
    private ObjectId id;

    @Field("id_servicio")
    private String idServicio;

    @Field("id_reserva_habitacion")
    private String idReservaHabitacion;

    @Field("usuario")
    private Usuario usuario;

    @Field("fecha")
    private Date fecha;

    @Field("costo")
    private int costo;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(String idServicio) {
        this.idServicio = idServicio;
    }

    public String getIdReservaHabitacion() {
        return idReservaHabitacion;
    }

    public void setIdReservaHabitacion(String idReservaHabitacion) {
        this.idReservaHabitacion = idReservaHabitacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }
}