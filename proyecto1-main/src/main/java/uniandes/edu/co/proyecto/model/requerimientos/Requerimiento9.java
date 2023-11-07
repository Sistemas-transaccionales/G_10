package uniandes.edu.co.proyecto.model.requerimientos;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "consumo")
public class Requerimiento9 {

    @Id
    @Column(name = "num_doc")
    private String numDoc;

    @Column(name = "tipo_doc")
    private String tipoDoc;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "cantidad")
    private int cantidad;

    public String getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(String numDoc) {
        this.numDoc = numDoc;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}