package uniandes.edu.co.proyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipos_habitacion")
public class TipoHabitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nombre;
    private Integer costo_por_noche;
    private Integer capacidad;

    public TipoHabitacion() {
        ;
    }

    public TipoHabitacion(String nombre, Integer costo_por_noche, Integer capacidad) {
        this.nombre = nombre;
        this.costo_por_noche = costo_por_noche;
        this.capacidad = capacidad;
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
     * @return the costo_por_noche
     */
    public Integer getCosto_por_noche() {
        return costo_por_noche;
    }

    /**
     * @param costo_por_noche the costo_por_noche to set
     */
    public void setCosto_por_noche(Integer costo_por_noche) {
        this.costo_por_noche = costo_por_noche;
    }

    /**
     * @return the capacidad
     */
    public Integer getCapacidad() {
        return capacidad;
    }

    /**
     * @param capacidad the capacidad to set
     */
    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

}
