package com.example.demo.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "servicios")
public class Servicio {

    @Id
    private String id;

    @Field("nombre")
    private String nombre;

    @Field("horario")
    private String horario;

    @Field("capacidad")
    private Integer capacidad;

    @DBRef
    private List<String> reservas;

    public Servicio() {
    }

    public Servicio(String id, String nombre, String horario, Integer capacidad, List<String> reservas) {
        this.id = id;
        this.nombre = nombre;
        this.horario = horario;
        this.capacidad = capacidad;
        this.reservas = reservas;
    }

    public Servicio(String id, String nombre, String horario, Integer capacidad) {
        this.id = id;
        this.nombre = nombre;
        this.horario = horario;
        this.capacidad = capacidad;
        this.reservas = new ArrayList<>();
    }

    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getHorario() {
        return horario;
    }
    
    public void setHorario(String horario) {
        this.horario = horario;
    }
    
    public Integer getCapacidad() {
        return capacidad;
    }
    
    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }
    
    public List<String> getReservas() {
        return reservas;
    }
    
    public void setReservas(List<String> reservas) {
        this.reservas = reservas;
    }
    
    public void addReserva(String reserva) {
        this.reservas.add(reserva);
    }
 }