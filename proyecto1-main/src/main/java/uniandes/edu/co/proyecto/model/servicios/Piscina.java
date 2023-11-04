package uniandes.edu.co.proyecto.model.servicios;

import jakarta.persistence.Entity;

@Entity
public class Piscina extends Servicio {

    private Integer capacidad;
    private Float area;
    private Float profundidad;

    public Piscina() {
        super();
    }

    public Piscina(TipoServicio tipo, String nombre, Integer capacidad, Float area, Float profundidad) {

        super(tipo, nombre);
        this.capacidad = capacidad;
        this.area = area;
        this.profundidad = profundidad;
    }

    /**
     * @return the capacidad
     */
    public Integer getCapacidad() {
        return capacidad;
    }

    /**
     * @param capacidad the capacidad to set
     */
    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    /**
     * @return the area
     */
    public Float getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(Float area) {
        this.area = area;
    }

    /**
     * @return the profundidad
     */
    public Float getProfundidad() {
        return profundidad;
    }

    /**
     * @param profundidad the profundidad to set
     */
    public void setProfundidad(Float profundidad) {
        this.profundidad = profundidad;
    }

}
