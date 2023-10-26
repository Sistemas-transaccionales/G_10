package uniandes.edu.co.proyecto.model.PrimaryKeys;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import uniandes.edu.co.proyecto.model.TipoHabitacion;
import uniandes.edu.co.proyecto.model.Dotacion;

@Embeddable
public class DotadasPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_tipo_habitacion", referencedColumnName = "id")
    private TipoHabitacion id_tipo_habitacion;

    @ManyToOne
    @JoinColumn(name = "id_dotacion", referencedColumnName = "id")
    private Dotacion id_dotacion;

    public DotadasPK() {
        super();
    }

    public DotadasPK(TipoHabitacion id_tipo_habitacion, Dotacion id_dotacion) {

        super();
        this.id_tipo_habitacion = id_tipo_habitacion;
        this.id_dotacion = id_dotacion;
    }

    /**
     * @return the id_habitacion
     */
    public TipoHabitacion getId_tipo_habitacion() {
        return id_tipo_habitacion;
    }

    /**
     * @param id_habitacion the id_habitacion to set
     */
    public void setId_tipo_habitacion(TipoHabitacion id_tipo_habitacion) {
        this.id_tipo_habitacion = id_tipo_habitacion;
    }

    /**
     * @return the id_dotacion
     */
    public Dotacion getId_dotacion() {
        return id_dotacion;
    }

    /**
     * @param id_dotacion the id_dotacion to set
     */
    public void setId_dotacion(Dotacion id_dotacion) {
        this.id_dotacion = id_dotacion;
    }

}
