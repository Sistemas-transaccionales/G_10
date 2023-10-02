package uniandes.edu.co.proyecto.model.primaryKeys;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import uniandes.edu.co.proyecto.model.Habitacion;
import uniandes.edu.co.proyecto.model.Usuario;

@Embeddable
public class ReservaHabitacionPK implements Serializable {

    @MapsId("id")
    @ManyToOne
    @JoinColumn(name = "id_habitacion", referencedColumnName = "id")
    private Habitacion id_habitacion;

    @MapsId("id")
    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    private Usuario id_cliente;

    private Date fecha_entrada;
    private Date fecha_salida;

    public ReservaHabitacionPK() {
        super();
    }

    /**
     * @param id_habitacion
     * @param id_cliente
     * @param fecha_entrada
     * @param fecha_salida
     */
    public ReservaHabitacionPK(Habitacion id_habitacion, Usuario id_cliente, Date fecha_entrada, Date fecha_salida) {
        super();
        this.id_habitacion = id_habitacion;
        this.id_cliente = id_cliente;
        this.fecha_entrada = fecha_entrada;
        this.fecha_salida = fecha_salida;
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
     * @return the id_cliente
     */
    public Usuario getId_cliente() {
        return id_cliente;
    }

    /**
     * @param id_cliente the id_cliente to set
     */
    public void setId_cliente(Usuario id_cliente) {
        this.id_cliente = id_cliente;
    }

    /**
     * @return the fecha_entrada
     */
    public Date getFecha_entrada() {
        return fecha_entrada;
    }

    /**
     * @param fecha_entrada the fecha_entrada to set
     */
    public void setFecha_entrada(Date fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }

    /**
     * @return the fecha_salida
     */
    public Date getFecha_salida() {
        return fecha_salida;
    }

    /**
     * @param fecha_salida the fecha_salida to set
     */
    public void setFecha_salida(Date fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

}
