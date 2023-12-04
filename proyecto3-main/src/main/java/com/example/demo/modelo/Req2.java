package com.example.demo.modelo;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Req2 {

    private String idHabitacion;
    private int diasOcupados;
    private double tasaOcupacion;

    public Req2(String idHabitacion, int diasOcupados, double tasaOcupacion) {
        this.idHabitacion = idHabitacion;
        this.diasOcupados = diasOcupados;
        this.tasaOcupacion = tasaOcupacion;
    }

    public String getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(String idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public int getDiasOcupados() {
        return diasOcupados;
    }

    public void setDiasOcupados(int diasOcupados) {
        this.diasOcupados = diasOcupados;
    }

    public double getTasaOcupacion() {
        return tasaOcupacion;
    }

    public void setTasaOcupacion(double tasaOcupacion) {
        this.tasaOcupacion = tasaOcupacion;
    }
}