package uniandes.edu.co.proyecto.model.servicios;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PrestamoUtensilio extends Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String utensilio;
    private Integer costo_danio;

    public PrestamoUtensilio() {
        super();
    }

    public PrestamoUtensilio(TipoServicio tipo, String nombre, String utensilio, Integer costo_danio) {

        super(tipo, nombre);
        this.utensilio = utensilio;
        this.costo_danio = costo_danio;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the utensilio
     */
    public String getUtensilio() {
        return utensilio;
    }

    /**
     * @param utensilio the utensilio to set
     */
    public void setUtensilio(String utensilio) {
        this.utensilio = utensilio;
    }

    /**
     * @return the costo_danio
     */
    public Integer getCosto_danio() {
        return costo_danio;
    }

    /**
     * @param costo_danio the costo_danio to set
     */
    public void setCosto_danio(Integer costo_danio) {
        this.costo_danio = costo_danio;
    }

}
