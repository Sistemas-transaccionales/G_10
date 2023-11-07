package uniandes.edu.co.proyecto.model.requerimientos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "servicios_sin_demanda")
public class Requerimiento8 {

    @Id
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "consumos")
    private int consumos;

    @Column(name = "tasa_semanal")
    private int tasaSemanal;

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    /**
     * @return the tasaSemanal
     */
    public int getTasaSemanal() {
        return tasaSemanal;
    }

    /**
     * @param tasaSemanal the tasaSemanal to set
     */
    public void setTasaSemanal(int tasaSemanal) {
        this.tasaSemanal = tasaSemanal;
    }

}
