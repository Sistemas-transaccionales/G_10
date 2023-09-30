package uniandes.edu.co.proyecto.model.servicios;

import jakarta.persistence.Entity;

@Entity
public class Tienda extends Servicio {

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
