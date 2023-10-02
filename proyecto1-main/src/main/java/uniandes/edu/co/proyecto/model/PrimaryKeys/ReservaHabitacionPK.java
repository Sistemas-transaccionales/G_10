package uniandes.edu.co.proyecto.model.primaryKeys;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import uniandes.edu.co.proyecto.model.Habitacion;
import uniandes.edu.co.proyecto.model.Usuario;

@Embeddable
public class ReservaHabitacionPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_habitacion", referencedColumnName = "id")
    private Habitacion id_habitacion;

    private Integer num_doc;
    private String tipo_doc;

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
    public ReservaHabitacionPK(Habitacion id_habitacion, Usuario cliente, Date fecha_entrada, Date fecha_salida) {
        super();
        this.id_habitacion = id_habitacion;
        this.num_doc = cliente.getPk().getNum_doc();
        this.tipo_doc = cliente.getPk().getTipo_doc();
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
     * @return the num_doc
     */
    public Integer getNum_doc() {
        return num_doc;
    }

    /**
     * @param num_doc the num_doc to set
     */
    public void setNum_doc(Integer num_doc) {
        this.num_doc = num_doc;
    }

    /**
     * @return the tipo_doc
     */
    public String getTipo_doc() {
        return tipo_doc;
    }

    /**
     * @param tipo_doc the tipo_doc to set
     */
    public void setTipo_doc(String tipo_doc) {
        this.tipo_doc = tipo_doc;
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
