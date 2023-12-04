package main.java.com.example.demo.modelo;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class CheckIn {

    @Id
    private ObjectId id;

    @Field("id_habitacion")
    private String idHabitacion;

    @Field("usuario")
    private UsuarioEmbedded usuario;

    @Field("fecha_check_in")
    private String fechaCheckIn;

    @Field("fecha_check_out")
    private String fechaCheckOut;

    @Field("costo_reserva")
    private double costoReserva;

    public CheckIn() {
    }

    public CheckIn(ObjectId id, String idHabitacion, UsuarioEmbedded usuario, String fechaCheckIn,
            String fechaCheckOut, double costoReserva) {
        this.id = id;
        this.idHabitacion = idHabitacion;
        this.usuario = usuario;
        this.fechaCheckIn = fechaCheckIn;
        this.fechaCheckOut = fechaCheckOut;
        this.costoReserva = costoReserva;
    }

    /**
     * @return the id
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(ObjectId id) {
        this.id = id;
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
     * @return the usuario
     */
    public UsuarioEmbedded getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(UsuarioEmbedded usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the fechaCheckIn
     */
    public String getFechaCheckIn() {
        return fechaCheckIn;
    }

    /**
     * @param fechaCheckIn the fechaCheckIn to set
     */
    public void setFechaCheckIn(String fechaCheckIn) {
        this.fechaCheckIn = fechaCheckIn;
    }

    /**
     * @return the fechaCheckOut
     */
    public String getFechaCheckOut() {
        return fechaCheckOut;
    }

    /**
     * @param fechaCheckOut the fechaCheckOut to set
     */
    public void setFechaCheckOut(String fechaCheckOut) {
        this.fechaCheckOut = fechaCheckOut;
    }

    /**
     * @return the costoReserva
     */
    public double getCostoReserva() {
        return costoReserva;
    }

    /**
     * @param costoReserva the costoReserva to set
     */
    public void setCostoReserva(double costoReserva) {
        this.costoReserva = costoReserva;
    }
}
