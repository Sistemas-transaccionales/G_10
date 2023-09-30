package uniandes.edu.co.proyecto.model.servicios;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Spa extends Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer costo;
    private String duracion;

    public Spa() {
        super();
    }

    /**
     * @param tipo
     * @param nombre
     * @param costo
     * @param duracion
     * @param hora_inicio
     */
    public Spa(TipoServicio tipo, String nombre, Integer costo, String duracion) {
        super(tipo, nombre);
        this.costo = costo;
        this.duracion = duracion;
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
     * @return the costo
     */
    public Integer getCosto() {
        return costo;
    }

    /**
     * @param costo the costo to set
     */
    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    /**
     * @return the duracion
     */
    public String getDuracion() {
        return duracion;
    }

    /**
     * @param duracion the duracion to set
     */
    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

}
