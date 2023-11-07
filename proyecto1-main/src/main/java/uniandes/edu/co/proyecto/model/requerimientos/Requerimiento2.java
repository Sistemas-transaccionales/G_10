package uniandes.edu.co.proyecto.model.requerimientos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "servicios_populares")
public class Requerimiento2 {

    @Id
    @Column(name = "id_servicio")
    private Integer id;

    @Column(name = "nombre_servicio")
    private String nombreServicio;

    @Column(name = "consumos")
    private int consumos;

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombre_servicio) {
        this.nombreServicio = nombre_servicio;
    }

    public int getConsumos() {
        return consumos;
    }

    public void setConsumos(int consumos) {
        this.consumos = consumos;
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