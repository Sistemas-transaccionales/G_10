package uniandes.edu.co.proyecto.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "check_outs")
public class CheckOut {

    @Id
    private Integer id;

    @OneToOne
    @MapsId
    private CheckIn check_in;

    private Date fecha;
    private String hora;
    private Integer ingresos_totales;

    public CheckOut() {
        ;
    }

    /**
     * @param id_check_in
     * @param fecha
     * @param hora
     * @param ingresos_totales
     */
    public CheckOut(CheckIn check_in, Date fecha, String hora, Integer ingresos_totales) {
        this.id = check_in.getId();
        this.check_in = check_in;
        this.fecha = fecha;
        this.hora = hora;
        this.ingresos_totales = ingresos_totales;
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

    /**
     * @return the ingresos_totales
     */
    public Integer getIngresos_totales() {
        return ingresos_totales;
    }

    /**
     * @param ingresos_totales the ingresos_totales to set
     */
    public void setIngresos_totales(Integer ingresos_totales) {
        this.ingresos_totales = ingresos_totales;
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

}
