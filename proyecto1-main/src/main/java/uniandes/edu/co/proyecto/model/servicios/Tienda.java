package uniandes.edu.co.proyecto.model.servicios;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tienda extends Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String tipo_productos;

    public Tienda() {
        super();
    }

    /**
     * @param tipo
     * @param nombre
     * @param tipo_productos
     */
    public Tienda(TipoServicio tipo, String nombre, String tipo_productos) {
        super(tipo, nombre);
        this.tipo_productos = tipo_productos;
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
     * @return the tipo_productos
     */
    public String getTipo_productos() {
        return tipo_productos;
    }

    /**
     * @param tipo_productos the tipo_productos to set
     */
    public void setTipo_productos(String tipo_productos) {
        this.tipo_productos = tipo_productos;
    }

}
