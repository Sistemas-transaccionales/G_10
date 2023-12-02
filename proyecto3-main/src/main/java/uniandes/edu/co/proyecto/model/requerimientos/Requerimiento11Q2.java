package uniandes.edu.co.proyecto.model.requerimientos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "servicios_menos_consumidos")
public class Requerimiento11Q2 {

    @Id
    @Column(name = "semana")
    private int semana;

    @Column(name = "servicio_menos_consumido")
    private String nombreServicio;

    @Column(name = "consumos")
    private int consumos;

    /**
     * @return the semana
     */
    public int getSemana() {
        return semana;
    }

    /**
     * @param semana the semana to set
     */
    public void setSemana(int semana) {
        this.semana = semana;
    }

    /**
     * @return the idServicio
     */
    public String getNombreServicio() {
        return nombreServicio;
    }

    /**
     * @param idServicio the idServicio to set
     */
    public void setNombreServicio(String idServicio) {
        this.nombreServicio = idServicio;
    }

    /**
     * @return the consumos
     */
    public int getConsumos() {
        return consumos;
    }

    /**
     * @param consumos the consumos to set
     */
    public void setConsumos(int consumos) {
        this.consumos = consumos;
    }

}
