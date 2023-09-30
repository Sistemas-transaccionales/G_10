package uniandes.edu.co.proyecto.model.servicios;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import uniandes.edu.co.proyecto.model.primaryKeys.SirvenPK;

@Entity
@Table(name = "sirven")
public class Sirven {

    @EmbeddedId
    private SirvenPK pk;

    public Sirven() {
        ;
    }

    public Sirven(RestauranteBar id_restaurante_bar, ProductoMenu id_producto) {
        this.pk = new SirvenPK(id_restaurante_bar, id_producto);
    }

    /**
     * @return the pk
     */
    public SirvenPK getPk() {
        return pk;
    }

    /**
     * @param pk the pk to set
     */
    public void setPk(SirvenPK pk) {
        this.pk = pk;
    }

}
