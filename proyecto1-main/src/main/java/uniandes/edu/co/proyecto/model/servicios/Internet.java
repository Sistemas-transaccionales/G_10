package uniandes.edu.co.proyecto.model.servicios;

import jakarta.persistence.Entity;

@Entity
public class Internet extends Servicio {

    private Integer capacidad;

    public Internet() {
        super();
    }

    public Internet(TipoServicio tipo, String nombre, Integer capacidad) {

        super(tipo, nombre);
        this.capacidad = capacidad;
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

}
