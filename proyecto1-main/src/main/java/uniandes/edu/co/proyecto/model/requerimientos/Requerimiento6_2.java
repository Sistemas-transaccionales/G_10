package uniandes.edu.co.proyecto.model.requerimientos;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ingresos")
public class Requerimiento6_2 {
    @Id
    @Column(name = "Fecha")
    private Date fecha;

    @Column(name = "Ingresos")
    private int ingresos;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIngresos() {
        return ingresos;
    }

    public void setIngresos(int ingresos) {
        this.ingresos = ingresos;
    }
}