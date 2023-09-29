package uniandes.edu.co.proyecto.model.PrimaryKeys;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import uniandes.edu.co.proyecto.model.Habitacion;
import uniandes.edu.co.proyecto.model.Dotacion;

@Embeddable
public class DotadasPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_habitacion", referencedColumnName = "id")
    private Habitacion id_habitacion;

    @ManyToOne
    @JoinColumn(name = "id_dotacion", referencedColumnName = "id")
    private Dotacion id_dotacion;

    public DotadasPK() {
        super();
    }

    public DotadasPK(Habitacion id_habitacion, Dotacion id_dotacion) {

        super();
        this.id_habitacion = id_habitacion;
        this.id_dotacion = id_dotacion;
    }

    /**
     * @return the id_habitacion
     */
    public Habitacion getId_habitacion() {
        return id_habitacion;
    }

    /**
     * @param id_habitacion the id_habitacion to set
     */
    public void setId_habitacion(Habitacion id_habitacion) {
        this.id_habitacion = id_habitacion;
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
