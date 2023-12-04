package com.example.demo.modelo;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class TipoHabitacionEmbedded {

    private String tipo;
    private int costo_por_noche;
    private int capacidad;
    private List<String> dotaciones;

    public TipoHabitacionEmbedded() {
    }

    public TipoHabitacionEmbedded(String tipo, int costo, int capacidad, List<String> dotaciones) {

        this.tipo = tipo;
        this.costo_por_noche = costo;
        this.capacidad = capacidad;
        this.dotaciones = dotaciones;
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

}
