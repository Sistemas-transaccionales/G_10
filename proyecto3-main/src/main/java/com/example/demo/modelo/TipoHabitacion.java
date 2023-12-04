package com.example.demo.modelo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "tipo_habitaciones")
public class TipoHabitacion {

    @Id
    private String tipo;

    @Field("costo_por_noche")
    private int costo_por_noche;

    @Field("capacidad")
    private int capacidad;

    @Field("dotaciones")
    private List<String> dotaciones;

    @Field("habitaciones")
    private List<String> habitaciones;

    public TipoHabitacion() {
    }

    public TipoHabitacion(String tipo, int costo_por_noche, int capacidad, List<String> dotaciones,
            List<String> habitaciones) {
        this.tipo = tipo;
        this.costo_por_noche = costo_por_noche;
        this.capacidad = capacidad;
        this.dotaciones = dotaciones;
        this.habitaciones = habitaciones;
    }

    public TipoHabitacion(String tipo, int costo_por_noche, int capacidad, List<String> dotaciones) {
        this.tipo = tipo;
        this.costo_por_noche = costo_por_noche;
        this.capacidad = capacidad;
        this.dotaciones = dotaciones;
        this.habitaciones = new ArrayList<String>();
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the costo_por_noche
     */
    public int getCosto_por_noche() {
        return costo_por_noche;
    }

    /**
     * @param costo_por_noche the costo_por_noche to set
     */
    public void setCosto_por_noche(int costo_por_noche) {
        this.costo_por_noche = costo_por_noche;
    }

    /**
     * @return the capacidad
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     * @param capacidad the capacidad to set
     */
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    /**
     * @return the dotaciones
     */
    public List<String> getDotaciones() {
        return dotaciones;
    }

    /**
     * @param dotaciones the dotaciones to set
     */
    public void setDotaciones(List<String> dotaciones) {
        this.dotaciones = dotaciones;
    }

    /**
     * @return the habitaciones
     */
    public List<String> getHabitaciones() {
        return habitaciones;
    }

    /**
     * @param habitaciones the habitaciones to set
     */
    public void setHabitaciones(List<String> habitaciones) {
        this.habitaciones = habitaciones;
    }

    /**
     * @param habitacion the habitacion to add
     */
    public void addHabitacion(String habitacion) {
        this.habitaciones.add(habitacion);
    }

}
