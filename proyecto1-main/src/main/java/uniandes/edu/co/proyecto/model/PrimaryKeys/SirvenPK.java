package uniandes.edu.co.proyecto.model.primaryKeys;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import uniandes.edu.co.proyecto.model.servicios.ProductoMenu;
import uniandes.edu.co.proyecto.model.servicios.RestauranteBar;

@Embeddable
public class SirvenPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_restaurante_bar", referencedColumnName = "id")
    private RestauranteBar id_restaurante_bar;

    @ManyToOne
    @JoinColumn(name = "id_producto", referencedColumnName = "id")
    private ProductoMenu id_producto;

    public SirvenPK() {
        super();
    }

    public SirvenPK(RestauranteBar id_restaurante_bar, ProductoMenu id_producto) {
        super();
        this.id_restaurante_bar = id_restaurante_bar;
        this.id_producto = id_producto;
    }

    /**
     * @return the id_restaurante_bar
     */
    public RestauranteBar getId_restaurante_bar() {
        return id_restaurante_bar;
    }

    /**
     * @param id_restaurante_bar the id_restaurante_bar to set
     */
    public void setId_restaurante_bar(RestauranteBar id_restaurante_bar) {
        this.id_restaurante_bar = id_restaurante_bar;
    }

    /**
     * @return the id_producto
     */
    public ProductoMenu getId_producto() {
        return id_producto;
    }

    /**
     * @param id_producto the id_producto to set
     */
    public void setId_producto(ProductoMenu id_producto) {
        this.id_producto = id_producto;
    }

}
