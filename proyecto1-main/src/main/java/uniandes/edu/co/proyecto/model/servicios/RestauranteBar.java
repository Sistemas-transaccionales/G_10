package uniandes.edu.co.proyecto.model.servicios;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RestauranteBar extends Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String estilo;
    private Boolean es_bar;
    private String horario;
    private Integer capacidad;

    public RestauranteBar() {
        super();
    }

    /**
     * @param tipo
     * @param nombre
     * @param estilo
     * @param es_bar
     * @param horario
     * @param capacidad
     */
    public RestauranteBar(TipoServicio tipo, String nombre, String estilo, Boolean es_bar, String horario,
            Integer capacidad) {
        super(tipo, nombre);
        this.estilo = estilo;
        this.es_bar = es_bar;
        this.horario = horario;
        this.capacidad = capacidad;
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
     * @return the estilo
     */
    public String getEstilo() {
        return estilo;
    }

    /**
     * @param estilo the estilo to set
     */
    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    /**
     * @return the es_bar
     */
    public Boolean getEs_bar() {
        return es_bar;
    }

    /**
     * @param es_bar the es_bar to set
     */
    public void setEs_bar(Boolean es_bar) {
        this.es_bar = es_bar;
    }

    /**
     * @return the horario
     */
    public String getHorario() {
        return horario;
    }

    /**
     * @param horario the horario to set
     */
    public void setHorario(String horario) {
        this.horario = horario;
    }

    /**
     * @return the capacidad
     */
    public Integer getCapacidad() {
        return capacidad;
    }

    /**
     * @param capacidad the capacidad to set
     */
    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

}
