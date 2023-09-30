package uniandes.edu.co.proyecto.model.servicios;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Salon extends Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String tipo_salon;
    private Integer capacidad;
    private Integer costo_por_hora;
    private Integer costo_extra;

    public Salon() {
        super();
    }

    /**
     * @param tipo
     * @param nombre
     * @param tipo_salon
     * @param capacidad
     * @param costo_por_hora
     * @param costo_extra
     */
    public Salon(TipoServicio tipo, String nombre, String tipo_salon, Integer capacidad, Integer costo_por_hora,
            Integer costo_extra) {
        super(tipo, nombre);
        this.tipo_salon = tipo_salon;
        this.capacidad = capacidad;
        this.costo_por_hora = costo_por_hora;
        this.costo_extra = costo_extra;
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
     * @return the tipo_salon
     */
    public String getTipo_salon() {
        return tipo_salon;
    }

    /**
     * @param tipo_salon the tipo_salon to set
     */
    public void setTipo_salon(String tipo_salon) {
        this.tipo_salon = tipo_salon;
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

    /**
     * @return the costo_por_hora
     */
    public Integer getCosto_por_hora() {
        return costo_por_hora;
    }

    /**
     * @param costo_por_hora the costo_por_hora to set
     */
    public void setCosto_por_hora(Integer costo_por_hora) {
        this.costo_por_hora = costo_por_hora;
    }

    /**
     * @return the costo_extra
     */
    public Integer getCosto_extra() {
        return costo_extra;
    }

    /**
     * @param costo_extra the costo_extra to set
     */
    public void setCosto_extra(Integer costo_extra) {
        this.costo_extra = costo_extra;
    }

}
