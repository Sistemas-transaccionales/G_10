package uniandes.edu.co.proyecto.model.servicios;

import java.sql.Time;

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
    private Time hora_inicio;

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
    public Spa(TipoServicio tipo, String nombre, Integer costo, String duracion, Time hora_inicio) {
        super(tipo, nombre);
        this.costo = costo;
        this.duracion = duracion;
        this.hora_inicio = hora_inicio;
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

    /**
     * @return the hora_inicio
     */
    public Time getHora_inicio() {
        return hora_inicio;
    }

    /**
     * @param hora_inicio the hora_inicio to set
     */
    public void setHora_inicio(Time hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

}
