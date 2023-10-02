package uniandes.edu.co.proyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "habitaciones")
public class Habitacion {

    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "tipo", referencedColumnName = "id")
    private TipoHabitacion tipo;

    public Habitacion() {
        ;
    }

    public Habitacion(String id, TipoHabitacion tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the tipo
     */
    public TipoHabitacion getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(TipoHabitacion tipo) {
        this.tipo = tipo;
    }

}
