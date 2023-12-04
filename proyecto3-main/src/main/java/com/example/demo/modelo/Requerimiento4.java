package com.example.demo.modelo;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "consumo")
public class Requerimiento4 {

    @Id
    private ObjectId id;

    private String id_habitacion;
    private Usuario usuario;
    private Date fecha_inicio;
    private Date fecha_fin;
    private int num_personas;
    private PlanConsumoEmbedded plan_consumo;
    private double costo_reserva;
    private int costo_consumos;
    private boolean cuenta_abierta;
    private Date fecha_check_in;
    private Date fecha_check_out;

    // Constructor, getters, and setters
    public Requerimiento4() {
    }

    public Requerimiento4(ObjectId id, String id_habitacion, Usuario usuario, Date fecha_inicio, Date fecha_fin,
            int num_personas, PlanConsumoEmbedded plan_consumo, double costo_reserva, int costo_consumos,
            boolean cuenta_abierta, Date fecha_check_in, Date fecha_check_out) {
        this.id = id;
        this.id_habitacion = id_habitacion;
        this.usuario = usuario;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.num_personas = num_personas;
        this.plan_consumo = plan_consumo;
        this.costo_reserva = costo_reserva;
        this.costo_consumos = costo_consumos;
        this.cuenta_abierta = cuenta_abierta;
        this.fecha_check_in = fecha_check_in;
        this.fecha_check_out = fecha_check_out;
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
     * @return the id_habitacion
     */
    public String getId_habitacion() {
        return id_habitacion;
    }

    /**
     * @param id_habitacion the id_habitacion to set
     */
    public void setId_habitacion(String id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the fecha_inicio
     */
    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    /**
     * @param fecha_inicio the fecha_inicio to set
     */
    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    /**
     * @return the fecha_fin
     */
    public Date getFecha_fin() {
        return fecha_fin;
    }

    /**
     * @param fecha_fin the fecha_fin to set
     */
    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    /**
     * @return the num_personas
     */
    public int getNum_personas() {
        return num_personas;
    }

    /**
     * @param num_personas the num_personas to set
     */
    public void setNum_personas(int num_personas) {
        this.num_personas = num_personas;
    }

    /**
     * @return the plan_consumo
     */
    public PlanConsumoEmbedded getPlan_consumo() {
        return plan_consumo;
    }

    /**
     * @param plan_consumo the plan_consumo to set
     */
    public void setPlan_consumo(PlanConsumoEmbedded plan_consumo) {
        this.plan_consumo = plan_consumo;
    }

    /**
     * @return the costo_reserva
     */
    public double getCosto_reserva() {
        return costo_reserva;
    }

    /**
     * @param costo_reserva the costo_reserva to set
     */
    public void setCosto_reserva(double costo_reserva) {
        this.costo_reserva = costo_reserva;
    }

    /**
     * @return the costo_consumos
     */
    public int getCosto_consumos() {
        return costo_consumos;
    }

    /**
     * @param costo_consumos the costo_consumos to set
     */
    public void setCosto_consumos(int costo_consumos) {
        this.costo_consumos = costo_consumos;
    }

    /**
     * @return the cuenta_abierta
     */
    public boolean isCuenta_abierta() {
        return cuenta_abierta;
    }

    /**
     * @param cuenta_abierta the cuenta_abierta to set
     */
    public void setCuenta_abierta(boolean cuenta_abierta) {
        this.cuenta_abierta = cuenta_abierta;
    }

    /**
     * @return the fecha_check_in
     */
    public Date getFecha_check_in() {
        return fecha_check_in;
    }

    /**
     * @param fecha_check_in the fecha_check_in to set
     */
    public void setFecha_check_in(Date fecha_check_in) {
        this.fecha_check_in = fecha_check_in;
    }

    /**
     * @return the fecha_check_out
     */
    public Date getFecha_check_out() {
        return fecha_check_out;
    }

    /**
     * @param fecha_check_out the fecha_check_out to set
     */
    public void setFecha_check_out(Date fecha_check_out) {
        this.fecha_check_out = fecha_check_out;
    }

}
