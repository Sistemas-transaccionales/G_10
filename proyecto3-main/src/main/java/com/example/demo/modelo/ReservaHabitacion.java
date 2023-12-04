package com.example.demo.modelo;

import java.time.LocalDate;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "reservas_habitaciones")
public class ReservaHabitacion {

    @Id
    private ObjectId id;

    @Field("id_habitacion")
    private String idHabitacion;

    @Field("usuario")
    private UsuarioEmbedded usuario;

    @Field("fecha_inicio")
    private LocalDate fechaInicio;

    @Field("fecha_fin")
    private LocalDate fechaFin;

    @Field("num_personas")
    private int numPersonas;

    @Field("plan_consumo")
    private PlanConsumoEmbedded planConsumo;

    @Field("costo_reserva")
    private double costoReserva;

    @Field("costo_consumos")
    private double costoConsumos;

    @Field("cuenta_abierta")
    private boolean cuentaAbierta;

    @Field("fecha_check_in")
    private LocalDate fechaCheckIn;

    @Field("fecha_check_out")
    private LocalDate fechaCheckOut;

    public ReservaHabitacion() {
    }

    public ReservaHabitacion(String idHabitacion, UsuarioEmbedded usuario, LocalDate fechaInicio,
            LocalDate fechaFin, int numPersonas, PlanConsumoEmbedded planConsumo, double costoReserva,
            double costoConsumos, boolean cuentaAbierta, LocalDate fechaCheckIn, LocalDate fechaCheckOut) {

        this.idHabitacion = idHabitacion;
        this.usuario = usuario;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.numPersonas = numPersonas;
        this.planConsumo = planConsumo;
        this.costoReserva = costoReserva;
        this.costoConsumos = costoConsumos;
        this.cuentaAbierta = cuentaAbierta;
        this.fechaCheckIn = fechaCheckIn;
        this.fechaCheckOut = fechaCheckOut;
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
     * @return the fechaInicio
     */
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return the fechaFin
     */
    public LocalDate getFechaFin() {
        return fechaFin;
    }

    /**
     * @param fechaFin the fechaFin to set
     */
    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * @return the numPersonas
     */
    public int getNumPersonas() {
        return numPersonas;
    }

    /**
     * @param numPersonas the numPersonas to set
     */
    public void setNumPersonas(int numPersonas) {
        this.numPersonas = numPersonas;
    }

    /**
     * @return the planConsumo
     */
    public PlanConsumoEmbedded getPlanConsumo() {
        return planConsumo;
    }

    /**
     * @param planConsumo the planConsumo to set
     */
    public void setPlanConsumo(PlanConsumoEmbedded planConsumo) {
        this.planConsumo = planConsumo;
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

    /**
     * @return the costoConsumos
     */
    public double getCostoConsumos() {
        return costoConsumos;
    }

    /**
     * @param costoConsumos the costoConsumos to set
     */
    public void setCostoConsumos(double costoConsumos) {
        this.costoConsumos = costoConsumos;
    }

    /**
     * @return the cuentaAbierta
     */
    public boolean isCuentaAbierta() {
        return cuentaAbierta;
    }

    /**
     * @param cuentaAbierta the cuentaAbierta to set
     */
    public void setCuentaAbierta(boolean cuentaAbierta) {
        this.cuentaAbierta = cuentaAbierta;
    }

    /**
     * @return the fechaCheckIn
     */
    public LocalDate getFechaCheckIn() {
        return fechaCheckIn;
    }

    /**
     * @param fechaCheckIn the fechaCheckIn to set
     */
    public void setFechaCheckIn(LocalDate fechaCheckIn) {
        this.fechaCheckIn = fechaCheckIn;
    }

    /**
     * @return the fechaCheckOut
     */
    public LocalDate getFechaCheckOut() {
        return fechaCheckOut;
    }

    /**
     * @param fechaCheckOut the fechaCheckOut to set
     */
    public void setFechaCheckOut(LocalDate fechaCheckOut) {
        this.fechaCheckOut = fechaCheckOut;
    }

}
