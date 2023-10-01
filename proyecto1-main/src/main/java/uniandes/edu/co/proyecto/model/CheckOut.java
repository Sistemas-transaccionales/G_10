package uniandes.edu.co.proyecto.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "check_outs")
public class CheckOut {

    @Id
    @OneToOne
    @JoinColumn(name = "id_check_in", referencedColumnName = "id")
    private CheckIn id_check_in;

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
    public CheckOut(CheckIn id_check_in, Date fecha, String hora, Integer ingresos_totales) {
        this.id_check_in = id_check_in;
        this.fecha = fecha;
        this.hora = hora;
        this.ingresos_totales = ingresos_totales;
    }

    /**
     * @return the id_check_in
     */
    public CheckIn getId_check_in() {
        return id_check_in;
    }

    /**
     * @param id_check_in the id_check_in to set
     */
    public void setId_check_in(CheckIn id_check_in) {
        this.id_check_in = id_check_in;
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

}
