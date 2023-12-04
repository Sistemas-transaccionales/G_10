package com.example.demo.modelo;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Requerimiento3 {

    @Id
    private ObjectId id;

    @Field("id_servicio")
    private ObjectId idServicio;

    @Field("fecha")
    private String fecha;

    @Field("costo")
    private int costo;

    @Field("nombre_servicio")
    private String nombreServicio;

    @Field("tipo_doc")
    private String tipoDoc;

    @Field("num_doc")
    private String numDoc;

    public Requerimiento3() {
    }

    public Requerimiento3(ObjectId id, ObjectId idServicio, String nombreServicio, String tipoDoc, String numDoc,
            String fecha, int costo) {
        this.id = id;
        this.idServicio = idServicio;
        this.nombreServicio = nombreServicio;
        this.tipoDoc = tipoDoc;
        this.numDoc = numDoc;
        this.fecha = fecha;
        this.costo = costo;
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
     * @return the idServicio
     */
    public ObjectId getIdServicio() {
        return idServicio;
    }

    /**
     * @param idServicio the idServicio to set
     */
    public void setIdServicio(ObjectId idServicio) {
        this.idServicio = idServicio;
    }

    /**
     * @return the nombreServicio
     */
    public String getNombreServicio() {
        return nombreServicio;
    }

    /**
     * @param nombreServicio the nombreServicio to set
     */
    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    /**
     * @return the tipoDoc
     */
    public String getTipoDoc() {
        return tipoDoc;
    }

    /**
     * @param tipoDoc the tipoDoc to set
     */
    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    /**
     * @return the numDoc
     */
    public String getNumDoc() {
        return numDoc;
    }

    /**
     * @param numDoc the numDoc to set
     */
    public void setNumDoc(String numDoc) {
        this.numDoc = numDoc;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the costo
     */
    public int getCosto() {
        return costo;
    }

    /**
     * @param costo the costo to set
     */
    public void setCosto(int costo) {
        this.costo = costo;
    }

}
