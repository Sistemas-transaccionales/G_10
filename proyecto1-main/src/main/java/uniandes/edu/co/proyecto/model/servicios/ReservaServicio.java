package uniandes.edu.co.proyecto.model.servicios;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import uniandes.edu.co.proyecto.model.Habitacion;
import uniandes.edu.co.proyecto.model.primaryKeys.ReservaServicioPK;

@Entity
@Table(name = "reservas_servicio")
public class ReservaServicio {

    @EmbeddedId
    private ReservaServicioPK pk;

    public ReservaServicio() {
        ;
    }

    public ReservaServicio(Habitacion id_habitacion, Servicio id_servicio, Date fecha, Time hora_inicio, Time hora_fin,
            Integer costo) {
        this.pk = new ReservaServicioPK(id_habitacion, id_servicio, fecha, hora_inicio, hora_fin, costo);
    }

    /**
     * @return the pk
     */
    public ReservaServicioPK getPk() {
        return pk;
    }

    /**
     * @param pk the pk to set
     */
    public void setPk(ReservaServicioPK pk) {
        this.pk = pk;
    }

}
