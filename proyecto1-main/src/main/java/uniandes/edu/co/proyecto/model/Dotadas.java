package uniandes.edu.co.proyecto.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import uniandes.edu.co.proyecto.model.PrimaryKeys.DotadasPK;

@Entity
@Table(name = "dotadas")
public class Dotadas {

    @EmbeddedId
    private DotadasPK pk;

    public Dotadas() {
        ;
    }

    public Dotadas(TipoHabitacion id_tipo_habitacion, Dotacion id_dotacion) {
        this.pk = new DotadasPK(id_tipo_habitacion, id_dotacion);
    }

    /**
     * @return the pk
     */
    public DotadasPK getPk() {
        return pk;
    }

    /**
     * @param pk the pk to set
     */
    public void setPk(DotadasPK pk) {
        this.pk = pk;
    }

}
