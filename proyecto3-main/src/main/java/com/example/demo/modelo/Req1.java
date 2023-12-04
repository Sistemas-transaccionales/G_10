package com.example.demo.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "recoleccion")
public class Req1 {

    @Id
    private String id;
    private String idHabitacion;
    private String nombreServicio;
    private String totalGanancia;

    public Req1(String id, String idHabitacion, String nombreServicio, String totalGanancia) {
        this.id = id;
        this.idHabitacion = idHabitacion;
        this.nombreServicio = nombreServicio;
        this.totalGanancia = totalGanancia;
    }

    public Req1(String idHabitacion, String nombreServicio, String totalGananciaStr) {
        this.idHabitacion = idHabitacion;
        this.nombreServicio = nombreServicio;
        this.totalGanancia = totalGananciaStr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(String idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public String getTotalGanancia() {
        return totalGanancia;
    }

    public void setTotalGanancia(String totalGanancia) {
        this.totalGanancia = totalGanancia;
    }
}