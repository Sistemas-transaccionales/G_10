package uniandes.edu.co.proyecto.model.servicios;

import java.sql.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Gimnasio extends Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    private Time hora_apertura;
    private Time hora_clausura;
    private Integer capacidad;

    public Gimnasio() {
        super();
    }

    public Gimnasio(TipoServicio tipo, String nombre, Time hora_apertura, Time hora_clausura, Integer capacidad) {

        super(tipo, nombre);
        this.hora_apertura = hora_apertura;
        this.hora_clausura = hora_clausura;
        this.capacidad = capacidad;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return Id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        Id = id;
    }

    /**
     * @return the hora_apertura
     */
    public Time getHora_apertura() {
        return hora_apertura;
    }

    /**
     * @param hora_apertura the hora_apertura to set
     */
    public void setHora_apertura(Time hora_apertura) {
        this.hora_apertura = hora_apertura;
    }

    /**
     * @return the hora_clausura
     */
    public Time getHora_clausura() {
        return hora_clausura;
    }

    /**
     * @param hora_clausura the hora_clausura to set
     */
    public void setHora_clausura(Time hora_clausura) {
        this.hora_clausura = hora_clausura;
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
