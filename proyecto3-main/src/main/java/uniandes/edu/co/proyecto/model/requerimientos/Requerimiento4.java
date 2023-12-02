package uniandes.edu.co.proyecto.model.requerimientos;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "resultados")
public class Requerimiento4 {

    @Id
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "capacidadTotal")
    private Integer capacidadTotal;

    @Column(name = "costoDelServicio")
    private BigDecimal costoDelServicio;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCapacidadTotal() {
        return capacidadTotal;
    }

    public void setCapacidadTotal(Integer capacidadTotal) {
        this.capacidadTotal = capacidadTotal;
    }

    public BigDecimal getCostoDelServicio() {
        return costoDelServicio;
    }

    public void setCostoDelServicio(BigDecimal costoDelServicio) {
        this.costoDelServicio = costoDelServicio;
    }
}