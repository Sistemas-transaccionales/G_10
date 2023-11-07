package uniandes.edu.co.proyecto.model.requerimientos;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ocupacion")
public class Requerimiento6_1 {
    @Id
    @Column(name = "Fecha")
    private Date fecha;

    @Column(name = "Ocupacion")
    private int ocupacion;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(int ocupacion) {
        this.ocupacion = ocupacion;
    }
}