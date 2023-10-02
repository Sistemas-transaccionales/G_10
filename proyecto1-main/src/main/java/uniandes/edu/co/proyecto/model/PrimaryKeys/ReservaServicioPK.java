package uniandes.edu.co.proyecto.model.primaryKeys;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import uniandes.edu.co.proyecto.model.Habitacion;
import uniandes.edu.co.proyecto.model.servicios.Servicio;

@Embeddable
public class ReservaServicioPK implements Serializable {

    @MapsId("id")
    @ManyToOne
    @JoinColumn(name = "id_habitacion", referencedColumnName = "id")
    private Habitacion id_habitacion;

    @MapsId("id")
    @ManyToOne
    @JoinColumn(name = "id_servicio", referencedColumnName = "id")
    private Servicio id_servicio;

    private Date fecha;
    private String hora_inicio;
    private String hora_fin;
    private Integer costo;

    public ReservaServicioPK() {
        super();
    }

    /**
     * @param id_habitacion
     * @param id_servicio
     * @param fecha
     * @param hora_inicio
     * @param hora_fin
     * @param costo
     */
    public ReservaServicioPK(Habitacion id_habitacion, Servicio id_servicio, Date fecha, String hora_inicio,
            String hora_fin, Integer costo) {
        this.id_habitacion = id_habitacion;
        this.id_servicio = id_servicio;
        this.fecha = fecha;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
        this.costo = costo;
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
     * @return the id_servicio
     */
    public Servicio getId_servicio() {
        return id_servicio;
    }

    /**
     * @param id_servicio the id_servicio to set
     */
    public void setId_servicio(Servicio id_servicio) {
        this.id_servicio = id_servicio;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the hora_inicio
     */
    public String getHora_inicio() {
        return hora_inicio;
    }

    /**
     * @param hora_inicio the hora_inicio to set
     */
    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    /**
     * @return the hora_fin
     */
    public String getHora_fin() {
        return hora_fin;
    }

    /**
     * @param hora_fin the hora_fin to set
     */
    public void setHora_fin(String hora_fin) {
        this.hora_fin = hora_fin;
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

}
