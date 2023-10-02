package uniandes.edu.co.proyecto.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "check_ins")
public class CheckIn {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @MapsId("id")
    @ManyToOne
    @JoinColumn(name = "id_habitacion", referencedColumnName = "id")
    private Habitacion id_habitacion;

    @MapsId("id")
    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private Usuario id_usuario;

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
    public CheckIn(Habitacion id_habitacion, Usuario id_usuario, Date fecha, String hora) {
        this.id_habitacion = id_habitacion;
        this.id_usuario = id_usuario;
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
     * @return the id_usuario
     */
    public Usuario getId_usuario() {
        return id_usuario;
    }

    /**
     * @param id_usuario the id_usuario to set
     */
    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
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
