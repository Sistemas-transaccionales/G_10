package uniandes.edu.co.proyecto.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "check_ins")
public class CheckIn {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_habitacion", referencedColumnName = "id")
    private Habitacion id_habitacion;

    private Integer num_doc;
    private String tipo_doc;

    private Date fecha;
    private String hora;

    public CheckIn() {
        ;
    }

    /**
     * @param id_habitacion
     * @param id_usuario
     * @param fecha
     * @param hora
     */
    public CheckIn(Habitacion id_habitacion, Usuario cliente, Date fecha, String hora) {
        this.id_habitacion = id_habitacion;
        this.num_doc = cliente.getPk().getNum_doc();
        this.tipo_doc = cliente.getPk().getTipo_doc();
        this.fecha = fecha;
        this.hora = hora;
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
     * @return the hora
     */
    public String getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

}
