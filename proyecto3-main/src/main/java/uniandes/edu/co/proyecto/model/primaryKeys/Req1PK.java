package uniandes.edu.co.proyecto.model.primaryKeys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import uniandes.edu.co.proyecto.model.Habitacion;

@Embeddable
public class Req1PK {

    @ManyToOne
    @JoinColumn(name = "id_habitacion", referencedColumnName = "id")
    private Habitacion idHabitacion;

    @Column(name = "nombre_servicio")
    private String nombreServicio;

    /**
     * @return the id_habitacion
     */
    public Habitacion getIdHabitacion() {
        return idHabitacion;
    }

    /**
     * @param id_habitacion the id_habitacion to set
     */
    public void setIdHabitacion(Habitacion id_habitacion) {
        this.idHabitacion = id_habitacion;
    }

    /**
     * @return the nombre_servicio
     */
    public String getNombreServicio() {
        return nombreServicio;
    }

    /**
     * @param nombre_servicio the nombre_servicio to set
     */
    public void setNombreServicio(String nombre_servicio) {
        this.nombreServicio = nombre_servicio;
    }

}
